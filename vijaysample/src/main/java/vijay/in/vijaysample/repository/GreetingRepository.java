package vijay.in.vijaysample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vijay.in.vijaysample.model.Greeting;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}
