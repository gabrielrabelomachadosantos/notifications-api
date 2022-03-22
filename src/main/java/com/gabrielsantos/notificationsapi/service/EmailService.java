package com.gabrielsantos.notificationsapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void notifyUserRegisteredPurchase(String email, String productName) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setFrom("no-reply.gabrielsantos@gmail.com");
        message.setSubject("Purchase Successfully Registered");
        message.setText(productName +
                "\nWe received your purchase and now we are validating it." +
                "\nAs soon as we confirm that everything is ok with your payment information you will receive another email confirming the payment." +
                "\nThank you for buying with us!!!");

        javaMailSender.send(message);

    }

    public void notifyUserApprovedPurchase(String email, String productName) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setFrom("no-reply.gabrielsantos@gmail.com");
        message.setSubject("Approved Purchase!");
        message.setText(productName +
                "\nYour purchase has been approved and soon will be receiving the delivery information." +
                "\nThank you for buying with us!!!");

        javaMailSender.send(message);

    }

    public void notifyUserReprovedPurchase(String email, String productName) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setFrom("no-reply.gabrielsantos@gmail.com");
        message.setSubject("Purchase Reproved :(");
        message.setText(productName +
                "\nThere was a problem during the validation of your credit card." +
                "\nPlease check your credit card information and try again.");

        javaMailSender.send(message);

    }

}
