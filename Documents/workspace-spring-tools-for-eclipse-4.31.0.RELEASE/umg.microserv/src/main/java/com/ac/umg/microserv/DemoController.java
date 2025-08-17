package com.ac.umg.microserv;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private static final String WELCOME_MESSAGE = "{\"mensaje\": \"Bienvenido al microservicio\", \"detalle\": \"";

    private ResponseEntity<String> createResponse(String detail, int status) {
        String responseBody = WELCOME_MESSAGE + detail + "\"}";
        if (status == 201) {
            return ResponseEntity.status(201).body(responseBody);
        }
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/api/demo")
    public ResponseEntity<String> getMethod() {
        return createResponse("Operación GET ejecutada con éxito", 200);
    }

    @PostMapping("/api/demo")
    public ResponseEntity<String> postMethod() {
        return createResponse("Operación POST ejecutada con éxito", 201);
    }

    @PutMapping("/api/demo")
    public ResponseEntity<String> putMethod() {
        return createResponse("Operación PUT ejecutada con éxito", 200);
    }

    @DeleteMapping("/api/demo")
    public ResponseEntity<String> deleteMethod() {
        return createResponse("Operación DELETE ejecutada con éxito", 200);
    }
}




























