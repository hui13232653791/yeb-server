package com.wangyh.server.task;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.wangyh.server.pojo.Employee;
import com.wangyh.server.pojo.MailConstants;
import com.wangyh.server.pojo.MailLog;
import com.wangyh.server.service.IEmployeeService;
import com.wangyh.server.service.IMailLogService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 邮件重试发送定时任务
 */
@Component
public class MailTask {
    @Autowired
    private IMailLogService mailLogService;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private IEmployeeService employeeService;

    /**
     * 邮件重试发送定时任务
     * 10秒一次
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void mailTask() {
        //状态为0且重试时间小于当前时间的才需要重新发送
        List<MailLog> list = mailLogService.list(new QueryWrapper<MailLog>().eq("status", 0).lt("tryTime", LocalDateTime.now()));
        list.forEach(mailLog -> {
            //重试次数超过3次，更新为投递失败，不再重试
            if (3 <= mailLog.getCount()) {
                mailLogService.update(new UpdateWrapper<MailLog>().set("status", 2).eq("msgId", mailLog.getMsgId()));
            }
            //更新重试次数，更新时间，重试时间
            mailLogService.update(new UpdateWrapper<MailLog>().set("count", mailLog.getCount() + 1).set("updateTime", LocalDateTime.now()).set("tryTime", LocalDateTime.now().plusMinutes(MailConstants.MSG_TIMEOUT)).eq("msgId", mailLog.getMsgId()));
            Employee emp = employeeService.getEmployee(mailLog.getEid()).get(0);
            //重试发送消息
            rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME, MailConstants.MAIL_ROUTING_KEY_NAME, emp, new CorrelationData(mailLog.getMsgId()));
        });
    }

}
