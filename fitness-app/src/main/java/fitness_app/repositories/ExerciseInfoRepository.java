package fitness_app.repositories;

import fitness_app.entities.ExerciseInfo;
import fitness_app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseInfoRepository extends JpaRepository<ExerciseInfo, Integer> {
}
