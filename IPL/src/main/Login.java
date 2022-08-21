package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class Login extends JFrame {

	private JPanel contentPane;
	int xx,yy,a;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 499);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel label = new JLabel("-");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.this.setState(JFrame.ICONIFIED);
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
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		label.setBackground(new Color(255, 215, 0));
		label.setBounds(862, 0, 34, 34);
		contentPane.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("x");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setBackground(Color.RED);
				lblNewLabel_2.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setBackground(new Color(255,215,0));
				lblNewLabel_2.setForeground(Color.BLACK);
			}
		});
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setBackground(new Color(255,215,0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 29));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(896, 0, 34, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Image/119127432_10157642275183634_3097521787064577036_n (465 x 465).jpg")));
		lblNewLabel.setBounds(0, 34, 465, 465);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" User Login");
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 19));
		lblNewLabel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				Login.this.setLocation(x - xx, y - yy);
			}
		});
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				yy = e.getY();
			}
		});
		lblNewLabel_1.setBackground(new Color(255, 215, 0));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(0, 0, 930, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("User ID");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_3.setBounds(515, 86, 102, 34);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Century Gothic", Font.BOLD, 16));
		textField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 205)));
		textField.setOpaque(false);
		textField.setBounds(513, 145, 275, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblPassword.setBounds(515, 213, 102, 34);
		contentPane.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		textField_1.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 0, 205)));
		textField_1.setOpaque(false);
		textField_1.setColumns(10);
		textField_1.setBounds(515, 288, 275, 34);
		contentPane.add(textField_1);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection conn = DataBaseConnection.makeConnection();
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("select * from iplUser where user_id = "+textField.getText());
					if(rs.next())
					{
						a = rs.getInt(2);
					}
					conn.close();
					st.close();
					rs.close();
					if(textField_1.getText().equals(Integer.toString(a)))
					{
						Dashboard dash = new Dashboard();
						dash.setVisible(true);
						setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid User ID / Password !");
					}
				}
				catch (Exception ea) {
					JOptionPane.showMessageDialog(null, "Invalid Entry !");
					
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogin.setBackground(Color.BLACK);
				lblLogin.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogin.setBackground(new Color(255,215,0));
				lblLogin.setForeground(Color.BLACK);
			}
		});
		lblLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogin.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setOpaque(true);
		lblLogin.setBackground(new Color(255, 215, 0));
		lblLogin.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblLogin.setBounds(515, 377, 102, 53);
		contentPane.add(lblLogin);
		
		JLabel lblClear = new JLabel("Clear");
		lblClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblClear.setBackground(Color.BLACK);
				lblClear.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblClear.setBackground(new Color(255,215,0));
				lblClear.setForeground(Color.BLACK);
			}
		});
		lblClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClear.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblClear.setOpaque(true);
		lblClear.setHorizontalAlignment(SwingConstants.CENTER);
		lblClear.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblClear.setBackground(new Color(255, 215, 0));
		lblClear.setBounds(688, 377, 102, 53);
		contentPane.add(lblClear);
	}
}
