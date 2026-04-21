package com.mj.codecreate.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户修改密码请求
 *
 * @author <a href="https://github.com/Albert-MinJie-cloud">MJ</a>
 */
@Data
public class UserUpdatePasswordRequest implements Serializable {

    /**
     * 旧密码
     */
    private String oldPassword;

    /**
     * 新密码
     */
    private String newPassword;

    /**
     * 确认密码
     */
    private String checkPassword;

    private static final long serialVersionUID = 1L;
}
