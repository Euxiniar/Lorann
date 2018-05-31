package controller;

import model.order.Order;

public class UserOrder {
	private final Order	order;

	public UserOrder(final Order order) {
		this.order = order;
	}


	public Order getOrder() {
		return this.order;
	}
}
