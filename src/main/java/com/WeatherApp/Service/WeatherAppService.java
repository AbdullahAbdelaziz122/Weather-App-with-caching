package com.WeatherApp.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherAppService {

    private final RestTemplate restTemplate;


    @Value("${RabidAPI.Key}")
    private String rabidAPIKey;

    @Value("${RabidAPI.Host}")
    private String rabidAPIHost;


    public ResponseEntity<String> getData(String city){
    	try {
    		HttpHeaders headers2 = new HttpHeaders();
    		headers2.set("x-rapidapi-key", rabidAPIKey);
            headers2.set("x-rapidapi-host", rabidAPIHost);
            
            String url = String.format("https://open-weather13.p.rapidapi.com/city/%s/EN", city);
            
            ResponseEntity<String> response = restTemplate.exchange(
                url, 
                HttpMethod.GET, 
                new HttpEntity<>(headers2), 
                String.class
            );
            return response;
    		
    	}catch(Exception e) {
    		log.error("Something went wrong fetching data from RabidAPI", e);
    		throw new ResponseStatusException(
    				HttpStatus.INTERNAL_SERVER_ERROR,
    				"Exception while calling endpoint of RabidAPI", e
    				);
    	}
    	
    }
    
}
