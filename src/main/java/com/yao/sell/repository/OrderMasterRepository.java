package com.yao.sell.repository;

import com.yao.sell.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * <p> 订单主表数据库接口
 * Copyright: Copyright (C) 2019 YaoZhengPei, Inc. All rights reserved. <p>
 * Company: 小刘美甲店<p>
 *
 * @author YaoZhengPei
 * @since 2019/7/28 22:17
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
