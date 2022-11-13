package com.panda.system.mapper;

import com.panda.common.base.BaseMapper;
import com.panda.system.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统菜单表 Mapper 接口
 * </p>
 *
 * @author guoshunfa
 * @since 2022-11-13
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

//    List<String> selectPermsByUserId(String id);
}
