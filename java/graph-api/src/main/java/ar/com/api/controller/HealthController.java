package ar.com.api.controller;

@lombok.extern.slf4j.Slf4j
@org.springframework.web.bind.annotation.RestController
public class HealthController {

    @org.springframework.web.bind.annotation.GetMapping("/health")
    public java.util.Map<String, String> getHealth() {
        log.info("get health");
        var map = new java.util.HashMap<String, String>();
        map.put("status", "ok");
        return map;
    }

}
