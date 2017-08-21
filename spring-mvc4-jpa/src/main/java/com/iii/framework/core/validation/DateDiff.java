package com.iii.framework.core.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.iii.framework.core.validation.validator.DateDiffValidator;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, ANNOTATION_TYPE })
@Constraint(validatedBy = { DateDiffValidator.class })
public @interface DateDiff {
	String message() default "";

	String start();

	String end();

	String diff();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@interface List {
		DateDiff[] value();
	}

}
