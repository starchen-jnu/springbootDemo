package com.star.springbootdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.star.springbootdemo.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: StarC
 * @Date: 2019/8/24 18:15
 * @Description:
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
