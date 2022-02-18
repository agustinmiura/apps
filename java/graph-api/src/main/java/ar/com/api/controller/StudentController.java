package ar.com.api.controller;

import org.springframework.beans.factory.annotation.Value;

@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping("/api/student/")
public class StudentController {

    @Value("${app.name:Default Demo App}")
    private String appName;

    @org.springframework.web.bind.annotation.GetMapping("/get")
    public ar.com.api.domain.StudentResponse getStudent () {
        ar.com.api.domain.StudentResponse studentResponse = new ar.com.api.domain.StudentResponse(1, "John", "Smith");
        return studentResponse;
    }
}
