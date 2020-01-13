package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1235");
        orderMaster.setBuyerName("小周");
        orderMaster.setBuyerPhone("13788882222");
        orderMaster.setBuyerAddress("鹿谷区");
        orderMaster.setBuyerOpenid("10746234");
        orderMaster.setOrderAmount(new BigDecimal(66));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<OrderMaster> result = repository.findByBuyerOpenid("10746234",pageRequest);
        Assert.assertNotEquals(0, result.getTotalElements());
    }
}