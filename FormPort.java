
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPort extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private static IBoat sail;
	@SuppressWarnings("rawtypes")
	private static JList list;
	private static MultiLevelPort port;
	private final int countLevel = 5;
	SailConfig select;
	private String[] elements = new String[6];

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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FormPort() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanelPort panelParking = new JPanelPort();
		panelParking.setBounds(10, 11, 634, 541);
		contentPane.add(panelParking);

		list = new JList(elements);
		list.setBounds(654, 11, 168, 107);
		contentPane.add(list);

		JButton btnLevelDown = new JButton("");
		btnLevelDown.setIcon(new ImageIcon("C:\\Users\\\u0415\u043A\u0430\u0442\u0435\u0440\u0438\u043D\u0430\\Documents\\\u0423\u0447\u0435\u0431\u0430\\2 \u043A\u0443\u0440\u0441\\\u0422\u0435\u0445\u043D\u043E\u043B\u043E\u0433\u0438\u0438 \u043F\u0440\u043E\u0433\u0440\u0430\u043C\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044F\\\u041B\u0430\u0431\u044B\\Java\\Down.png"));
		btnLevelDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				port.levelDown();
				list.setSelectedIndex(port.getCurrentLevel());
				panelParking.repaint();
			}
		});
		btnLevelDown.setBounds(832, 83, 35, 35);
		contentPane.add(btnLevelDown);

		JButton btnLevelUp = new JButton("");
		btnLevelUp.setIcon(new ImageIcon("C:\\Users\\\u0415\u043A\u0430\u0442\u0435\u0440\u0438\u043D\u0430\\Documents\\\u0423\u0447\u0435\u0431\u0430\\2 \u043A\u0443\u0440\u0441\\\u0422\u0435\u0445\u043D\u043E\u043B\u043E\u0433\u0438\u0438 \u043F\u0440\u043E\u0433\u0440\u0430\u043C\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044F\\\u041B\u0430\u0431\u044B\\Java\\Up.png"));
		btnLevelUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				port.levelUp();
				list.setSelectedIndex(port.getCurrentLevel());
				panelParking.repaint();
			}
		});
		btnLevelUp.setBounds(832, 11, 35, 35);
		contentPane.add(btnLevelUp);

		for (int i = 0; i < 5; i++) {
			elements[i] = "Level " + (i + 1);
		}
		port = new MultiLevelPort(countLevel, panelParking.getWidth(), panelParking.getHeight());
		panelParking.setPort(port);
		panelParking.setList(list);

		JPanel panelGroupElements = new JPanel();
		panelGroupElements.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelGroupElements.setBackground(SystemColor.control);
		panelGroupElements.setBounds(654, 359, 206, 190);
		contentPane.add(panelGroupElements);
		panelGroupElements.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u041C\u0435\u0441\u0442\u043E");
		lblNewLabel.setBounds(10, 14, 50, 14);
		panelGroupElements.add(lblNewLabel);

		JPanelDraw panelTakeTank = new JPanelDraw();
		panelTakeTank.setBounds(20, 73, 165, 103);
		panelGroupElements.add(panelTakeTank);

		JButton buttonTake = new JButton("\u0417\u0430\u0431\u0440\u0430\u0442\u044C");
		buttonTake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (list.getSelectedIndex() == -1) {
					return;
				}
				int numberOfPlace = 0;
				try {
					numberOfPlace = Integer.parseInt(textField.getText());
				} catch (Exception ex) {
					textField.setText("Invalid input");
					return;
				}
				if (numberOfPlace >= port.getAt(list.getSelectedIndex())._places.size() || numberOfPlace < 0) {
					textField.setText("Invalid input");
					return;
				}
				sail = port.getAt(list.getSelectedIndex()).removeTransport(numberOfPlace);
				if (sail != null) {
					sail.SetPosition(10, 35, panelTakeTank.getWidth(), panelTakeTank.getHeight());
				}
				panelTakeTank.setTransport(sail);
				panelTakeTank.repaint();
				panelParking.repaint();
			}
		});
		buttonTake.setBounds(20, 39, 176, 23);
		panelGroupElements.add(buttonTake);

		textField = new JTextField();
		textField.setBounds(60, 11, 136, 20);
		panelGroupElements.add(textField);
		textField.setColumns(10);

		JButton btnAdd = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getSail();
			}
		});
		btnAdd.setBounds(654, 144, 213, 23);
		contentPane.add(btnAdd);
	}

	public void getSail() {
		select = new SailConfig(frame);
		if (select.res()) {
			IBoat sail = select.getSail();
			if (sail != null) {
				int place = port.getAt(list.getSelectedIndex()).addTransport(sail);
				if (place < 0) {
					JOptionPane.showMessageDialog(null, "No free places");
				}
			}
			contentPane.repaint();
		}
	}
}
