package com.ms.email.consumer;

import com.ms.email.dto.EmailRecordDto;
import com.ms.email.models.Email;
import com.ms.email.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "${broker.queue.email.name}" )
    public void listenEmailQueue(@Payload EmailRecordDto emailRecordDto) {
       var emailModel = new Email();
        BeanUtils.copyProperties(emailRecordDto,emailModel);
        emailService.sendEmail(emailModel);
    }
}
