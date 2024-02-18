package com.ead.authuser.publisher;

import com.ead.authuser.dtos.UserEventDTO;
import com.ead.authuser.enums.ActionType;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class UserEventPublisher {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${ead.broker.exchange.userEvent}")
    private String exchangeUserEvent;

    public void publisherUserEvent(UserEventDTO userEventDTO, ActionType actionType){
        userEventDTO.setActionType(actionType.toString());
        rabbitTemplate.convertAndSend(exchangeUserEvent, "", userEventDTO);

        log.info("[USER EVENT PUBLISHER] user sended to exchange {}", userEventDTO.getUserId());
    }

}