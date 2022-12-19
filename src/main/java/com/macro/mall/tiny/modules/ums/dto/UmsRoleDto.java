package com.macro.mall.tiny.modules.ums.dto;

import com.macro.mall.tiny.modules.ums.model.UmsMenu;
import com.macro.mall.tiny.modules.ums.model.UmsResource;
import com.macro.mall.tiny.modules.ums.model.UmsRole;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UmsRoleDto extends UmsRole {
    @ApiModelProperty(value = "分配的菜单")
    private List<UmsMenu> menus;
    @ApiModelProperty(value = "分配的资源")
    private List<UmsResource> resources;
}
