package com.atguigu.gmall.pms.mapper;

import com.atguigu.gmall.pms.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author taoge
 * @email taoge@atguigu.com
 * @date 2021-06-22 18:29:01
 */
@Mapper
public interface CategoryMapper extends BaseMapper<CategoryEntity> {
	
}
