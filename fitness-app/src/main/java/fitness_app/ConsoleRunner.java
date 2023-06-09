package fitness_app;

import fitness_app.entities.Diary;
import fitness_app.entities.ExerciseInfo;
import fitness_app.entities.User;
import fitness_app.entities.Workout;
import fitness_app.enums.Exercise;
import fitness_app.enums.UserType;
import fitness_app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final UserService userService;

    @Autowired
    public ConsoleRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = this.userService.createUser(
                "test-username",
                "test-password",
                "test_email@test.com",
                UserType.CLIENT,
                "test-firstName",
                "test-lastName",
                20);
        Diary diary = this.userService.createDiary("test-diary", user);
        Workout workout = this.userService.createWorkout(
                LocalDate.of(2000, 1, 1),
                DayOfWeek.MONDAY,
                LocalTime.now(),
                LocalTime.now(),
                "test-workout",
                Exercise.SQUAT,
                "test-goal");
        this.userService.addWorkout(diary, workout);

        // TODO
        // Workout volume
        ExerciseInfo exerciseInfo = this.userService.createExerciseInfo(1, 10, 100, LocalTime.now());
        this.userService.addExerciseInfo(workout, exerciseInfo);


    }
}
