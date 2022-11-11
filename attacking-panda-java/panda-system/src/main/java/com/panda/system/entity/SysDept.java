package com.panda.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.panda.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 系统部门表
 * </p>
 *
 * @author guoshunfa
 * @since 2022-11-11
 */
@TableName("sys_dept")
@ApiModel(value = "SysDept对象", description = "系统部门表")
public class SysDept extends BaseEntity<SysDept> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("部门名称")
    @TableField("dept_name")
    private String deptName;

    @ApiModelProperty("上级部门id")
    @TableField("parent_dept_id")
    private String parentDeptId;

    public String getDeptName() {
        return deptName;
    }

    public SysDept setDeptName(String deptName) {
        this.deptName = deptName;
        return this;
    }

    public String getParentDeptId() {
        return parentDeptId;
    }

    public SysDept setParentDeptId(String parentDeptId) {
        this.parentDeptId = parentDeptId;
        return this;
    }

    @Override
    public Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "SysDept{" +
                "deptName=" + deptName +
                ", parentDeptId=" + parentDeptId +
                "}";
    }
}
