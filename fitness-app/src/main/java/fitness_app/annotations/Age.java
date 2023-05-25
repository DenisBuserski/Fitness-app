package fitness_app.annotations;

import fitness_app.exception_messages.AgeExceptions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Age {
    String message() default AgeExceptions.INVALID_AGE;

    class AgeValidator {
        public static int isValid(int age) {
            if (age < 10) {
                return 1;
            } else if (age > 100) {
                return 2;
            }
            return age;
        }

    }
}
