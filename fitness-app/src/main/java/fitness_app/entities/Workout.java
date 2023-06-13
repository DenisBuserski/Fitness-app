package fitness_app.entities;

import fitness_app.enums.Exercise;

import javax.persistence.*;

@Entity(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "exercise_name")
    @Enumerated(value = EnumType.STRING)
    private Exercise exercise;

    public Workout() {
    }
}
