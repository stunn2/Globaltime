package com.globaltime.timeservice;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RestController
	public class HealthController {
    protected static final List<String> cities = Arrays.asList("America/New_York", "Europe/Berlin", "Asia/Tokyo");
    
    @GetMapping(value = "/", produces = "text/html") 
    public String getHtml()
    {
        StringBuilder html = new StringBuilder();
        html.append("<ul>");
        for (Map.Entry<String, String> entry : getLocalTimes().entrySet()) {
            String city = entry.getKey();
            String time = entry.getValue();
            html.append("<h1>").append(city).append(": ").append(time).append("</h1>");
        }
        html.append("</ul>");
        return html.toString();
    }


    @GetMapping(value = "/health", produces = "application/json")    
    public ResponseEntity<String> getJson() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String jsonString = mapper.writeValueAsString(getLocalTimes());
            // Return 200 OK with JSON string
            return ResponseEntity.ok(jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    protected Map<String, String> getLocalTimes()
    {
        Map<String, String> timeMap = new HashMap<>();
        for (String timezone : cities) {
            ZoneId zoneId = ZoneId.of(timezone);
            LocalDateTime now = LocalDateTime.now(zoneId);
            String formattedTime = now.format(DateTimeFormatter.ofPattern("HH:mm"));
            String city = timezone.substring(timezone.indexOf("/") + 1);
            timeMap.put(city, formattedTime);
        }
        return timeMap;
    }
}