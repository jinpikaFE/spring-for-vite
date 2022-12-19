package com.macro.mall.tiny.modules.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.dto.UmsResourceCategoryDto;
import com.macro.mall.tiny.modules.ums.mapper.UmsResourceCategoryMapper;
import com.macro.mall.tiny.modules.ums.model.UmsResourceCategory;
import com.macro.mall.tiny.modules.ums.service.UmsResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 后台资源分类管理Service实现类
 * Created by macro on 2020/2/5.
 */
@Service
public class UmsResourceCategoryServiceImpl extends ServiceImpl<UmsResourceCategoryMapper, UmsResourceCategory> implements UmsResourceCategoryService {

    @Autowired
    private UmsResourceCategoryMapper resourceCategoryMapper;

    @Override
    public List<UmsResourceCategoryDto> listAll() {
        List<UmsResourceCategoryDto> results = resourceCategoryMapper.getResourceCategoryAss();
        return results;
    }

    @Override
    public boolean create(UmsResourceCategory umsResourceCategory) {
        umsResourceCategory.setCreateTime(new Date());
        return save(umsResourceCategory);
    }
}
