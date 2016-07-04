package org.bk.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.cloud.netflix.metrics.servo.DimensionalServoMetricNaming;
import org.springframework.cloud.netflix.metrics.servo.ServoMetricNaming;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableSidecar
@EnableZuulProxy
public class Application {
	@Bean
	public ServoMetricNaming servoMetricNaming() {
		return new DimensionalServoMetricNaming();
	}
	
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
