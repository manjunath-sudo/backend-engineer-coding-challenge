package com.demo.hotel.allocation.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.awt.Desktop;
import java.net.URI;

@Component
public class SwaggerUI implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            String swaggerUrl = "http://localhost:8080/swagger-ui/index.html";
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(swaggerUrl));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}