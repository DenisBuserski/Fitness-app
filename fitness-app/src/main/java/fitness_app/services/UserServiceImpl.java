package fitness_app.services;

import fitness_app.annotations.*;
import fitness_app.entities.Diary;
import fitness_app.entities.ExerciseInfo;
import fitness_app.entities.User;
import fitness_app.entities.Workout;
import fitness_app.enums.Exercise;
import fitness_app.enums.UserType;
import fitness_app.exception_messages.AgeExceptions;
import fitness_app.exception_messages.EmailExceptions;
import fitness_app.exception_messages.PasswordExceptions;
import fitness_app.exception_messages.UsernameExceptions;
import fitness_app.repositories.DiaryRepository;
import fitness_app.repositories.ExerciseInfoRepository;
import fitness_app.repositories.UserRepository;
import fitness_app.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final DiaryRepository diaryRepository;
    private final WorkoutRepository workoutRepository;
    private final ExerciseInfoRepository exerciseInfoRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, DiaryRepository diaryRepository, WorkoutRepository workoutRepository, ExerciseInfoRepository exerciseInfoRepository) {
        this.userRepository = userRepository;
        this.diaryRepository = diaryRepository;
        this.workoutRepository = workoutRepository;
        this.exerciseInfoRepository = exerciseInfoRepository;
    }

    @Override
    public User createUser(String username, String password, String email, UserType userType, String firstName, String lastName, int age) throws Exception {
        boolean validUsername = this.userRepository.countByUsername(username) == 0;
        boolean validPassword = Password.PasswordValidator.isValidPassword(password);
        boolean validEmail = Email.EmailValidator.isValidEmail(email);
        boolean validAge = Age.AgeValidator.isValidAge(age);


        if (!validUsername) { // Validate username
            throw new Exception(UsernameExceptions.USERNAME_ALREADY_EXISTS);
        } else if (!validPassword) { // Validate password
            throw new Exception(PasswordExceptions.INVALID_PASSWORD);
        } else if (!validEmail) { // Validate email
            throw new Exception(EmailExceptions.INVALID_EMAIL);
        } else if (!validAge) { // Validate age
            throw new Exception(AgeExceptions.INVALID_AGE);
        } else { // Create user successfully
            User user = new User(username, password, email, userType, firstName, lastName, age);
            this.userRepository.save(user);
            return user;
        }
    }

    @Override
    public Diary createDiary(String name, User user) {
        Diary diary = new Diary(name, user);
        this.diaryRepository.save(diary);
        return diary;
    }

    @Override
    public Workout createWorkout(LocalDate date, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime, String name, Exercise exercise, String goal) {
        Workout workout = new Workout(date, dayOfWeek, startTime, endTime, name, exercise, goal);
        this.workoutRepository.save(workout);
        return workout;
    }

    @Override
    public void addWorkout(Diary diary, Workout workout) {
        diary.getWorkout().add(workout);
        this.diaryRepository.save(diary);
    }

    @Override
    public ExerciseInfo createExerciseInfo(int set_number, int reps, double kg, LocalTime rest) {
        ExerciseInfo exerciseInfo = new ExerciseInfo(set_number, reps, kg, rest);
        this.exerciseInfoRepository.save(exerciseInfo);
        return exerciseInfo;
    }

    @Override
    public void addExerciseInfo(Workout workout, ExerciseInfo exerciseInfo) {
        workout.getExerciseInfo().add(exerciseInfo);
        this.workoutRepository.save(workout);
    }

}
