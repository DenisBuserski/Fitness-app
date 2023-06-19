package fitness_app.entities;

import fitness_app.enums.Exercise;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    @Column(name = "day_of_the_week")
    @Enumerated(value = EnumType.STRING)
    private DayOfWeek dayOfWeek;
    @Column(name = "start_time")
    private LocalTime startTime;
    @Column(name = "end_time")
    private LocalTime endTime;
    private Duration duration;
    @Column(name = "workout_name")
    private String name;
    @Column(name = "exercise_name")
    @Enumerated(value = EnumType.STRING)
    private Exercise exercise;
    @OneToMany
    private List<ExerciseInfo> exerciseInfo;
    private String goal;
    @Column(name = "total_volume")
    private double totalVolume;



    public Workout() {}
    public Workout(LocalDate date, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime, String name, Exercise exercise, String goal) {
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = Duration.between(startTime, endTime);
        this.name = name;
        this.exercise = exercise;
        this.exerciseInfo = new ArrayList<>();
        this.goal = goal;
        this.totalVolume = calculateTotalVolume(this.exerciseInfo);
    }

    private double calculateTotalVolume(List<ExerciseInfo> exerciseInfo) {
        double totalVolume = 0;
        for (ExerciseInfo info : exerciseInfo) {
            double current = info.getSetVolume();
            totalVolume += current;
        }
        return totalVolume;
    }

    public List<ExerciseInfo> getExerciseInfo() {
        return exerciseInfo;
    }
}
