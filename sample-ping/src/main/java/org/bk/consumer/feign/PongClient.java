package org.bk.consumer.feign;

import org.bk.consumer.domain.Message;
import org.bk.consumer.domain.MessageAcknowledgement;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="sample-pong"/*, fallback = PongClientFallback.class*/)
public interface PongClient {

    @RequestMapping(method = RequestMethod.POST, value = "/message",
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    MessageAcknowledgement sendMessage(Message message);

}

