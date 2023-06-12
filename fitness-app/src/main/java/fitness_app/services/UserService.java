package fitness_app.services;

import fitness_app.entities.Diary;
import fitness_app.entities.User;
import fitness_app.enums.UserType;

public interface UserService {
    void createUser(String username, String password, String email, UserType userType, String firstName, String lastName, int age);

    Diary createDiary(String name, User user);
}
