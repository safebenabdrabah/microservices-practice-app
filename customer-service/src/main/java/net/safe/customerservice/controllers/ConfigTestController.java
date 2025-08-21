package net.safe.customerservice.controllers;

import net.safe.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {

    @Value("${global.params.a}")
    private int a;
    @Value("${global.params.b}")
    private int b;
    @Value("${customer.params.x}")
    private int x;
    @Value("${customer.params.x}")
    private int y;

    @Autowired
    private GlobalConfig globalConfig;

    @GetMapping("/testconfig")
    public Map<String,Integer> configTest(){
        return Map.of("a",a,"b",b,"x",x,"y",y);
    }

    @GetMapping("/GlobalConfig")
    public Map<String, Integer> globalConfig() {
        return Map.of(
                "a", globalConfig.getA(),
                "b", globalConfig.getB()
        );
    }
}
