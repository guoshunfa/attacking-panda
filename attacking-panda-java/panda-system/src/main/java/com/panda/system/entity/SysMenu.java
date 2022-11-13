package com.panda.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.panda.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 系统菜单表
 * </p>
 *
 * @author guoshunfa
 * @since 2022-11-13
 */
@TableName("sys_menu")
@ApiModel(value = "SysMenu对象", description = "系统菜单表")
public class SysMenu extends BaseEntity<SysMenu> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("菜单名称")
    @TableField("menu_name")
    private String menuName;

    @ApiModelProperty("父级菜单id")
    @TableField("parent_id")
    private String parentId;

    @ApiModelProperty("显示顺序")
    @TableField("order_num")
    private Integer orderNum;

    @ApiModelProperty("访问地址（路由地址）")
    @TableField("path")
    private String path;

    @ApiModelProperty("组件路径（前后端分离）")
    @TableField("component")
    private String component;

    @ApiModelProperty("权限标识")
    @TableField("perms")
    private String perms;

    @ApiModelProperty("菜单状态（0显示 1隐藏）")
    @TableField("visiable")
    private String visiable;

    @ApiModelProperty("菜单状态（0正常 1停用）")
    @TableField("`status`")
    private String status;

    @ApiModelProperty("菜单图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty("是否删除（0未删除 1已删除）")
    @TableField("delFlag")
    private Integer delFlag;

    public String getMenuName() {
        return menuName;
    }

    public SysMenu setMenuName(String menuName) {
        this.menuName = menuName;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public SysMenu setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public SysMenu setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
        return this;
    }

    public String getPath() {
        return path;
    }

    public SysMenu setPath(String path) {
        this.path = path;
        return this;
    }

    public String getComponent() {
        return component;
    }

    public SysMenu setComponent(String component) {
        this.component = component;
        return this;
    }

    public String getPerms() {
        return perms;
    }

    public SysMenu setPerms(String perms) {
        this.perms = perms;
        return this;
    }

    public String getVisiable() {
        return visiable;
    }

    public SysMenu setVisiable(String visiable) {
        this.visiable = visiable;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public SysMenu setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public SysMenu setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public SysMenu setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "menuName=" + menuName +
                ", parentId=" + parentId +
                ", orderNum=" + orderNum +
                ", path=" + path +
                ", component=" + component +
                ", perms=" + perms +
                ", visiable=" + visiable +
                ", status=" + status +
                ", icon=" + icon +
                ", delFlag=" + delFlag +
                "}";
    }
}
