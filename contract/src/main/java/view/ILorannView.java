package view;
/**
 * <h1>The ILorannView Class.</h1>
 *
 * @author Anatole Couasnon
 * @version 1.0
 */
public interface ILorannView {
	/**
	 * display a message on a pop up 
	 * @param message
	 * the message to display
	 */
	public void displayMessage(final String message);
	/**
	 * close the frame
	 */
	public void closeAll();
	/**
	 * get the orders bools
	 * @return
	 * the order bools
	 */
	boolean[] getBools();
	/**
	 * reset the orders bools
	 */
	public void resetBools();
}
