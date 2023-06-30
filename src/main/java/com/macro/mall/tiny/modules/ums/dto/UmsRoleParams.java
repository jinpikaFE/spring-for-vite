package com.macro.mall.tiny.modules.ums.dto;

import com.macro.mall.tiny.modules.ums.model.UmsRole;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
public class UmsRoleParams extends UmsRole {
    @NotNull(message = "菜单ids不能为空")
    @ApiModelProperty(value = "菜单ids")
    private List<Long> menus;
    @NotNull(message = "资源ids不能为空")
    @ApiModelProperty(value = "资源ids")
    private List<Long> resources;
}
