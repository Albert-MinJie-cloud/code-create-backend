package com.mj.codecreate.aop;

import com.mj.codecreate.annotation.AuthCheck;
import com.mj.codecreate.exception.BusinessException;
import com.mj.codecreate.exception.ErrorCode;
import com.mj.codecreate.model.entity.User;
import com.mj.codecreate.model.enums.UserRoleEnum;
import com.mj.codecreate.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

//Aspect注解定义这是一个切面
@Aspect
@Component
public class AuthInterceptor {

    // 引入userService，在切面中进行用户的权限校验
    @Resource
    private UserService userService;


    /**
     * 执行拦截切入点
     * @param joinPoint // 切入点
     * @param authCheck // 权限校验注解
     * @return
     * @throws Throwable
     */


    // 严格控制切面生效范围
    // Around通知，只对有@annotation(authCheck)注解的方法生效，进行拦截
    // 切点表达式
    @Around("@annotation(authCheck)")
    // 定义一个切点
    public Object doInterception(ProceedingJoinPoint joinPoint, AuthCheck authCheck) throws Throwable{
        String mustRole = authCheck.mustRole();

        // 获取当前用户
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        User loginUser = userService.getLoginUser(request);

        UserRoleEnum mustRoleEnum = UserRoleEnum.getEnumByValue(mustRole);

        // 不需要权限，直接放行
        if(mustRoleEnum == null){
            return joinPoint.proceed();
        }

        // 以下的代码，必须有某个权限
        UserRoleEnum userRoleEnum = UserRoleEnum.getEnumByValue(loginUser.getUserRole());

        // 没有权限，直接拒绝
        if (userRoleEnum == null){
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }

        // 要求必须有管理员权限,但是当前登陆用户没有
        if(UserRoleEnum.ADMIN.equals(mustRoleEnum) && !UserRoleEnum.ADMIN.equals(userRoleEnum)){
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }

        // 通过普通用户的权限校验，放行
        return joinPoint.proceed();
    }
}
