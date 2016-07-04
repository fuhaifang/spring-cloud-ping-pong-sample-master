package org.bk.consumer;

import org.bk.noscan.consumer.ribbon.PongDirectCallRibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.metrics.atlas.EnableAtlas;
import org.springframework.cloud.netflix.metrics.servo.DimensionalServoMetricNaming;
import org.springframework.cloud.netflix.metrics.servo.HierarchicalServoMetricNaming;
import org.springframework.cloud.netflix.metrics.servo.ServoMetricNaming;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
//@EnableZuulProxy
@EnableHystrix
//@RibbonClients({
//        @RibbonClient(name = "samplepongdirect", configuration = PongDirectCallRibbonConfiguration.class),
//})
//@EnableAtlas
public class PingApplication {

    @Bean
    public ServoMetricNaming servoMetricNaming() {
        return new DimensionalServoMetricNaming();
    }

    public static void main(String[] args) {
        SpringApplication.run(PingApplication.class, args);
    }

}
