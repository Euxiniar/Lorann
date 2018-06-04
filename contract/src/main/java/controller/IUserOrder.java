package controller;

/**
 * <h1>The IUserOrder Interface.</h1>
 * 
 * @author Anatole Couasnon.
 * @version 1.0
 */
public interface IUserOrder {
	/**
	 * Gets the orders from the user.
	 * @return the order from the user.
	 * @see controller.Order
	 */
	Order getOrder();
}