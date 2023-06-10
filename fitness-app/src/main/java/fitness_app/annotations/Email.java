package fitness_app.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Email {

    class EmailValidator {
        public static boolean isValidEmail(String email) {
            String pattern = "^[a-zA-Z0-9]+([.\\-_][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([.\\-]?[a-zA-Z0-9]+)*\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})*$";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(email);
            return matcher.matches();
        }
    }
}
