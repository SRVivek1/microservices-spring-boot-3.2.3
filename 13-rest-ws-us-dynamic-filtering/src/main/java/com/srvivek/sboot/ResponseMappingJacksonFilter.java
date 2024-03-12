/**
 * 
 */
package com.srvivek.sboot;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.srvivek.sboot.bean.DynamicFilterBean;
import com.srvivek.sboot.bean.DynamicFilterBean2;

/**
 * 
 */
@Service
public class ResponseMappingJacksonFilter {

	/**
	 * Filter out all properties except for the given ones.
	 * 
	 * @param bean
	 * @param filterBeanName
	 * @param allowedField
	 * @return
	 */
	public MappingJacksonValue doFilter(DynamicFilterBean bean, String filterBeanName, String... allowedField) {

		final MappingJacksonValue mjv = new MappingJacksonValue(bean);
		mjv.setFilters(new SimpleFilterProvider().addFilter(filterBeanName,
				SimpleBeanPropertyFilter.filterOutAllExcept(allowedField)));

		return mjv;
	}

	/**
	 * Filter out all properties except for the given ones.
	 * 
	 * @param bean
	 * @param filterBeanName
	 * @param allowedField
	 * @return
	 */
	public MappingJacksonValue doFilter(DynamicFilterBean2 bean, String filterBeanName, String... allowedField) {

		final MappingJacksonValue mjv = new MappingJacksonValue(bean);
		mjv.setFilters(new SimpleFilterProvider().addFilter(filterBeanName,
				SimpleBeanPropertyFilter.filterOutAllExcept(allowedField)));

		return mjv;
	}

	/**
	 * Filter out all properties except for the given ones.
	 * 
	 * @param <T>
	 * 
	 * @param bean
	 * @param filterBeanName
	 * @param allowedField
	 * @return
	 */
	public <T> MappingJacksonValue doFilterGeneric(T bean, String filterBeanName, String... allowedField) {

		final MappingJacksonValue mjv = new MappingJacksonValue(bean);
		mjv.setFilters(new SimpleFilterProvider().addFilter(filterBeanName,
				SimpleBeanPropertyFilter.filterOutAllExcept(allowedField)));

		return mjv;
	}

}
