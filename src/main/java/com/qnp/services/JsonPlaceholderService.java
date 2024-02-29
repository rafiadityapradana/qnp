package com.qnp.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JsonPlaceholderService {

    private RestTemplate restTemplate;

    public JsonPlaceholderService() {
        this.restTemplate = new RestTemplate();
    }

    public ResponseEntity<Object[]> fetchDataFromJsonPlaceholder() {
        long startTime = System.currentTimeMillis();
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users", Object[].class);
        responseEntity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts", Object[].class);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time taken: " + totalTime + " milliseconds");
        return responseEntity;
    }
}