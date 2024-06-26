package com.hrutik.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping("/hello")
    public String sayhello() {
        return "Hellow From Application";
    }

    @PostMapping("/message")
    public String sendMessage(
          @RequestBody String message
    ) {
        return  message;
    }

    @PostMapping("/order")
    public String createOrder(
            @RequestBody Order order
    ) {
        return order.toString();
    }
}
