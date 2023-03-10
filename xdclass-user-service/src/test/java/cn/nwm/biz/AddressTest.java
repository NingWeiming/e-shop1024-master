package cn.nwm.biz;

import cn.nwm.UserApplication;
import cn.nwm.api.domain.Address;
import cn.nwm.api.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
@Slf4j
public class AddressTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void testAddressDetail(){
        Address addressDO = addressService.detail(1L);
        log.info(addressDO.toString());
         //断言
        Assert.assertNotNull(addressDO);
    }


}
