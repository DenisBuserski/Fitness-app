package fitness_app.services;

import fitness_app.entities.Diary;
import fitness_app.entities.ExerciseInfo;
import fitness_app.entities.User;
import fitness_app.entities.Workout;
import fitness_app.enums.Exercise;
import fitness_app.enums.UserType;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public interface UserService {
    User createUser(String username, String password, String email, UserType userType, String firstName, String lastName, int age) throws Exception;

    Diary createDiary(String name, User user);

    Workout createWorkout(LocalDate date, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime, String name, Exercise exercise, String goal);

    void addWorkout(Diary diary, Workout workout);


    ExerciseInfo createExerciseInfo(int set_number, int reps, double kg, LocalTime rest);

    void addExerciseInfo(Workout workout, ExerciseInfo exerciseInfo);
}
