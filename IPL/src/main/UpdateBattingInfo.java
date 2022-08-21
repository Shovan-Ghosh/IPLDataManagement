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

public class UpdateBattingInfo extends JFrame {

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
	private JTextField textField_1;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateBattingInfo frame = new UpdateBattingInfo();
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
	public UpdateBattingInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1032, 722);
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
				UpdateBattingInfo.this.setState(JFrame.ICONIFIED);
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
		label.setBounds(962, 0, 35, 35);
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
		lblNewLabel_3.setBounds(997, 0, 35, 35);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel(" Update Batting Information");
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				UpdateBattingInfo.this.setLocation(x - xx, y - yy);
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
		lblNewLabel.setBounds(0, 0, 1032, 35);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 35, 621, 687);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NAME", "MATCH", "RUNS", "AVGs", "HS", "100s", "50s"
			}
		) {
			Class[] columnTypes = new Class[] {
					Integer.class, Object.class, Integer.class, Integer.class, Object.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		retrive();
		table.setRowHeight(40);
		
		JLabel lblNewLabel_1 = new JLabel("ID :");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_1.setBounds(660, 60, 56, 28);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Century Gothic", Font.BOLD, 16));
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField.setBounds(780, 60, 206, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblRun = new JLabel("Name :");
		lblRun.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblRun.setBounds(660, 120, 80, 28);
		contentPane.add(lblRun);
		
		JLabel lblBall = new JLabel("Match :");
		lblBall.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblBall.setBounds(660, 180, 91, 28);
		contentPane.add(lblBall);
		
		JLabel lbls = new JLabel("Run :");
		lbls.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbls.setBounds(660, 240, 80, 28);
		contentPane.add(lbls);
		
		JLabel lbls_1 = new JLabel("Avgs :");
		lbls_1.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbls_1.setBounds(660, 300, 80, 28);
		contentPane.add(lbls_1);
		
		JLabel lblSr = new JLabel("HS :");
		lblSr.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblSr.setBounds(660, 360, 114, 28);
		contentPane.add(lblSr);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		textField_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_2.setColumns(10);
		textField_2.setBounds(780, 120, 206, 34);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Century Gothic", Font.BOLD, 16));
		textField_3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_3.setColumns(10);
		textField_3.setBounds(780, 180, 206, 34);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Century Gothic", Font.BOLD, 16));
		textField_4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_4.setColumns(10);
		textField_4.setBounds(780, 240, 206, 34);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Century Gothic", Font.BOLD, 16));
		textField_5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_5.setColumns(10);
		textField_5.setBounds(780, 300, 206, 34);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Century Gothic", Font.BOLD, 16));
		textField_6.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_6.setColumns(10);
		textField_6.setBounds(780, 360, 206, 34);
		contentPane.add(textField_6);
		
		JLabel lblNewLabel_2 = new JLabel("Update");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection con2 = DataBaseConnection.makeConnection();
					Statement st2 = con2.createStatement();
					st2.executeUpdate("update battinginfo set NAME = '"+textField_2.getText()+"', MATCH = "+textField_3.getText()+", RUNS = "+textField_4.getText()+
					", AVGS = '"+textField_5.getText()+"', HS = "+textField_6.getText()+", CENTURY = "+textField_1.getText()+", HALF_CENTURY = "+textField_7.getText()+" where ID = "+textField.getText());
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
		lblNewLabel_2.setBounds(775, 550, 100, 40);
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
				textField_1.setText("");
				textField_7.setText("");
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
		lblClear.setBounds(710, 630, 100, 40);
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
		lblBack.setBounds(842, 630, 100, 40);
		contentPane.add(lblBack);
		
		JLabel lbls_2 = new JLabel("100s :");
		lbls_2.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbls_2.setBounds(660, 420, 114, 28);
		contentPane.add(lbls_2);
		
		JLabel lbls_3 = new JLabel("50s :");
		lbls_3.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbls_3.setBounds(660, 480, 114, 28);
		contentPane.add(lbls_3);
		
		JLabel lblSave = new JLabel("Save");
		lblSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection con3 = DataBaseConnection.makeConnection();
					Statement st3 = con3.createStatement();
					st3.executeUpdate("insert into battinginfo values ("+textField.getText()+",'"+textField_2.getText()+"',"+textField_3.getText()
					+","+textField_4.getText()+",'"+textField_5.getText()+"',"+textField_6.getText()+","+textField_1.getText()+","+textField_7.getText()+")");
					con3.close();
					st3.close();
				}
				catch (Exception ab) {
					JOptionPane.showMessageDialog(null, "Invalid entry !");
				}
				retrive();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSave.setBackground(Color.BLACK);
				lblSave.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSave.setBackground(new Color(255,215,0));
				lblSave.setForeground(Color.BLACK);
			}
		});
		lblSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSave.setOpaque(true);
		lblSave.setHorizontalAlignment(SwingConstants.CENTER);
		lblSave.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblSave.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblSave.setBackground(new Color(255, 215, 0));
		lblSave.setBounds(660, 550, 100, 40);
		contentPane.add(lblSave);
		
		JLabel lblDelete = new JLabel("Delete");
		lblDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection con4 = DataBaseConnection.makeConnection();
					Statement st4 = con4.createStatement();
					st4.executeUpdate("delete from battinginfo where ID = "+textField.getText());
					con4.close();
					st4.close();
				}
				catch (Exception ab) {
					JOptionPane.showMessageDialog(null, "Invalid entry !");
				}
				retrive();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDelete.setBackground(Color.BLACK);
				lblDelete.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblDelete.setBackground(new Color(255,215,0));
				lblDelete.setForeground(Color.BLACK);
			}
		});
		lblDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDelete.setOpaque(true);
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblDelete.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblDelete.setBackground(new Color(255, 215, 0));
		lblDelete.setBounds(890, 550, 100, 40);
		contentPane.add(lblDelete);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_1.setBounds(780, 420, 206, 34);
		contentPane.add(textField_1);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Century Gothic", Font.BOLD, 16));
		textField_7.setColumns(10);
		textField_7.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField_7.setBounds(780, 480, 206, 34);
		contentPane.add(textField_7);
		setUndecorated(true);
	}
	public void retrive() {
		DefaultTableModel table = new DefaultTableModel();
		
		table.addColumn("ID");
		table.addColumn("NAME");
		table.addColumn("MATCH");
		table.addColumn("RUNS");
		table.addColumn("AVGs");
		table.addColumn("HS");
		table.addColumn("100s");
		table.addColumn("50s");
		try{
			Connection conn = DataBaseConnection.makeConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from battinginfo order by id");
			while(rs.next()) {
				table.addRow(new Object[] {
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8),
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
