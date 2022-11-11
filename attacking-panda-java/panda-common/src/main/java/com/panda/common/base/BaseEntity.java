package com.panda.common.base;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类
 *
 * @className: BaseEntity
 * @author: GuoShunFa
 * @date: 2022/11/10
 **/
@ApiModel("基础类")
public class BaseEntity<T> extends Model implements Serializable {

    @ApiModelProperty("主键id字段")
    @TableField("id")
    @TableId
    private String id;

    @ApiModelProperty("乐观锁字段")
    @TableField("version")
    @Version
    private String version;

    @ApiModelProperty("逻辑删除字段")
    @TableField("delete_flag")
    @TableLogic
    private String deleteFlag;

    @ApiModelProperty("记录创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("记录创建人")
    @TableField("create_by")
    private String createBy;

    @ApiModelProperty("记录修改时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty("记录创建人")
    @TableField("update_by")
    private String updateBy;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}
