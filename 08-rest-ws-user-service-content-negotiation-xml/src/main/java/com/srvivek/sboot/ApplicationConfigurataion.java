/**
 * 
 */
package com.srvivek.sboot;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * Application Beans configuration.
 */
@Configuration
public class ApplicationConfigurataion {

	/**
	 * Locale resolved with default locale as {@link Locale.US}
	 * 
	 * @return
	 */
	@Bean
	LocaleResolver localeReslver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}

	@Bean
	ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource msgSource = new ResourceBundleMessageSource();
		msgSource.setBasename("i18n/messages");
		return msgSource;
	}
}
