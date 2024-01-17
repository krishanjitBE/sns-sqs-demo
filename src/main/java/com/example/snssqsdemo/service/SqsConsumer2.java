package com.example.snssqsdemo.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SqsConsumer2 {

    @Value("${cloud.aws.sqs.queue2}")
    private String queueUrl;

    private final AmazonSQS amazonSQS;

    public SqsConsumer2(AmazonSQS amazonSQS) {
        this.amazonSQS = amazonSQS;
    }

    @Scheduled(fixedRate = 5000)
    public void consumeMessages() {
        List<Message> messages = amazonSQS.receiveMessage(queueUrl).getMessages();
        for (Message message : messages) {
            System.out.println("Consumer 2 received message: " + message.getBody());
            amazonSQS.deleteMessage(queueUrl, message.getReceiptHandle());
        }
    }
}
