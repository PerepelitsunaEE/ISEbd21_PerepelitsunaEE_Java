import javax.swing.*;
import java.awt.*;

public class JPanelDraw extends JPanel {
	private static final long serialVersionUID = 1L;
	private IBoat sail;

	public void setTransport(IBoat transport) {
		this.sail = transport;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (sail != null) {
			sail.DrawSail(g);
		}
	}
}
