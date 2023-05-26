package fitness_app;

import fitness_app.enums.UserType;
import fitness_app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final UserService userService;

    @Autowired
    public ConsoleRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userService.createUser("test-username", "test-password", "test_email@test.com", UserType.ADMIN, "test-firstName", "test-lastName", 20);


    }
}
