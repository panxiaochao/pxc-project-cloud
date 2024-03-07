package io.github.panxiaochao.system.common.core.context;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-03-07
 * @version 1.0
 */
public interface SContextHolderStrategy {

	/**
	 * Clears the current context.
	 */
	void clearContext();

	/**
	 * Obtains the current context.
	 * @return a context
	 */
	SContext getContext();

	/**
	 * Sets the current context.
	 * @param context to the new context
	 */
	void setContext(SContext context);

	/**
	 * Creates a new empty context
	 * @return the empty context.
	 */
	SContext createEmptyContext();

}
