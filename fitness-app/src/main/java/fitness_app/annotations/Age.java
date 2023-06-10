package fitness_app.annotations;

import fitness_app.exception_messages.AgeExceptions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Age {

    class AgeValidator {
        public static boolean isValidAge(int age) {
            if (age < 10 || age > 100) {
                return false;
            }
            return true;
        }

    }
}
