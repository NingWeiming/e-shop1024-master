package cn.nwm.api.service.impl;

import cn.nwm.api.domain.Address;
import cn.nwm.api.mapper.AddressMapper;
import cn.nwm.api.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【address(电商-公司收发货地址表)】的数据库操作Service实现
* @createDate 2023-02-12 16:16:18
*/
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;
    public Address detail(long addressId) {
        return addressMapper.selectById(addressId);
    }
}




