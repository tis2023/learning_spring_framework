package jp.co.sss.shop.util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ java.lang.annotation.ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy =  { LoginValidator.class})
public @interface Login {
    String message() default "ユーザーID、もしくはdawdaパスワードが間違っています。";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};

    String fieldUserId() default "userId";
    String fieldPassword() default "password";

}
