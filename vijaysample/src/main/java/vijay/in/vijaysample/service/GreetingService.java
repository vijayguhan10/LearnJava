package vijay.in.vijaysample.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String buildGreeting(String name) {
        String target = (name == null || name.isBlank()) ? "there" : name.trim();
        return "Hello, " + target + "!";
    }
}
