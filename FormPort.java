
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
	private MultiLevelPort parking;
	private final int countLevel = 5;

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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FormPort() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 632);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanelPort panelPort = new JPanelPort();
		panelPort.setBounds(33, 21, 632, 555);
		contentPane.add(panelPort);

		DefaultListModel listModel = new DefaultListModel();
		for (int i = 0; i < countLevel; i++) {
			listModel.addElement("\u0423\u0440\u043E\u0432\u0435\u043D\u044C " + Integer.toString(i + 1));
		}
		JList list = new JList(listModel);
		list.setBackground(SystemColor.control);
		list.setBounds(699, 21, 206, 107);
		contentPane.add(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setSelectedIndex(0);
		ListSelectionListener listSelectionListener = new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				panelPort.repaint();
			}
		};
		list.addListSelectionListener(listSelectionListener);
		parking = new MultiLevelPort(countLevel, panelPort.getWidth(), panelPort.getHeight());
		panelPort.setPort(parking);
		panelPort.setList(list);

		JButton buttonSetBoat = new JButton(
				"\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u043F\u0430\u0440\u0443\u0441\u043D\u0438\u043A");
		buttonSetBoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color firstColor = JColorChooser.showDialog(null, "�������� �������� ����", Color.black);
				Color secondColor = JColorChooser.showDialog(null, "�������� �������������� ����", Color.ORANGE);
				sail = new Boat(100 + (int) (Math.random() * 300), 1000 + (int) (Math.random() * 2000), firstColor,
						secondColor, true, true);
				int place = parking.getAt(list.getSelectedIndex()).addTransport(sail);
				if (place == -1) {
					JOptionPane.showMessageDialog(null, "��� ��������� ����");
				}
				panelPort.repaint();
			}
		});
		buttonSetBoat.setBounds(699, 194, 206, 23);
		contentPane.add(buttonSetBoat);

		JButton buttonSetSail = new JButton(
				"\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u043B\u043E\u0434\u043A\u0443");
		buttonSetSail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color firstColor = JColorChooser.showDialog(null, "�������� �������� ����", Color.blue);
				sail = new Sail(100 + (int) (Math.random() * 300), 1000 + (int) (Math.random() * 2000), firstColor);
				int place = parking.getAt(list.getSelectedIndex()).addTransport(sail);
				if (place == -1) {
					JOptionPane.showMessageDialog(null, "��� ��������� ����");
				}
				panelPort.repaint();
			}
		});
		buttonSetSail.setBounds(699, 160, 206, 23);
		contentPane.add(buttonSetSail);

		JPanel panelGroupElements = new JPanel();
		panelGroupElements.setBackground(SystemColor.control);
		panelGroupElements.setBounds(699, 228, 206, 198);
		contentPane.add(panelGroupElements);
		panelGroupElements.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u041C\u0435\u0441\u0442\u043E");
		lblNewLabel.setBounds(10, 14, 40, 14);
		panelGroupElements.add(lblNewLabel);

		JPanelDraw panelTakeTransport = new JPanelDraw();
		panelTakeTransport.setBounds(10, 72, 127, 121);
		panelGroupElements.add(panelTakeTransport);

		JButton buttonTake = new JButton(
				"\u0417\u0430\u0431\u0440\u0430\u0442\u044C");
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
				if (numberOfPlace >= parking.getAt(list.getSelectedIndex())._places.size() || numberOfPlace < 0) {
					textField.setText("Invalid input");
					return;
				}
				sail = parking.getAt(list.getSelectedIndex()).removeTransport(numberOfPlace);
				if (sail != null) {
					sail.SetPosition(5, 25, panelTakeTransport.getWidth(), panelTakeTransport.getHeight());
				}
				panelTakeTransport.setTransport(sail);
				panelTakeTransport.repaint();
				panelPort.repaint();
			}
		});

		buttonTake.setBounds(10, 39, 186, 23);
		panelGroupElements.add(buttonTake);

		textField = new JTextField();
		textField.setBounds(60, 11, 136, 20);
		panelGroupElements.add(textField);
		textField.setColumns(10);
	}
}
