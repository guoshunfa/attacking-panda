package com.panda.admin.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.panda.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author guoshunfa
 * @since 2022-11-11
 */
@TableName("sys_user")
@ApiModel(value = "SysUser对象", description = "系统用户表")
public class SysUser extends BaseEntity<SysUser> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户姓名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("用户密码")
    @TableField("user_password")
    private String userPassword;

    @ApiModelProperty("所在部门id")
    @TableField("dept_id")
    private String deptId;

    public String getUserName() {
        return userName;
    }

    public SysUser setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public SysUser setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public String getDeptId() {
        return deptId;
    }

    public SysUser setDeptId(String deptId) {
        this.deptId = deptId;
        return this;
    }

    @Override
    public Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userName=" + userName +
                ", userPassword=" + userPassword +
                ", deptId=" + deptId +
                "}";
    }
}
