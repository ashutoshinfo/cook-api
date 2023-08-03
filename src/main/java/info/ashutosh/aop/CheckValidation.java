package info.ashutosh.aop;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckValidation {
	// Add any attributes if needed
}