package id.co.bcafinance.msthreadleak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "ms-thread-leak is running OK 🚀";
    }
}
