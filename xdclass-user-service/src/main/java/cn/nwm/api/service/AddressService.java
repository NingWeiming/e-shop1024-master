package cn.nwm.api.service;

import cn.nwm.api.domain.Address;


/**
* @author Administrator
* @description 针对表【address(电商-公司收发货地址表)】的数据库操作Service
* @createDate 2023-02-12 16:16:18
*/
public interface AddressService  {

    Address detail(long addressId);
}
