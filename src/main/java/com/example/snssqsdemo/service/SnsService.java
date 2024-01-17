package com.example.snssqsdemo.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SnsService {

    @Value("${cloud.aws.sns.topic}")
    private String snsTopicArn;

    private final AmazonSNS amazonSNS;

    public SnsService(AmazonSNS amazonSNS) {
        this.amazonSNS = amazonSNS;
    }

    public void publishMessage(String message) {
        PublishRequest request = new PublishRequest(snsTopicArn, message);
        amazonSNS.publish(request);
    }
}


