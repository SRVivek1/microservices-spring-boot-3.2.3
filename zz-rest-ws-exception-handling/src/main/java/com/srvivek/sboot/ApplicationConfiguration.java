package com.srvivek.sboot;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ApplicationConfiguration {

	@Bean
	LocaleResolver localeResolver() {
		SessionLocaleResolver locale = new SessionLocaleResolver();
		locale.setDefaultLocale(Locale.US);
		return locale;
	}
	
	@Bean
	ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("i18n/messages");
		return messageSource;
	}
}
