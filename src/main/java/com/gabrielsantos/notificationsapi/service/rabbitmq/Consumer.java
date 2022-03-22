package com.gabrielsantos.notificationsapi.service.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabrielsantos.notificationsapi.dto.PurchaseDTO;
import com.gabrielsantos.notificationsapi.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Consumer {

    private final ObjectMapper objectMapper;

    private final EmailService emailService;

    private final Producer producer;

    @SneakyThrows
    @RabbitListener(queues = {"${spring.rabbitmq.queue.registered-purchase}"})
    public void consumerRegisteredPurchase(@Payload Message message) {
        PurchaseDTO purchaseDTO = objectMapper.readValue(message.getBody(), PurchaseDTO.class);

        emailService.notifyUserRegisteredPurchase(purchaseDTO.getBuyerEmail(), purchaseDTO.getProduct().getDescription());

        producer.sendToPendingPurchaseQueue(purchaseDTO);
    }

    @SneakyThrows
    @RabbitListener(queues = {"${spring.rabbitmq.queue.approved-purchase}"})
    public void consumerApprovedPurchase(@Payload Message message) {
        PurchaseDTO purchaseDTO = objectMapper.readValue(message.getBody(), PurchaseDTO.class);

        emailService.notifyUserApprovedPurchase(purchaseDTO.getBuyerEmail(), purchaseDTO.getProduct().getDescription());
    }

    @SneakyThrows
    @RabbitListener(queues = {"${spring.rabbitmq.queue.reproved-purchase}"})
    public void consumerReprovedPurchase(@Payload Message message) {
        PurchaseDTO purchaseDTO = objectMapper.readValue(message.getBody(), PurchaseDTO.class);

        emailService.notifyUserReprovedPurchase(purchaseDTO.getBuyerEmail(), purchaseDTO.getProduct().getDescription());
    }

}
