package fitness_app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;

@Entity(name = "exercise_info")
public class ExerciseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int set;
    private int reps;
    private double kg;
    private LocalTime rest;

    public ExerciseInfo() {}
    public ExerciseInfo(int set, int reps, double kg, LocalTime rest) {
        this.set = set;
        this.reps = reps;
        this.kg = kg;
        this.rest = rest;
    }
}
