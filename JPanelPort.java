import javax.swing.*;

import java.awt.*;

public class JPanelPort extends JPanel{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private MultiLevelPort port;

	@SuppressWarnings("rawtypes")
	private JList list;
	public void setPort(MultiLevelPort port) {
		this.port = port;
	}

	@SuppressWarnings("rawtypes")
	public void setList(JList list) {
		this.list = list;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		try {
			if (port != null) {
				if (list.getSelectedIndex() != -1) {
					port.getAt(list.getSelectedIndex()).Draw(g);
				}
			}
		} catch (Exception ex) {
		}
	}
}
