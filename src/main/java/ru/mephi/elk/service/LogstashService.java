package ru.mephi.elk.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.mephi.elk.dto.ObjectCountDto;

@Service
public class LogstashService {

    private final RestTemplate restTemplate;

    @Value("${logstash.host}")
    private String host;

    @Value("${logstash.port}")
    private String port;

    /**
     * Logstasg service required arguments constructor
     * @return LogstashService object
     */
    public LogstashService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     * Send count of event to logstash
     * @param objectCount event count info
     */
    public void sendObjectCount(ObjectCountDto objectCount) {
        String url = String.format("http://%s:%s", host, port);
        restTemplate.postForObject(url, objectCount, String.class);
    }


}
