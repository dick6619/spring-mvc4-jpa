package com.iii.emp.model.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

// 是否加入javaDocs
@Documented
// 指定使用的validator
@Constraint(validatedBy = SalValidatorJSR303.class)
// 影響標註使用範圍如：可用在方法，欄位，型別等
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
// 表示annotation是在run-time時reflection取得
@Retention(RetentionPolicy.RUNTIME)
// ([0-9]){4}| 0~9 4碼 或
// @Pattern(regexp =
// "([a-zA-Z])([0-9])(-)([0-9]){4}|([0-9]){3}(-)([0-9]){3}|([a-zA-Z]){2}(-)([0-9]){4}")
// @Size(min = 0, max = 10000)
public @interface Sal {

	String message() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/** 1000.0 */
	Double MIN = 1000.0;
	/** 10000.0 */
	Double MAX = 10000.0;

}
