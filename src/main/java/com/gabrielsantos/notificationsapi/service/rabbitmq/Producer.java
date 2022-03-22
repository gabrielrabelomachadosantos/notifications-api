package com.gabrielsantos.notificationsapi.service.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabrielsantos.notificationsapi.dto.PurchaseDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    private final ObjectMapper objectMapper;

    @Value(value = "${spring.rabbitmq.queue.pending-purchase}")
    private String pendingPurchaseQueue;

    @SneakyThrows
    public void sendToPendingPurchaseQueue(PurchaseDTO purchaseDTO) {
        rabbitTemplate.convertAndSend(pendingPurchaseQueue, objectMapper.writeValueAsString(purchaseDTO));
    }

}
