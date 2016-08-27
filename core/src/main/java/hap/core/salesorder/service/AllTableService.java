package hap.core.salesorder.service;

import java.util.List;

import com.hand.hap.core.ProxySelf;

import hap.core.salesorder.dto.SelectVo;

public interface AllTableService extends ProxySelf<AllTableService>{
	public List<SelectVo> selectByCondition(SelectVo select,int page, int pagesize) throws Exception;
}
