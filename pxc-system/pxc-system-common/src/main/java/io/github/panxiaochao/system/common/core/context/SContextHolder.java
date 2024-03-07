package io.github.panxiaochao.system.common.core.context;

import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Constructor;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-03-07
 * @version 1.0
 */
public class SContextHolder {

	public static final String MODE_THREADLOCAL = "MODE_THREADLOCAL";

	public static final String MODE_GLOBAL = "MODE_GLOBAL";

	private static String strategyName = MODE_THREADLOCAL;

	private static SContextHolderStrategy strategy;

	static {
		initialize();
	}

	private static void initialize() {
		if (!StringUtils.hasText(strategyName)) {
			// Set default
			strategyName = MODE_THREADLOCAL;
		}
		if (strategyName.equals(MODE_THREADLOCAL)) {
			strategy = new ThreadLocalSContextHolderStrategy();
			return;
		}

		if (strategyName.equals(MODE_GLOBAL)) {
			strategy = new GlobalSContextHolderStrategy();
			return;
		}
		// Try to load a custom strategy
		try {
			Class<?> clazz = Class.forName(strategyName);
			Constructor<?> customStrategy = clazz.getConstructor();
			strategy = (SContextHolderStrategy) customStrategy.newInstance();
		}
		catch (Exception ex) {
			ReflectionUtils.handleReflectionException(ex);
		}
	}

	/**
	 * 更改首选策略, 不要对给定的JVM多次调用此方法, 因为它将重新初始化策略并对已经在使用的现有线程策略产生不利的影响
	 * @param strategyName 策略名
	 */
	public static void setStrategyName(String strategyName) {
		SContextHolder.strategyName = strategyName;
		initialize();
	}

	/**
	 * Clears the current context.
	 */
	public static void clearContext() {
		strategy.clearContext();
	}

	/**
	 * Obtains the current context.
	 * @return a context
	 */
	public static SContext getContext() {
		return strategy.getContext();
	}

	/**
	 * Sets the current context.
	 * @param context to the new context
	 */
	public static void setContext(SContext context) {
		strategy.setContext(context);
	}

	/**
	 * Creates a new empty context
	 * @return the empty context.
	 */
	public static SContext createEmptyContext() {
		//
		return strategy.createEmptyContext();
	}

}
