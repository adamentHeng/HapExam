package hap.core.salesorder.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hand.hap.system.service.impl.BaseServiceImpl;

import hap.core.salesorder.dto.OrderHeader;
import hap.core.salesorder.service.IOrderHeaderService;

/**
 * Created by maheng on 16/8/26.
 */
@Service
@Transactional
public class OrderHeaderServiceImpl extends BaseServiceImpl<OrderHeader> implements IOrderHeaderService {

}
