package com.mj.codecreate.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


// 注解生效对象(方法)
@Target({ElementType.METHOD})
// 注解策略(运行时)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthCheck {

    // 方法默认不需要任何不需有的角色

    /**
     * 必须有某个角色才能调用
     * @return //
     */
    String mustRole() default "";

}
