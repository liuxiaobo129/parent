package org.example.configclient;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope
public class MyController {

    @Value("${app.name}")
    private String myConfigProperty;

    @GetMapping("/config")
    public String getConfig() {
        return myConfigProperty;
    }
}
