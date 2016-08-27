package hap.core.salesorder.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;

import hap.core.salesorder.dto.SelectVo;
import hap.core.salesorder.service.AllTableService;

@Controller
@RequestMapping("/salesOrder")
public class AllTableController extends BaseController{
	
	@Autowired
	private AllTableService allTableService;
	
	@RequestMapping("/allTable/query")
	@ResponseBody
	public ResponseData selectList(HttpServletRequest request, SelectVo selectVo,
            @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize) throws Exception{
		
		List<SelectVo> list = allTableService.selectByCondition(selectVo, page, pagesize);
		return new ResponseData(list);
	}
}
