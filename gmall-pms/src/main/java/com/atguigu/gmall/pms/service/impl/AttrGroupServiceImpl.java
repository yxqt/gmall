package com.atguigu.gmall.pms.service.impl;

import com.atguigu.gmall.pms.entity.AttrEntity;
import com.atguigu.gmall.pms.mapper.AttrMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;

import com.atguigu.gmall.pms.mapper.AttrGroupMapper;
import com.atguigu.gmall.pms.entity.AttrGroupEntity;
import com.atguigu.gmall.pms.service.AttrGroupService;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroupEntity> implements AttrGroupService {

    @Autowired
    AttrMapper attrMapper;

    @Override
    public PageResultVo queryPage(PageParamVo paramVo) {
        IPage<AttrGroupEntity> page = this.page(
                paramVo.getPage(),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageResultVo(page);
    }

    @Override
    public List<AttrGroupEntity> queryAttrGroupByCategoryId(Long cid) {
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("category_id",cid);
        List<AttrGroupEntity> attrGroupEntities = baseMapper.selectList(wrapper);
        return attrGroupEntities;
    }

    @Override
    public List<AttrGroupEntity> queryAttrGroupAndAttrByCategoryId(Long catId) {
        LambdaQueryWrapper<AttrGroupEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AttrGroupEntity::getCategoryId,catId);
        List<AttrGroupEntity> attrGroupEntities = baseMapper.selectList(wrapper);
        for (AttrGroupEntity attrGroupEntity : attrGroupEntities) {
            LambdaQueryWrapper<AttrEntity> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(AttrEntity::getType,1);
            queryWrapper.eq(AttrEntity::getGroupId,attrGroupEntity.getId());
            List<AttrEntity> attrEntities = attrMapper.selectList(queryWrapper);
            attrGroupEntity.setAttrEntities(attrEntities);
        }
        return attrGroupEntities;
    }

}