package com.abrahambueno.cars;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.bridge.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogConsumer {
    @RabbitListener(queues = CarsApplication.QUEUE_NAME)
    public void consumeMessage(final Message cm) {
        log.info("Data loaded: ", cm.toString());
    }

}
