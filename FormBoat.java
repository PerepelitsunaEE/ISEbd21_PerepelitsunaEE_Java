import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormBoat extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Boat boat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBoat frame = new FormBoat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		try {
			if (boat != null) {
				boat.DrawBoat(g);
			}
		} catch (Exception ex) {

		}
	}
	
	public void MoveButton(JButton sender) {
		try {
			String name = sender.getToolTipText();
			switch (name) {
			case "Up":
				boat.MoveBoat(Direction.Up);
				break;
			case "Down":
				boat.MoveBoat(Direction.Down);
				break;
			case "Left":
				boat.MoveBoat(Direction.Left);
				break;
			case "Right":
				boat.MoveBoat(Direction.Right);
				break;
			}
			this.repaint();
		} catch (Exception ex) {
			
		}
	}

	/**
	 * Create the frame.
	 */
	public FormBoat() {
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 880, 480);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					boat = new Boat(100 + (int) (Math.random() * 300), 1000 + (int) (Math.random() * 2000),
							Color.BLACK, Color.BLUE, true, true);
				} catch (Exception e) {
					
					e.printStackTrace();
				}

				try {
					boat.SetPosition(70 + (int) (Math.random() * 160), 70 + (int) (Math.random() * 160),
							FormBoat.this.getWidth(), FormBoat.this.getHeight());
				} catch (Exception e) {
					
					e.printStackTrace();
				}

				FormBoat.this.repaint();

			}
		});
		
		btnCreate.setBounds(10, 11, 89, 23);
		panel.add(btnCreate);
		
		JButton btnUp = new JButton("");
		btnUp.setToolTipText("Up");
		btnUp.setIcon(new ImageIcon("C:\\Users\\\u0415\u043A\u0430\u0442\u0435\u0440\u0438\u043D\u0430\\Documents\\2 \u043A\u0443\u0440\u0441\\\u0422\u0435\u0445\u043D\u043E\u043B\u043E\u0433\u0438\u0438 \u043F\u0440\u043E\u0433\u0440\u0430\u043C\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044F\\\u041B\u0430\u0431\u044B\\Java\\Up.png"));
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MoveButton(btnUp);
			}
		});
		btnUp.setBounds(784, 383, 30, 30);
		panel.add(btnUp);
		
		JButton btnDown = new JButton("");
		btnDown.setToolTipText("Down");
		btnDown.setIcon(new ImageIcon("C:\\Users\\\u0415\u043A\u0430\u0442\u0435\u0440\u0438\u043D\u0430\\Documents\\2 \u043A\u0443\u0440\u0441\\\u0422\u0435\u0445\u043D\u043E\u043B\u043E\u0433\u0438\u0438 \u043F\u0440\u043E\u0433\u0440\u0430\u043C\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044F\\\u041B\u0430\u0431\u044B\\Java\\Down.png"));
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MoveButton(btnDown);
			}
		});
		btnDown.setBounds(784, 424, 30, 30);
		panel.add(btnDown);
		
		JButton btnLeft = new JButton("");
		btnLeft.setToolTipText("Left");
		btnLeft.setIcon(new ImageIcon("C:\\Users\\\u0415\u043A\u0430\u0442\u0435\u0440\u0438\u043D\u0430\\Documents\\2 \u043A\u0443\u0440\u0441\\\u0422\u0435\u0445\u043D\u043E\u043B\u043E\u0433\u0438\u0438 \u043F\u0440\u043E\u0433\u0440\u0430\u043C\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044F\\\u041B\u0430\u0431\u044B\\Java\\Left.png"));
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MoveButton(btnLeft);
			}
		});
		btnLeft.setBounds(744, 424, 30, 30);
		panel.add(btnLeft);
		
		JButton btnRight = new JButton("");
		btnRight.setToolTipText("Right");
		btnRight.setIcon(new ImageIcon("C:\\Users\\\u0415\u043A\u0430\u0442\u0435\u0440\u0438\u043D\u0430\\Documents\\2 \u043A\u0443\u0440\u0441\\\u0422\u0435\u0445\u043D\u043E\u043B\u043E\u0433\u0438\u0438 \u043F\u0440\u043E\u0433\u0440\u0430\u043C\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044F\\\u041B\u0430\u0431\u044B\\Java\\Right.png"));
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MoveButton(btnRight);
			}
		});
		btnRight.setBounds(824, 424, 30, 30);
		panel.add(btnRight);
	}
}
