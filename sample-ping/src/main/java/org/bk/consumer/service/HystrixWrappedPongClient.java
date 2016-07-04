package org.bk.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;

import org.bk.consumer.domain.Message;
import org.bk.consumer.domain.MessageAcknowledgement;
import org.bk.consumer.feign.PongClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("hystrixPongClient")
public class HystrixWrappedPongClient implements PongClient {

    @Autowired
    //@Qualifier("samplepongFeignClient")
    //@Qualifier("ribbonPongClient")
    private PongClient pongClient;

    @HystrixCommand(groupKey = "pongGroup", fallbackMethod = "fallBackCall", commandProperties=@HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS,value ="10000"))
    public MessageAcknowledgement sendMessage(Message message) {
    	System.out.println("------------------"+Thread.currentThread().getName()+"---------------");
        return this.pongClient.sendMessage(message);
    }

    public MessageAcknowledgement fallBackCall(Message message) {
        MessageAcknowledgement fallback = new MessageAcknowledgement(message.getId(), message.getPayload(), "FAILED SERVICE CALL! - FALLING BACK");
        return fallback;
    }
}
