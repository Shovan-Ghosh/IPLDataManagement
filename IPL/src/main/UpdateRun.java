package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Cursor;

public class UpdateRun extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	int xx,yy;
	String s1 = "", s2 = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateRun frame = new UpdateRun();
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
	public UpdateRun() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 460);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel label = new JLabel("-");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateRun.this.setState(JFrame.ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setBackground(Color.BLACK);
				label.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setBackground(new Color(255,215,0));
				label.setForeground(Color.BLACK);
			}
		});
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 29));
		label.setBackground(new Color(255, 215, 0));
		label.setBounds(643, 0, 35, 35);
		contentPane.add(label);
		
		JLabel lblNewLabel_5 = new JLabel("x");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_5.setBackground(Color.RED);
				lblNewLabel_5.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_5.setBackground(new Color(255,215,0));
				lblNewLabel_5.setForeground(Color.BLACK);
			}
		});
		lblNewLabel_5.setBackground(new Color(255, 215, 0));
		lblNewLabel_5.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 29));
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(678, 0, 35, 35);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1 = new JLabel("Runs / Wicket");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 48, 112, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel(" Update Run");
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				UpdateRun.this.setLocation(x - xx, y - yy);
			}
		});
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				yy = e.getY();
			}
		});
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 19));
		lblNewLabel.setBackground(new Color(255,215,0));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 713, 35);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 34, 713, 183);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("0/0");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 49));
		lblNewLabel_2.setBounds(151, 49, 419, 110);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBackground(Color.WHITE);
		textField.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		textField.setBounds(44, 276, 140, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		textField_1.setColumns(10);
		textField_1.setBounds(44, 384, 140, 40);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Run");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(44, 243, 78, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblWicket = new JLabel("Wicket");
		lblWicket.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWicket.setBounds(44, 337, 78, 20);
		contentPane.add(lblWicket);
		
		JLabel lblNewLabel_4 = new JLabel("Set");
		lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection con1 = DataBaseConnection.makeConnection();
					Statement st1 = con1.createStatement();
					st1.executeUpdate("update updaterun set run = "+textField.getText()+", wicket = "+textField_1.getText()+" where id = 1");
					ResultSet rs1 = st1.executeQuery("select * from updaterun");
					if(rs1.next()) {
						s1 = Integer.toString(rs1.getInt(2));
						s2 = Integer.toString(rs1.getInt(3));
					}
					lblNewLabel_2.setText(s1+"/"+s2);
					con1.close();
					st1.close();
					rs1.close();
					
				}
				catch (Exception ab) {
					JOptionPane.showMessageDialog(null, "Invalid entry !");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_4.setBackground(Color.BLACK);
				lblNewLabel_4.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_4.setBackground(new Color(255,215,0));
				lblNewLabel_4.setForeground(Color.BLACK);
			}
		});
		lblNewLabel_4.setBackground(new Color(255, 215, 0));
		lblNewLabel_4.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(255, 255, 255)));
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_4.setBounds(306, 275, 85, 40);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblReset = new JLabel("Reset");
		lblReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection con2 = DataBaseConnection.makeConnection();
					Statement st2 = con2.createStatement();
					st2.executeUpdate("update updaterun set run = 0, wicket = 0 where id = 1");
					lblNewLabel_2.setText("0/0");
					textField.setText("");
					textField_1.setText("");
					con2.close();
					st2.close();
				}
				catch (Exception ea) {
					JOptionPane.showMessageDialog(null, "Error !");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblReset.setBackground(Color.BLACK);
				lblReset.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblReset.setBackground(new Color(255,215,0));
				lblReset.setForeground(Color.BLACK);
			}
		});
		lblReset.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(255, 255, 255)));
		lblReset.setBackground(new Color(255, 215, 0));
		lblReset.setOpaque(true);
		lblReset.setHorizontalAlignment(SwingConstants.CENTER);
		lblReset.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblReset.setBounds(306, 383, 85, 40);
		contentPane.add(lblReset);
		
		JLabel label_1 = new JLabel("Back");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setForeground(new Color(0, 0, 0));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dashboard dashboard = new Dashboard();
				dashboard.setVisible(true);
				setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label_1.setBackground(Color.BLACK);
				label_1.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_1.setBackground(new Color(255, 99, 71));
				label_1.setForeground(Color.BLACK);
			}
		});
		label_1.setOpaque(true);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Century Gothic", Font.BOLD, 20));
		label_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(255, 255, 255)));
		label_1.setBackground(new Color(255, 99, 71));
		label_1.setBounds(531, 384, 85, 40);
		contentPane.add(label_1);
		setUndecorated(true);
	}
}
