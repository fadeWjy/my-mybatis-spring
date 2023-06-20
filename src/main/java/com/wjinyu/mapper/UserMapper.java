package com.wjinyu.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @author jinyu.wen
 * @description
 * @created 2023-06-14 10:15
 */
public interface UserMapper {

    @Select("select 'wjinyu' ")
    String getName();
}
