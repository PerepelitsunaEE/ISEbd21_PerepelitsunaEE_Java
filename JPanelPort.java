import javax.swing.*;
import java.awt.*;

public class JPanelPort extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Port<IBoat> port;

	public void setParking(Port<IBoat> port) {
		this.port = port;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		try {
			if (port != null) {
				port.Draw(g);
			}
		} catch (Exception ex) {
		}
	}
}
