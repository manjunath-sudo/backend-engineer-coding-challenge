package com.demo.hotel.allocation.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Component
public class SwaggerUI implements ApplicationListener<ApplicationReadyEvent> {

    private final Environment environment;

    public SwaggerUI(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        String port = environment.getProperty("server.port", "8080");
        String contextPath = environment.getProperty("server.servlet.context-path", "");
        String swaggerUrl = "http://localhost:" + port + contextPath + "/swagger-ui/index.html";
        System.out.println("Swagger UI available at: " + swaggerUrl);

        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(swaggerUrl));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}