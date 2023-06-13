package fitness_app.entities;

import fitness_app.enums.Exercise;

import javax.persistence.*;

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

    // set -> reps -> kg -> rest

    public Workout() {
    }

    public Workout(String name, Exercise exercise) {
        this.name = name;
        this.exercise = exercise;
    }
}
