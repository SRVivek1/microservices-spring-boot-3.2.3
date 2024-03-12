/**
 * 
 */
package com.srvivek.sboot.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.srvivek.sboot.ResponseMappingJacksonFilter;
import com.srvivek.sboot.bean.DynamicFilterBean;
import com.srvivek.sboot.bean.DynamicFilterBean2;

/**
 * 
 */
@RestController
@RequestMapping(path = "/filter")
public class DynamicFilterPocController {

	@Autowired
	ResponseMappingJacksonFilter responseMappingJacksonFilter;

	@GetMapping("/bean")
	public MappingJacksonValue filterBean() {

		DynamicFilterBean dynamicFilterBean = new DynamicFilterBean("1001", "Vivek", "AMDWD9774K", new Date());

		PropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept(new String[] { "id", "name" });

		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("DynamicFilterBean", propertyFilter);

		MappingJacksonValue mjv = new MappingJacksonValue(dynamicFilterBean);
		mjv.setFilters(filterProvider);

		return mjv;
	}

	@GetMapping("/list")
	public MappingJacksonValue filterBeanList() {

		final List<DynamicFilterBean> resp = Arrays.asList(
				new DynamicFilterBean("1001", "Vivek", "AMDWD9774K", new Date()),
				new DynamicFilterBean("1001", "Rahul", "INTWD9774M", new Date()));

		PropertyFilter beanFilter = SimpleBeanPropertyFilter.filterOutAllExcept(new String[] { "pan", "doj" });
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("DynamicFilterBean", beanFilter);

		final MappingJacksonValue mjv = new MappingJacksonValue(resp);
		mjv.setFilters(filterProvider);

		return mjv;
	}

	@GetMapping("/v2/bean")
	public MappingJacksonValue filterBeanV2() {

		return responseMappingJacksonFilter.doFilter(new DynamicFilterBean2("1001", "Vivek", "AMDWD9774K", new Date()),
				"DynamicFilterBean2", "id", "name");
	}

	@GetMapping("/v2/list")
	public MappingJacksonValue filterBeanListV2() {

		List<DynamicFilterBean2> beanList = Arrays.asList(
				new DynamicFilterBean2("1001", "Vivek", "AMDWD9774K", new Date()),
				new DynamicFilterBean2("1001", "Rahul", "INTWD9774M", new Date()));

		return responseMappingJacksonFilter.doFilterGeneric(beanList, "DynamicFilterBean2", "pan", "doj");
	}
}
