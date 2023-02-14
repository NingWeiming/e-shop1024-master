package cn.nwm.api.controller;

import cn.nwm.api.service.AddressService;
import cn.nwm.common.utils.JsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Api(tags = "收货地址模块")
@RestController
@RequestMapping("/api/addrss/v")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @ApiOperation("根据id查找地址")
    @GetMapping("/find/{address_id}")
    public Object detail (@ApiParam(value = "地址id",required = true) @PathVariable("address_id") long addressId ){
        Object addressDO =  addressService.detail(addressId);
        return JsonData.buildSuccess(addressDO);
    }

}
