package hap.core.salesorder.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;

import hap.core.salesorder.dto.Customer;
import hap.core.salesorder.service.ICustomerService;

/**
 * Created by maheng on 16/8/26.
 */
@Controller
@RequestMapping("/salesOrder")
public class CustomerController  extends BaseController{

    @Autowired
    private ICustomerService customerService;

    @RequestMapping("/customer/query")
    @ResponseBody
    public ResponseData selectList(HttpServletRequest request, Customer condition,
                                   @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                   @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize) {
        IRequest iRequest = createRequestContext(request);
        List<Customer> datas = customerService.select(iRequest, condition, page, pagesize);
        return new ResponseData(datas);
    }

    @RequestMapping(value = "/customer/submit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData submit(HttpServletRequest request, @RequestBody List<Customer> customers) {
        IRequest iRequest = createRequestContext(request);
        List<Customer> datas = customerService.batchUpdate(iRequest, customers);
        return new ResponseData(datas);
    }

    @RequestMapping(value = "/customer/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<Customer> customers) {
        IRequest iRequest = createRequestContext(request);
        customerService.batchDelete(customers);
        return new ResponseData();
    }
}
