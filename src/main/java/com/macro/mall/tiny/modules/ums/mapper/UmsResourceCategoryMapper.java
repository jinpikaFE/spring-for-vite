package com.macro.mall.tiny.modules.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.mall.tiny.modules.ums.dto.UmsResourceCategoryDto;
import com.macro.mall.tiny.modules.ums.model.UmsResourceCategory;

import java.util.List;

/**
 * <p>
 * 资源分类表 Mapper 接口
 * </p>
 *
 * @author macro
 * @since 2020-08-21
 */
public interface UmsResourceCategoryMapper extends BaseMapper<UmsResourceCategory> {
    /**
     * 分页获取资源，联合查询分类
     */
    List<UmsResourceCategoryDto> getResourceCategoryAss();
}
