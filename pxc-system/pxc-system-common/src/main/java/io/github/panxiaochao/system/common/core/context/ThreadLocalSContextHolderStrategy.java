package io.github.panxiaochao.system.common.core.context;

import org.springframework.util.Assert;

/**
 * <p>
 * </p>
 *
 * @author Lypxc
 * @since 2024-03-07
 * @version 1.0
 */
public class ThreadLocalSContextHolderStrategy implements SContextHolderStrategy {

	private static final ThreadLocal<SContext> CONTEXT_HOLDER = new ThreadLocal<>();

	/**
	 * Clears the current context.
	 */
	@Override
	public void clearContext() {
		CONTEXT_HOLDER.remove();
	}

	/**
	 * Obtains the current context.
	 * @return a context
	 */
	@Override
	public SContext getContext() {
		SContext ctx = CONTEXT_HOLDER.get();
		if (ctx == null) {
			ctx = createEmptyContext();
			CONTEXT_HOLDER.set(ctx);
		}
		return ctx;
	}

	/**
	 * Sets the current context.
	 * @param context to the new context
	 */
	@Override
	public void setContext(SContext context) {
		Assert.notNull(context, "Only non-null SecurityContext instances are permitted");
		CONTEXT_HOLDER.set(context);
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
