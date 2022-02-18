package ar.com.api.controller;


public class HealthControllerTestCase {

    private HealthController healthController = new ar.com.api.controller.HealthController();

    @org.junit.jupiter.api.Test
    public void shouldGetStatus() {
        var map = healthController.getHealth();
        org.junit.jupiter.api.Assertions.assertEquals(map.get("status"),"ok");
    }

}
