package com.example.simpletimeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class TimeController {

    @GetMapping
    public Map<String, String> getTime(@RequestHeader(value = "X-Forwarded-For", required = false) String ip) {
        Map<String, String> response = new HashMap<>();
        response.put("timestamp", Instant.now().toString());
        response.put("ip", ip != null ? ip : "Unknown");
        return response;
    }
}
