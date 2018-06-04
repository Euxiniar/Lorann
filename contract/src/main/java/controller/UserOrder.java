package controller;

/**
 * <h1>The UserOrder Class.</h1>
 * 
 * @author Anatole Couasnon.
 * @version 1.0
 */
public class UserOrder implements IUserOrder{
	/**
	 * the order.
	 */
	private final Order	order;

	/**
	 * Creates the UserOrder.
	 * @param order
	 * 			the order.
	 */
	public UserOrder(final Order order) {
		this.order = order;
	}

	/**
	 * Gets the order.
	 * @return the order.
	 */
	public Order getOrder() {
		return this.order;
	}
}
