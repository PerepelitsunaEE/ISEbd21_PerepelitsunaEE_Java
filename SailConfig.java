import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JDialog;

public class SailConfig extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IBoat sail;
	JPanel panel;
	boolean r;

	Color color;
	Color dopColor;
	int maxSpeed;

	public SailConfig(JFrame parent) {
		super(parent, true);
		initialize();
	}

	public boolean res() {
		setVisible(true);
		return r;
	}

	private void initialize() {
		this.getContentPane().setBackground(SystemColor.control);
		this.setBounds(100, 100, 390, 300);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);

		JLabel lblSail = new JLabel("Sail");
		lblSail.setBackground(SystemColor.controlHighlight);
		lblSail.setBounds(10, 29, 113, 14);
		this.getContentPane().add(lblSail);

		JLabel lblBoat = new JLabel("Boat");
		lblBoat.setBackground(SystemColor.controlHighlight);
		lblBoat.setBounds(10, 64, 124, 14);
		this.getContentPane().add(lblBoat);

		panel = new JPanel();
		panel.getLayout();
		panel.setBounds(130, 11, 120, 112);
		this.getContentPane().add(panel);

		MouseListener mouseL = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				JComponent jc = (JComponent) e.getSource();
				TransferHandler th = jc.getTransferHandler();
				th.exportAsDrag(jc, e, TransferHandler.COPY);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		};

		lblSail.addMouseListener(mouseL);
		lblBoat.addMouseListener(mouseL);
		lblBoat.setTransferHandler(new TransferHandler("text"));
		lblSail.setTransferHandler(new TransferHandler("text"));

		panel.setDropTarget(new DropTarget() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void drop(DropTargetDropEvent e) {

				try {

					for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
						if (e.getTransferable().getTransferData(df) == "Sail") {
							sail = new Sail(100 + (int) (Math.random() * 300), 1000 + (int) (Math.random() * 2000),
									Color.BLUE);
						} else if (e.getTransferable().getTransferData(df) == "Boat") {
							sail = new Boat(100 + (int) (Math.random() * 300), 1000 + (int) (Math.random() * 2000),
									Color.BLACK, Color.ORANGE, true, true);
						}
						draw(panel, sail);
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}

			}

			public void dragEnter(DropTargetDragEvent e) {
				for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
					try {
						if (e.getTransferable().getTransferData(df) instanceof String)
							e.acceptDrag(DnDConstants.ACTION_COPY);
						else
							e.acceptDrag(DnDConstants.ACTION_NONE);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		JLabel lblMainColor = new JLabel("Main Color");
		lblMainColor.setBounds(130, 134, 90, 27);
		this.getContentPane().add(lblMainColor);

		JLabel lblDopColor = new JLabel("Dop Color");
		lblDopColor.setBounds(130, 169, 90, 27);
		this.getContentPane().add(lblDopColor);

		lblMainColor.setDropTarget(new DropTarget() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void drop(DropTargetDropEvent e) {
				if (sail != null) {
					try {
						for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
							sail.setMainColor((selectColor(e.getTransferable().getTransferData(df).toString())));
							draw(panel, sail);
						}
					} catch (Exception ex) {
						System.out.println(ex + "FF");
					}
				}
			}

			public void dragEnter(DropTargetDragEvent e) {
				for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
					try {
						if (e.getTransferable().getTransferData(df) instanceof String)
							e.acceptDrag(DnDConstants.ACTION_COPY);
						else
							e.acceptDrag(DnDConstants.ACTION_NONE);
					} catch (UnsupportedFlavorException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		lblDopColor.setDropTarget(new DropTarget() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void drop(DropTargetDropEvent e) {
				if (sail != null) {
					try {

						for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
							((Boat) sail)
									.setDopColor((selectColor(e.getTransferable().getTransferData(df).toString())));
							draw(panel, sail);
						}
					} catch (Exception ex) {
						System.out.println(ex);
					}
				}
			}

			public void dragEnter(DropTargetDragEvent e) {
				for (DataFlavor df : e.getTransferable().getTransferDataFlavors()) {
					try {
						if (e.getTransferable().getTransferData(df) instanceof String)
							e.acceptDrag(DnDConstants.ACTION_COPY);
						else
							e.acceptDrag(DnDConstants.ACTION_NONE);
					} catch (UnsupportedFlavorException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		JPanel panelYellow = new JPanel();
		panelYellow.setName("yellow");
		panelYellow.setBackground(Color.YELLOW);
		panelYellow.setBounds(263, 11, 46, 39);
		this.getContentPane().add(panelYellow);

		JPanel panelBlue = new JPanel();
		panelBlue.setName("blue");
		panelBlue.setBackground(Color.BLUE);
		panelBlue.setBounds(319, 11, 46, 39);
		this.getContentPane().add(panelBlue);

		JPanel panelRed = new JPanel();
		panelRed.setName("red");
		panelRed.setBackground(Color.RED);
		panelRed.setBounds(263, 55, 46, 39);
		this.getContentPane().add(panelRed);

		JPanel panelGreen = new JPanel();
		panelGreen.setName("green");
		panelGreen.setBackground(Color.GREEN);
		panelGreen.setBounds(319, 55, 46, 39);
		this.getContentPane().add(panelGreen);

		JPanel panelBlack = new JPanel();
		panelBlack.setName("black");
		panelBlack.setBackground(Color.BLACK);
		panelBlack.setBounds(263, 98, 46, 39);
		this.getContentPane().add(panelBlack);

		JPanel panelPink = new JPanel();
		panelPink.setName("pink");
		panelPink.setBackground(Color.PINK);
		panelPink.setBounds(319, 98, 46, 39);
		this.getContentPane().add(panelPink);

		JPanel panelMagenta = new JPanel();
		panelMagenta.setName("magenta");
		panelMagenta.setBackground(Color.MAGENTA);
		panelMagenta.setBounds(263, 143, 46, 39);
		this.getContentPane().add(panelMagenta);

		JPanel panelCyan = new JPanel();
		panelCyan.setName("cyan");
		panelCyan.setBackground(Color.CYAN);
		panelCyan.setBounds(319, 143, 46, 39);
		this.getContentPane().add(panelCyan);

		panelYellow.addMouseListener(mouseL);
		panelYellow.setTransferHandler(new TransferHandler("name"));

		panelBlue.addMouseListener(mouseL);
		panelBlue.setTransferHandler(new TransferHandler("name"));

		panelRed.addMouseListener(mouseL);
		panelRed.setTransferHandler(new TransferHandler("name"));

		panelGreen.addMouseListener(mouseL);
		panelGreen.setTransferHandler(new TransferHandler("name"));

		panelBlack.addMouseListener(mouseL);
		panelBlack.setTransferHandler(new TransferHandler("name"));

		panelPink.addMouseListener(mouseL);
		panelPink.setTransferHandler(new TransferHandler("name"));

		panelMagenta.addMouseListener(mouseL);
		panelMagenta.setTransferHandler(new TransferHandler("name"));

		panelCyan.addMouseListener(mouseL);
		panelCyan.setTransferHandler(new TransferHandler("name"));

		JButton btnAdd = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				r = true;
				dispose();
			}
		});
		btnAdd.setBounds(10, 193, 96, 23);
		this.getContentPane().add(btnAdd);

		JButton btnNO = new JButton("\u041E\u0442\u043C\u0435\u043D\u0430");
		btnNO.setBounds(10, 227, 96, 23);
		this.getContentPane().add(btnNO);
		btnNO.addActionListener((ActionEvent e) -> {
			r = false;
			dispose();
		});
	}

	public IBoat getSail() {
		return sail;
	}

	public void draw(JPanel panel, IBoat sail) {
		if (sail != null) {
			Graphics gr = panel.getGraphics();
			gr.clearRect(0, 0, panel.getWidth(), panel.getHeight());
			sail.SetPosition(10, 35, panel.getWidth(), panel.getHeight());
			sail.DrawSail(gr);
		}
	}

	public Color selectColor(String s) {
		switch (s) {
		case "yellow":
			return Color.yellow;
		case "blue":
			return Color.blue;
		case "red":
			return Color.red;
		case "green":
			return Color.green;
		case "black":
			return Color.black;
		case "pink":
			return Color.pink;
		case "magenta":
			return Color.magenta;
		case "cyan":
			return Color.cyan;
		}

		return null;
	}
}