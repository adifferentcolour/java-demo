package com.adifferentcolour.starter.resources;


import com.adifferentcolour.starter.domain.ApplicationInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.adifferentcolour.starter.metrics.EventHandler.SendEvent;

@RestController
public class ApplicationInfoResource {

    @GetMapping("/healthcheck")
    public String healthcheck() {
        SendEvent("healthcheck");
        return "ok";
    }

    @GetMapping("/app-info")
    public ApplicationInfo getAppInfo(){
        return new ApplicationInfo();
    }


}
