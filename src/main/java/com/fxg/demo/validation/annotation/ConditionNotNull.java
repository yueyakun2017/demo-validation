package com.fxg.demo.validation.annotation;


import com.fxg.demo.validation.annotation.enums.ConditionLevel;
import com.fxg.demo.validation.validator.ConditionNotNullValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//目标字段是否进行非空校验取决于另一些字段是否为空
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConditionNotNullValidator.class)
public @interface ConditionNotNull {
	String message() default "不能为空";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	String targetFileName();
	String[] dependFileNames() default {};
	ConditionLevel conditionLevel() default ConditionLevel.ANY;
}
