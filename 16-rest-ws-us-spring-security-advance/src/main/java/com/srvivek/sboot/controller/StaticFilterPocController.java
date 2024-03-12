/**
 * 
 */
package com.srvivek.sboot.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srvivek.sboot.bean.StaticFilterBean;
import com.srvivek.sboot.bean.StaticFilterBean2;

/**
 * 
 */
@RestController
@RequestMapping(path = "/filter")
public class StaticFilterPocController {

	@GetMapping("/bean")
	public StaticFilterBean filterBean() {
		return new StaticFilterBean("1001", "Vivek", "AMDWD9774K", new Date());
	}

	@GetMapping("/list")
	public List<StaticFilterBean> filterBeanList() {

		return Arrays.asList(new StaticFilterBean("1001", "Vivek", "AMDWD9774K", new Date()),
				new StaticFilterBean("1001", "Rahul", "INTWD9774M", new Date()));
	}

	@GetMapping("/v2/bean")
	public StaticFilterBean2 filterBeanV2() {
		return new StaticFilterBean2("1001", "Vivek", "AMDWD9774K", new Date());
	}

	@GetMapping("/v2/list")
	public List<StaticFilterBean2> filterBeanListV2() {

		return Arrays.asList(new StaticFilterBean2("1001", "Vivek", "AMDWD9774K", new Date()),
				new StaticFilterBean2("1001", "Rahul", "INTWD9774M", new Date()));
	}

}
