package com.atguigu.gmall.pms.mapper;

import com.atguigu.gmall.pms.entity.CommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价
 * 
 * @author taoge
 * @email taoge@atguigu.com
 * @date 2021-06-22 18:29:01
 */
@Mapper
public interface CommentMapper extends BaseMapper<CommentEntity> {
	
}
