package com.yao.sell.repository;

import com.yao.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * <p> 订单详情表数据库接口
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/28 22:32
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
