import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPort extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private IBoat sail;
	private Port<IBoat> port;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPort frame = new FormPort();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormPort() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanelPort panelPort = new JPanelPort();
		panelPort.setBounds(33, 21, 652, 560);
		contentPane.add(panelPort);
		
		port = new Port<IBoat>(15, panelPort.getWidth(), panelPort.getHeight());
		panelPort.setParking(port);
		
		JButton buttonSetBoat = new JButton(
				"\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u043F\u0430\u0440\u0443\u0441\u043D\u0438\u043A");
		buttonSetBoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color firstColor = JColorChooser.showDialog(null, "Выберите основной цвет", Color.black);
				Color secondColor = JColorChooser.showDialog(null, "Выберите дополнительный цвет", Color.ORANGE);
				sail = new Boat(100 + (int) (Math.random() * 300), 1000 + (int) (Math.random() * 2000), firstColor,
						secondColor, true, true);
				port.addTransport(sail);
				panelPort.repaint();
			}
		});
		buttonSetBoat.setBounds(695, 55, 181, 23);
		contentPane.add(buttonSetBoat);
		
		JButton buttonSetSail = new JButton(
				"\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u043B\u043E\u0434\u043A\u0443");
		buttonSetSail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color firstColor = JColorChooser.showDialog(null, "Выберите основной цвет", Color.blue);
				sail = new Sail(100 + (int) (Math.random() * 300), 1000 + (int) (Math.random() * 2000), firstColor);
				port.addTransport(sail);
				panelPort.repaint();
			}
		});
		buttonSetSail.setBounds(695, 21, 181, 23);
		contentPane.add(buttonSetSail);
		
		JPanel panelGroupElements = new JPanel();
		panelGroupElements.setBounds(695, 89, 181, 169);
		contentPane.add(panelGroupElements);
		panelGroupElements.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u041C\u0435\u0441\u0442\u043E");
		lblNewLabel.setBounds(10, 14, 40, 14);
		panelGroupElements.add(lblNewLabel);
		
		JPanelDraw panelTakeTransport = new JPanelDraw();
		panelTakeTransport.setBounds(10, 72, 159, 88);
		panelGroupElements.add(panelTakeTransport);
		
		JButton buttonTake = new JButton(
				"\u0417\u0430\u0431\u0440\u0430\u0442\u044C");
		buttonTake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int numberOfPlace = 0;
				try {
					numberOfPlace = Integer.parseInt(textField.getText());
				} catch (Exception ex) {
					textField.setText("Invalid input");
					return;
				}
				if (numberOfPlace >= port._places.size() || numberOfPlace < 0) {
					textField.setText("Invalid input");
					return;
				}
				sail = port.removeTransport(numberOfPlace);
				if (sail != null) {
					sail.SetPosition(5, 25, panelTakeTransport.getWidth(), panelTakeTransport.getHeight());
				}
				panelTakeTransport.setTransport(sail);
				panelTakeTransport.repaint();
				panelPort.repaint();
			}
		});
		buttonTake.setBounds(10, 39, 159, 23);
		panelGroupElements.add(buttonTake);
		
		textField = new JTextField();
		textField.setBounds(55, 11, 114, 20);
		panelGroupElements.add(textField);
		textField.setColumns(10);
	}

}
