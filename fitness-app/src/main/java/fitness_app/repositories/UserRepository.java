package fitness_app.repositories;

import fitness_app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    int countByUsername(String username);

    boolean findByUsername(String username);
}
