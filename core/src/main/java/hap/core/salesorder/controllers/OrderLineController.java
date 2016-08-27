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

import hap.core.salesorder.dto.OrderLine;
import hap.core.salesorder.service.IOrderLineService;

/**
 * Created by maheng on 16/8/26.
 */
@Controller
@RequestMapping("/salesOrder")
public class OrderLineController  extends BaseController{

    @Autowired
    private IOrderLineService orderLineService;

    @RequestMapping("/orderLine/query")
    @ResponseBody
    public ResponseData selectList(HttpServletRequest request, OrderLine condition,
                                   @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                                   @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize) {
        IRequest iRequest = createRequestContext(request);
        List<OrderLine> datas = orderLineService.select(iRequest, condition, page, pagesize);
        return new ResponseData(datas);
    }

    @RequestMapping(value = "/orderLine/submit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData submit(HttpServletRequest request, @RequestBody List<OrderLine> orderLines) {
        IRequest iRequest = createRequestContext(request);
        List<OrderLine> datas = orderLineService.batchUpdate(iRequest, orderLines);
        return new ResponseData(datas);
    }

    @RequestMapping(value = "/orderLine/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData delete(HttpServletRequest request, @RequestBody List<OrderLine> orderLines) {
        IRequest iRequest = createRequestContext(request);
        orderLineService.batchDelete(orderLines);
        return new ResponseData();
    }
}
