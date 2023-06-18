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
    @Column(name = "day_of_the_week")
    private DayOfWeek dayOfWeek;
    @Column(name = "start_time")
    private LocalTime startTime;
    @Column(name = "end_time")
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
    @Column(name = "total_volume")
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
