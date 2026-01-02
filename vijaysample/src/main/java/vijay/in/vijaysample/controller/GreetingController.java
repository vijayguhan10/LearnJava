package vijay.in.vijaysample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vijay.in.vijaysample.service.GreetingService;

@RestController
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/api/greeting")
    public ResponseEntity<GreetingResponse> greeting(
            @RequestParam(value = "name", required = false) String name) {
        String message = greetingService.buildGreeting(name);
        return ResponseEntity.ok(new GreetingResponse(message));
    }

    public record GreetingResponse(String message) {
    }
}
