package com.WeatherApp.Controller;

import com.WeatherApp.Service.WeatherAppService;
import lombok.RequiredArgsConstructor;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weatherApp")
@RequiredArgsConstructor
public class WeatherFetcherController {

    private final WeatherAppService weatherAppService;


    @Cacheable(value = "weatherCache", key = "#city")
    @GetMapping("/fetch/{city}")
    public String fetch(@PathVariable String city)
    {
        return weatherAppService.getData(city).getBody();
    }

}

