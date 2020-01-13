package com.imooc.service;

import com.imooc.dto.OrderDTO;

public interface BuyerService {

    OrderDTO findOrderOne(String openid, String orderid);

    OrderDTO cancleOrder(String openid, String orderid);
}
