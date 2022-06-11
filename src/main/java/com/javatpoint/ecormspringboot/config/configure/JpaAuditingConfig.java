package com.javatpoint.ecormspringboot.config.configure;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig {

	@Bean
	public AuditorAware<String> auditorProvider() {
		return new AuditorAwareImpl();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static class AuditorAwareImpl implements AuditorAware<String> {
		@Override
		public String getCurrentAuditor() {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication == null || !authentication.isAuthenticated()) {
				System.out.printf("authentication == null " + "JpaAuditingConfig");
				return null;
			}
			System.out.printf("JpaAuditingConfig");
			return authentication.getName();
		}
	}
}
