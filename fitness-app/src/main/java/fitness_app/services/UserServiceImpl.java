package fitness_app.services;

import fitness_app.annotations.*;
import fitness_app.entities.Diary;
import fitness_app.entities.User;
import fitness_app.entities.Workout;
import fitness_app.enums.Exercise;
import fitness_app.enums.UserType;
import fitness_app.exception_messages.AgeExceptions;
import fitness_app.exception_messages.EmailExceptions;
import fitness_app.exception_messages.PasswordExceptions;
import fitness_app.exception_messages.UsernameExceptions;
import fitness_app.repositories.DiaryRepository;
import fitness_app.repositories.UserRepository;
import fitness_app.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final DiaryRepository diaryRepository;
    private final WorkoutRepository workoutRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, DiaryRepository diaryRepository, WorkoutRepository workoutRepository) {
        this.userRepository = userRepository;
        this.diaryRepository = diaryRepository;
        this.workoutRepository = workoutRepository;
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
    public Workout createWorkout(String name, Exercise exercise) {
        Workout workout = new Workout(name, exercise);
        this.workoutRepository.save(workout);
        return workout;
    }
}
