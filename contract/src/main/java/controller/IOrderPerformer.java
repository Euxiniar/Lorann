package controller;

/**
 * <h1>The IOrderPerformer Interface.</h1>
 * 
 * @author Anatole Couasnon.
 * @version 1.0
 */
public interface IOrderPerformer {

	/**
	 * The function which allow to make things thanks to User Orders.
	 * @see controller.UserOrder
	 * @see controller.Order
	 */
	void orderPerform();
}
