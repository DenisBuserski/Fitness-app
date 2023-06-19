package fitness_app.entities;

import javax.persistence.*;
import java.time.LocalTime;

@Entity(name = "exercise_info")
public class ExerciseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int set_number;
    private int reps;
    private double kg;
    private LocalTime rest;
    @Column(name = "set_volume")
    private double setVolume;

    public ExerciseInfo() {}
    public ExerciseInfo(int set_number, int reps, double kg, LocalTime rest) {
        this.set_number = set_number;
        this.reps = reps;
        this.kg = kg;
        this.rest = rest;
        this.setVolume = reps * kg;

    }
}
