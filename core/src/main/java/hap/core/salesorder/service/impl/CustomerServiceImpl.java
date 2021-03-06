package hap.core.salesorder.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hand.hap.system.service.impl.BaseServiceImpl;

import hap.core.salesorder.dto.Customer;
import hap.core.salesorder.service.ICustomerService;

/**
 * Created by maheng on 16/8/26.
 */
@Service
@Transactional
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements ICustomerService {

}
