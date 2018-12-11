package com.maxhong.blog.service.impl;

import com.maxhong.blog.entity.Options;
import com.maxhong.blog.entity.custom.OptionsCustom;
import com.maxhong.blog.mapper.OptionsMapper;
import com.maxhong.blog.mapper.custom.OptionsMapperCustom;
import com.maxhong.blog.service.OptionsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 言曌 on 2017/9/7.
 */
public class OptionsServiceImpl implements OptionsService {

	@Autowired
	private OptionsMapperCustom optionsMapperCustom;

	@Autowired
	private OptionsMapper optionsMapper;

	@Override
	public OptionsCustom getOptions() throws Exception {
		Options options = optionsMapperCustom.getOptions();
		OptionsCustom optionsCustom = new OptionsCustom();
		if(options!=null) {
			BeanUtils.copyProperties(options, optionsCustom);
		}
		return optionsCustom;
	}

	@Override
	public void insertOptions(Options options) throws Exception {
		optionsMapper.insertSelective(options);
	}

	@Override
	public void updateOptions(Options options) throws Exception {
		optionsMapper.updateByPrimaryKeySelective(options);
	}
}
