package view;
/**
 * <h1>The ILorannView.java Class.</h1>
 *
 * @author Anatole Couasnon
 * @version 1.0
 */
public interface ILorannView {
	public void displayMessage(final String message);
	public void closeAll();
	boolean[] getBools();
	public void resetBools();
}
