/**
 * 
 */
package com.srvivek.sboot.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srvivek.sboot.cloud.LimitConfiguration;
import com.srvivek.sboot.cloud.bean.LimitSetting;

/**
 * 
 */
@RestController
public class LimitConfigurationController {

	@Autowired
	LimitConfiguration properties;

	@GetMapping(path = "/limits")
	public LimitSetting retriveLimitsFromCOnfiguration() {

		return new LimitSetting(properties.getMaximum(), properties.getMinimum(), properties.getCommon());
	}
}
