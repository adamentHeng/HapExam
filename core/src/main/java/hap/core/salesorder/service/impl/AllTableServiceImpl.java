package hap.core.salesorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import hap.core.salesorder.dto.SelectVo;
import hap.core.salesorder.mapper.AllTableMapper;
import hap.core.salesorder.service.AllTableService;

@Service
@Transactional
public class AllTableServiceImpl implements AllTableService{
	
	@Autowired
	private AllTableMapper allTableMapper;

	@Override
	public List<SelectVo> selectByCondition(SelectVo select,int page, int pagesize) throws Exception {
		PageHelper.startPage(page, pagesize);
		return allTableMapper.selectByCondition(select);
	}

}
