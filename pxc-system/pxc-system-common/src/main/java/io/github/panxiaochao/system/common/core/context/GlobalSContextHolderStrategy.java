package io.github.panxiaochao.system.common.core.context;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-03-07
 * @version 1.0
 */
public class GlobalSContextHolderStrategy implements SContextHolderStrategy {

	private static SContext CONTEXT_HOLDER;

	/**
	 * Clears the current context.
	 */
	@Override
	public void clearContext() {
		CONTEXT_HOLDER = null;
	}

	/**
	 * Obtains the current context.
	 * @return a context
	 */
	@Override
	public SContext getContext() {
		if (CONTEXT_HOLDER == null) {
			CONTEXT_HOLDER = new SContextImpl();
		}
		return CONTEXT_HOLDER;
	}

	/**
	 * Sets the current context.
	 * @param context to the new context
	 */
	@Override
	public void setContext(SContext context) {
		// Assert.notNull(context, "Only non-null SContext instances are permitted");
		// this.CONTEXT_HOLDER = context;
	}

	/**
	 * Creates a new empty context
	 * @return the empty context.
	 */
	@Override
	public SContext createEmptyContext() {
		return new SContextImpl();
	}

}
