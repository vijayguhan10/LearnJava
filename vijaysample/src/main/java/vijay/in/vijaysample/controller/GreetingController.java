package vijay.in.vijaysample.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vijay.in.vijaysample.model.Greeting;
import vijay.in.vijaysample.service.GreetingService;

@RestController
@RequestMapping("/api/greetings")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Simple hello (kept minimal)
    @GetMapping("/hello")
    public GreetingResponse hello(@RequestParam(value = "name", required = false) String name) {
        return new GreetingResponse(null, greetingService.buildGreeting(name));
    }

    // CRUD below
    @GetMapping
    public List<GreetingResponse> list() {
        return greetingService.listAll().stream().map(this::toResponse).toList();
    }

    @GetMapping("/{id}")
    public GreetingResponse get(@PathVariable Long id) {
        return toResponse(greetingService.getById(id));
    }

    @PostMapping
    public GreetingResponse create(@RequestBody GreetingRequest request) {
        validate(request);
        Greeting saved = greetingService.create(request.message());
        return toResponse(saved);
    }

    @PutMapping("/{id}")
    public GreetingResponse update(@PathVariable Long id, @RequestBody GreetingRequest request) {
        validate(request);
        Greeting saved = greetingService.update(id, request.message());
        return toResponse(saved);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        greetingService.delete(id);
    }

    private GreetingResponse toResponse(Greeting greeting) {
        return new GreetingResponse(greeting.getId(), greeting.getMessage());
    }

    private void validate(GreetingRequest request) {
        if (request == null || request.message() == null || request.message().isBlank()) {
            throw new IllegalArgumentException("message is required");
        }
    }

    public record GreetingRequest(String message) {
    }

    public record GreetingResponse(Long id, String message) {
    }
}
