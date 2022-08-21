package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Cursor;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	int xx,yy;
	JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 548);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setUndecorated(true);
		
		JLabel label_5 = new JLabel("-");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dashboard.this.setState(JFrame.ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label_5.setBackground(Color.BLACK);
				label_5.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_5.setBackground(new Color(255,215,0));
				label_5.setForeground(Color.BLACK);
			}
		});
		label_5.setBackground(new Color(255, 215, 0));
		label_5.setVerticalAlignment(SwingConstants.BOTTOM);
		label_5.setOpaque(true);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 29));
		label_5.setBounds(683, 0, 34, 35);
		contentPane.add(label_5);
		
		JLabel lblNewLabel_4 = new JLabel("x");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_4.setBackground(Color.RED);
				lblNewLabel_4.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_4.setBackground(new Color(255,215,0));
				lblNewLabel_4.setForeground(Color.BLACK);
			}
		});
		lblNewLabel_4.setBackground(new Color(255, 215, 0));
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 29));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(717, 0, 34, 35);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateRun run = new UpdateRun();
				run.setVisible(true);
				setVisible(false);
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/Image/istockphoto-936417008-2048x2048 (200 x 113).jpg")));
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(32, 159, 200, 113);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateBatting bat = new UpdateBatting();
				bat.setVisible(true);
				setVisible(false);
			}
		});
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setIcon(new ImageIcon(Dashboard.class.getResource("/Image/10-best-cricket-bats-1024x576 (200 x 113).jpg")));
		label.setOpaque(true);
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setBounds(266, 159, 200, 113);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateBowling bowl = new UpdateBowling();
				bowl.setVisible(true);
				setVisible(false);
			}
		});
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Image/cricket-istock-2-1127379-1658029979-1130804-1658977111 (200 x 113).jpg")));
		label_1.setOpaque(true);
		label_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		label_1.setBounds(498, 159, 200, 113);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateBattingInfo batinfo = new UpdateBattingInfo();
				batinfo.setVisible(true);
				setVisible(false);
			}
		});
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setIcon(new ImageIcon(Dashboard.class.getResource("/Image/ms-dhoni1-1599199338 (200 x 113).jpg")));
		label_2.setOpaque(true);
		label_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		label_2.setBounds(32, 348, 200, 113);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateBowlingInfo bowlinfo = new UpdateBowlingInfo();
				bowlinfo.setVisible(true);
				setVisible(false);
			}
		});
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.setIcon(new ImageIcon(Dashboard.class.getResource("/Image/Zampa-RCB-768x512 (200 x 113).jpg")));
		label_3.setOpaque(true);
		label_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		label_3.setBounds(266, 348, 200, 113);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateMatchInfo match = new UpdateMatchInfo();
				match.setVisible(true);
				setVisible(false);
			}
		});
		label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_4.setIcon(new ImageIcon(Dashboard.class.getResource("/Image/pan-1003-1632480317 (200 x 113).jpg")));
		label_4.setOpaque(true);
		label_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		label_4.setBounds(498, 348, 200, 113);
		contentPane.add(label_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Login login = new Login();
				login.setVisible(true);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
				lblNewLabel_5.setVisible(true);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setBorder(null);
				lblNewLabel_5.setVisible(false);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Image/icons8-logout-58.png")));
		lblNewLabel_1.setBounds(640, 63, 58, 58);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Update Run");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Corbel", Font.BOLD, 20));
		lblNewLabel_2.setBounds(55, 285, 148, 37);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblUpdateBatting = new JLabel("Update Batting");
		lblUpdateBatting.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateBatting.setFont(new Font("Corbel", Font.BOLD, 20));
		lblUpdateBatting.setBounds(289, 285, 148, 37);
		contentPane.add(lblUpdateBatting);
		
		JLabel lblUpdateBowling = new JLabel("Update Bowling");
		lblUpdateBowling.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateBowling.setFont(new Font("Corbel", Font.BOLD, 20));
		lblUpdateBowling.setBounds(521, 285, 148, 37);
		contentPane.add(lblUpdateBowling);
		
		JLabel lblUpdateBattingInfo = new JLabel("Update Batting Info");
		lblUpdateBattingInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateBattingInfo.setFont(new Font("Corbel", Font.BOLD, 20));
		lblUpdateBattingInfo.setBounds(32, 474, 200, 37);
		contentPane.add(lblUpdateBattingInfo);
		
		JLabel lblUpdateBowlingInfo = new JLabel("Update Bowling Info");
		lblUpdateBowlingInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateBowlingInfo.setFont(new Font("Corbel", Font.BOLD, 20));
		lblUpdateBowlingInfo.setBounds(266, 474, 200, 37);
		contentPane.add(lblUpdateBowlingInfo);
		
		JLabel lblUpdateMatchInfo = new JLabel("Update Match Info");
		lblUpdateMatchInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateMatchInfo.setFont(new Font("Corbel", Font.BOLD, 20));
		lblUpdateMatchInfo.setBounds(498, 474, 200, 37);
		contentPane.add(lblUpdateMatchInfo);
		
		JLabel lblNewLabel_3 = new JLabel(" Dashboard");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				yy = e.getY();
			}
		});
		lblNewLabel_3.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				Dashboard.this.setLocation(x - xx, y - yy);
			}
		});
		lblNewLabel_3.setFont(new Font("Consolas", Font.PLAIN, 19));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(255, 215, 0));
		lblNewLabel_3.setBounds(0, 0, 751, 35);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_5 = new JLabel("Log Out");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(565, 76, 63, 34);
		lblNewLabel_5.setVisible(false);
		contentPane.add(lblNewLabel_5);
	}
}
