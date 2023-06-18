package fitness_app.entities;

import fitness_app.enums.Exercise;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalTime duration;
    @Column(name = "workout_name")
    private String name;
    @Column(name = "exercise_name")
    @Enumerated(value = EnumType.STRING)
    private Exercise exercise;

    @OneToMany
    private List<ExerciseInfo> exerciseInfo;
    private String gaol;
    private double totalVolume;


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
