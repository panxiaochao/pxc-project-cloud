package io.github.panxiaochao.system.common.config;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * <p>
 * 快速失败机制（单个参数校验失败后，立马抛出异常，不再对剩下的参数进行校验）配置.
 * </p>
 *
 * @author Lypxc
 * @since 2023-11-30
 */
@Configuration
public class ValidatorConfig {

	/**
	 * 快速失败机制（单个参数校验失败后，立马抛出异常，不再对剩下的参数进行校验）
	 * @return Validator
	 */
	@Bean
	public Validator validator() {
		HibernateValidatorConfiguration configure = Validation.byProvider(HibernateValidator.class).configure();
		ValidatorFactory validatorFactory = configure.failFast(true).buildValidatorFactory();
		return validatorFactory.getValidator();
	}

}
