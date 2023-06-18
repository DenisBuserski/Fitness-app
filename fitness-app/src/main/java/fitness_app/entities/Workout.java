package fitness_app.entities;

import fitness_app.enums.Exercise;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "workout_name")
    private String name;
    @Column(name = "exercise_name")
    @Enumerated(value = EnumType.STRING)
    private Exercise exercise;

    @OneToMany
    private List<ExerciseInfo> exerciseInfo;


    public Workout() {}
    public Workout(String name, Exercise exercise) {
        this.name = name;
        this.exercise = exercise;
        this.exerciseInfo = new ArrayList<>();
    }


    public List<ExerciseInfo> getExerciseInfo() {
        return exerciseInfo;
    }
}
