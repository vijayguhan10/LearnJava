package vijay.in.vijaysample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vijay.in.vijaysample.model.Greeting;
import vijay.in.vijaysample.repository.GreetingRepository;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public String buildGreeting(String name) {
        String target = (name == null || name.isBlank()) ? "there" : name.trim();
        return "Hello, " + target + "!";
    }

    public List<Greeting> listAll() {
        return greetingRepository.findAll();
    }

    public Greeting getById(Long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Greeting not found: " + id));
    }

    public Greeting create(String message) {
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

    public Greeting update(Long id, String message) {
        Greeting greeting = getById(id);
        greeting.setMessage(message);
        return greetingRepository.save(greeting);
    }

    public void delete(Long id) {
        greetingRepository.deleteById(id);
    }
}
