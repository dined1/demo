package com.example.demo.job;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Configuration
@Log4j2
@EnableScheduling
public class HttpAliveJob {

    private final RestTemplate restTemplate;

    @Autowired
    public HttpAliveJob(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Scheduled(cron = "0 0/25 * * * *")
    public void pingServer(){
        try {
            restTemplate.getForEntity("https://dbcloudback.herokuapp.com/api/job", null);
        } catch (HttpClientErrorException e){
            log.info("You shall not die!");
        }
    }

}
