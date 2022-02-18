package ar.com.api.controller;

@org.springframework.web.bind.annotation.RestController
public class HealthController {

    @org.springframework.web.bind.annotation.GetMapping("/health")
    public java.util.Map<String, String> getHealth() {
        var map = new java.util.HashMap<String, String>();
        map.put("status", "ok");
        return map;
    }

}
