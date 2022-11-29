package com.uco.graduationproject.burstcar.infrastructure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.uco")
@EnableJpaRepositories(basePackages = "com.uco")
public class ApplicationMock {

}