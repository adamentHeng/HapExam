package hap.core.salesorder.mapper;

import java.util.List;

import hap.core.salesorder.dto.SelectVo;

public interface AllTableMapper{
	public List<SelectVo> selectByCondition(SelectVo select) throws Exception;
}
