package com.mj.codecreate.service;

import com.mj.codecreate.model.dto.UserQueryRequest;
import com.mj.codecreate.model.vo.LoginUserVO;
import com.mj.codecreate.model.vo.UserVO;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.mj.codecreate.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * 用户 服务层。
 *
 * @author <a href="https://github.com/Albert-MinJie-cloud">MJ</a>
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount 账号
     * @param userPassword 用户密码
     * @param checkPassword 检查密码
     * @return 新用户id
     */
    long userRegister(String userAccount,String userPassword,String checkPassword);


    /**
     * 获取已经脱敏的用户登陆数据
     *
     * @return 用户信息
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * 用户登陆
     *
     * @param userAccount 账号
     * @param userPassword 用户密码
     * @param request //
     * @return 脱敏后的用户信息
     *
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 获取当前登陆用户
     *
     * @param request //
     * @return 脱敏后的用户信息
     *
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 退出登陆
     *
     * @param request //
     * @return 退出登陆是否成功
     */
    boolean userLogout(HttpServletRequest request);


    // region 管理员获取用户信息

    /**
     * 获取脱敏后的用户信息
     *
     * @param user //
     * @return 退出登陆是否成功
     */
    UserVO getUserVO(User user);

    /**
     * 获取脱敏后的用户信息(分页)
     *
     * @param userList //
     * @return 获取脱敏后的用户信息
     */
    List<UserVO> getUserVOList(List<User> userList);


    /**
     * 根据查询条件构造QueryWrapper数据查询参数
     * @param userQueryRequest //
     * @return //
     */
    QueryWrapper getQueryWrapper(UserQueryRequest userQueryRequest);


    // endregion



    /**
     * 加密
     *
     * @param userPassword 用户密码
     * @return 加密后的用户密码
     */
    String getEncryptPassword(String userPassword);

    /**
     * 用户修改密码
     *
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @param checkPassword 确认密码
     * @param request 请求对象
     * @return 是否修改成功
     */
    boolean updatePassword(String oldPassword, String newPassword, String checkPassword, HttpServletRequest request);
}
