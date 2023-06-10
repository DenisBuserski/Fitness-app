package fitness_app.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {

    class PasswordValidator {
        public static boolean isValidPassword(String password) {
            if (password.length() < 10 || password.length() > 30) {
                return false;
            }
            return true;
        }

    }
}
