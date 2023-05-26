package fitness_app.repositories;

import fitness_app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    int countByUsername(String username);
}
