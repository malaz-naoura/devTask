package com.safee.devtask;

import com.safee.devtask.annotation.ExcludeFromScanning;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
                ExcludeFromScanning.class})})
@EnableScheduling
public class DevtaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevtaskApplication.class, args);
    }

}
