package fitness_app.services;

import fitness_app.entities.Diary;
import fitness_app.entities.User;
import fitness_app.entities.Workout;
import fitness_app.enums.Exercise;
import fitness_app.enums.UserType;

public interface UserService {
    User createUser(String username, String password, String email, UserType userType, String firstName, String lastName, int age) throws Exception;

    Diary createDiary(String name, User user);

    Workout createWorkout(String name, Exercise exercise);

    void addWorkout(Diary diary, Workout workout);
}
