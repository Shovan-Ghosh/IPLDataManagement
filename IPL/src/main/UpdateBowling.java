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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateBowling extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblClear;
	private JLabel lblBack;
	private JLabel label;
	int xx,yy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateBowling frame = new UpdateBowling();
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
	public UpdateBowling() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 955, 596);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		label = new JLabel("-");
		label.setBackground(new Color(255, 215, 0));
		label.setOpaque(true);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateBowling.this.setState(JFrame.ICONIFIED);
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
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 29));
		label.setBounds(885, 0, 35, 35);
		contentPane.add(label);
		
		JLabel lblNewLabel_3 = new JLabel("x");
		lblNewLabel_3.setBackground(new Color(255, 215, 0));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_3.setBackground(Color.RED);
				lblNewLabel_3.setForeground(Color.WHITE);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_3.setBackground(new Color(255,215,0));
				lblNewLabel_3.setForeground(Color.BLACK);
			}
		});
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 29));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(920, 0, 35, 35);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel(" Update Bowling");
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				UpdateBowling.this.setLocation(x - xx, y - yy);
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
		lblNewLabel.setBackground(new Color(255, 215, 0));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 955, 35);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 35, 544, 561);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NO", "NAME", "OVER", "MAIDEN", "RUN", "WICKET", "ECONOMY"
			}
		) {
			Class[] columnTypes = new Class[] {
					Integer.class, Object.class, Object.class, Integer.class, Integer.class, Integer.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		retrive();
		table.setRowHeight(40);
		
		JLabel lblNewLabel_1 = new JLabel("NO : ");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_1.setBounds(574, 60, 56, 28);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Century Gothic", Font.BOLD, 16));
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField.setBounds(688, 60, 206, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblRun = new JLabel("Over :");
		lblRun.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblRun.setBounds(574, 135, 80, 28);
		contentPane.add(lblRun);
		
		JLabel lblBall = new JLabel("Maiden :");
		lblBall.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblBall.setBounds(574, 210, 91, 28);
		contentPane.add(lblBall);
		
		JLabel lbls = new JLabel("Run :");
		lbls.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbls.setBounds(574, 285, 80, 28);
		contentPane.add(lbls);
		
		JLabel lbls_1 = new JLabel("Wicket :");
		lbls_1.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbls_1.setBounds(574, 360, 80, 28);
		contentPane.add(lbls_1);
		
		JLabel lblSr = new JLabel("Economy :");
		lblSr.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblSr.setBounds(574, 435, 114, 28);
		contentPane.add(lblSr);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		textField_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_2.setColumns(10);
		textField_2.setBounds(688, 135, 206, 34);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Century Gothic", Font.BOLD, 16));
		textField_3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_3.setColumns(10);
		textField_3.setBounds(688, 210, 206, 34);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Century Gothic", Font.BOLD, 16));
		textField_4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_4.setColumns(10);
		textField_4.setBounds(688, 285, 206, 34);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Century Gothic", Font.BOLD, 16));
		textField_5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_5.setColumns(10);
		textField_5.setBounds(688, 360, 206, 34);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Century Gothic", Font.BOLD, 16));
		textField_6.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_6.setColumns(10);
		textField_6.setBounds(688, 435, 206, 34);
		contentPane.add(textField_6);
		
		JLabel lblNewLabel_2 = new JLabel("Set");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection con2 = DataBaseConnection.makeConnection();
					Statement st2 = con2.createStatement();
					st2.executeUpdate("update updatebowling set over = '"+textField_2.getText()+"', maiden = "+textField_3.getText()+", run = "+textField_4.getText()+
					", wicket = "+textField_5.getText()+", economy = '"+textField_6.getText()+"' where no = "+textField.getText());
					con2.close();
					st2.close();
				}
				catch (Exception ab) {
					JOptionPane.showMessageDialog(null, "Invalid entry !");
				}
				retrive();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setBackground(Color.BLACK);
				lblNewLabel_2.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setBackground(new Color(255,215,0));
				lblNewLabel_2.setForeground(Color.BLACK);
			}
		});
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(255, 215, 0));
		lblNewLabel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(574, 521, 80, 40);
		contentPane.add(lblNewLabel_2);
		
		lblClear = new JLabel("Clear");
		lblClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
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
		lblClear.setOpaque(true);
		lblClear.setHorizontalAlignment(SwingConstants.CENTER);
		lblClear.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblClear.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblClear.setBackground(new Color(255, 215, 0));
		lblClear.setBounds(694, 521, 80, 40);
		contentPane.add(lblClear);
		
		lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dashboard dash1 = new Dashboard();
				dash1.setVisible(true);
				setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBack.setBackground(Color.BLACK);
				lblBack.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBack.setBackground(new Color(255, 99, 71));
				lblBack.setForeground(Color.BLACK);
			}
		});
		lblBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBack.setOpaque(true);
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblBack.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblBack.setBackground(new Color(255, 99, 71));
		lblBack.setBounds(814, 521, 80, 40);
		contentPane.add(lblBack);
		setUndecorated(true);
	}
	public void retrive() {
		DefaultTableModel table = new DefaultTableModel();
		
		table.addColumn("NO");
		table.addColumn("NAME");
		table.addColumn("OVER");
		table.addColumn("MAIDEN");
		table.addColumn("RUN");
		table.addColumn("WICKET");
		table.addColumn("ECONOMY");
		try{
			Connection conn = DataBaseConnection.makeConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from updatebowling order by no");
			while(rs.next()) {
				table.addRow(new Object[] {
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getString(7),
				});
			}	
			this.table.setModel(table);
			conn.close();
			st.close();
			rs.close();
		}
		catch (Exception ee) {
			ee.printStackTrace();
		}
	}

}
