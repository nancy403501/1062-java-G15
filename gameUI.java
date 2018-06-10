

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;




public class GameUI extends JPanel implements ActionListener {
	int MaxCardNumber = 100;
	String[] card = new String[MaxCardNumber];
	// {null, null, null, null, null, null, null, null, null, null, null, null,
	// null, null};
	String[] cardType = new String[MaxCardNumber];
	String[] buttonName = new String[MaxCardNumber];
	int cardNumber = 0;

	int x1, x2, y1, y2;
	Icon save;
	JButton savebt, clear;
	JButton[] button = new JButton[MaxCardNumber];
	JButton E201, me, door, bigdoor,screen, stair, wc, mirror, pswd, paper, gbbg;
	JButton search, move, open, upto;
	JTextArea text, bttext;
	JTextField subject, verb, object;
	JLabel plus, plus2;
	JOptionPane op;
	
	public GameUI() {
		
		this.setLayout(new BorderLayout());
		JPanel southct = new JPanel();

		text = new JTextArea(3, 4);
		text.setBounds(160, 490, 400, 110);
		text.setEditable(false);
		text.setFont(new Font("細明體", Font.PLAIN, 25));
		text.setText("「我」醒來時，發現教室誰都不在了...我急忙「查看」，這裡應該是上一節課「移動到」的「E201」教室");
		text.setLineWrap(true);
		southct.add(text);

		subject = new JTextField();
		subject.setBounds(160, 430, 80, 40);
		subject.setEditable(false);
		subject.setFont(new Font("細明體", Font.PLAIN, 25));
		southct.add(subject);

		plus = new JLabel("+");
		plus.setBounds(260, 430, 80, 40);
		southct.add(plus);

		verb = new JTextField();
		verb.setBounds(290, 430, 80, 40);
		verb.setEditable(false);
		verb.setFont(new Font("細明體", Font.PLAIN, 25));
		southct.add(verb);

		plus2 = new JLabel("+");
		plus2.setBounds(390, 430, 80, 40);
		southct.add(plus2);

		object = new JTextField();
		object.setBounds(420, 430, 80, 40);
		object.setEditable(false);
		object.setFont(new Font("細明體", Font.PLAIN, 25));
		southct.add(object);
		southct.setLayout(null);
		add(southct);

		JPanel anspanel = new JPanel();

		JScrollPane scroll = new JScrollPane(anspanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(120, 100));

		anspanel.setLayout(new BoxLayout(anspanel, BoxLayout.Y_AXIS));

		// 從資料庫中抓取字卡
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			// handle the error
		}

		Connection conn = null;  
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test?"
					+ "user=root&password=yosafire520&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select c.cardnum, card, type, buttonName" + " from cards c");

			while (rs.next()) {
				card[cardNumber] = rs.getString(2);
				cardType[cardNumber] = rs.getString(3);
				buttonName[cardNumber] = rs.getString(4);
				cardNumber++;
				// System.out.println(
				// rs.getInt(1) + "\t" + rs.getString(2) + "\t");
			}

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		cardNumber = 0;
		anspanel.add(Box.createVerticalStrut(13));
		for (int i = 0; i < MaxCardNumber; i++) {
			button[i] = new JButton(card[i]);
		}		
		
////////預設
		me = button[cardNumber++];
		me.setFont(new Font("細明體", Font.BOLD, 20));
		me.setBackground(new Color(135, 206, 250));
		me.addActionListener(this);
		anspanel.add(me);
		anspanel.add(Box.createVerticalStrut(15));
		
		search = button[cardNumber++];
		search.setFont(new Font("細明體", Font.BOLD, 20));
		search.setBackground(new Color(240, 128, 128));
		search.addActionListener(this);
		anspanel.add(search);
		anspanel.add(Box.createVerticalStrut(15));

		move = button[cardNumber++];
		move.setFont(new Font("細明體", Font.BOLD, 20));
		move.setBackground(new Color(240, 128, 128));
		move.addActionListener(this);
		anspanel.add(move);
		anspanel.add(Box.createVerticalStrut(15));

		E201 = button[cardNumber++];
		E201.setFont(new Font("細明體", Font.BOLD, 20));
		E201.setBackground(new Color(135, 206, 250));
		E201.addActionListener(this);
		anspanel.add(E201);
		E201.setEnabled(true);
		E201.setVisible(true);
		anspanel.add(Box.createVerticalStrut(15));
////////預設
		
		door = button[cardNumber++];
		door.setFont(new Font("細明體", Font.BOLD, 20));
		door.setBackground(new Color(135, 206, 250));
		door.addActionListener(this);
		anspanel.add(door);
		door.setEnabled(false);
		door.setVisible(false);
		anspanel.add(Box.createVerticalStrut(15));
		

		screen = button[cardNumber++];
		screen.setFont(new Font("細明體", Font.BOLD, 20));
		screen.setBackground(new Color(135, 206, 250));
		screen.addActionListener(this);
		anspanel.add(screen);
		screen.setEnabled(false);
		screen.setVisible(false);
		anspanel.add(Box.createVerticalStrut(15));
		
		open = button[cardNumber++];
		open.setFont(new Font("細明體", Font.BOLD, 20));
		open.setBackground(new Color(240, 128, 128));
		open.addActionListener(this);
		anspanel.add(open);
		open.setEnabled(false);
		open.setVisible(false);
		anspanel.add(Box.createVerticalStrut(15));

		stair = button[cardNumber++];
		stair.setBackground(new Color(135, 206, 250));
		stair.setFont(new Font("細明體", Font.BOLD, 20));
		stair.addActionListener(this);
		anspanel.add(stair);
		stair.setEnabled(false);
		stair.setVisible(false);
		anspanel.add(Box.createVerticalStrut(15));
		
		bigdoor = button[cardNumber++];
		bigdoor.setFont(new Font("細明體", Font.BOLD, 20));
		bigdoor.setBackground(new Color(135, 206, 250));
		bigdoor.addActionListener(this);
		anspanel.add(bigdoor);
		bigdoor.setEnabled(false);
		bigdoor.setVisible(false);
		anspanel.add(Box.createVerticalStrut(15));

		wc = button[cardNumber++];
		wc.setFont(new Font("細明體", Font.BOLD, 20));
		wc.setBackground(new Color(135, 206, 250));
		wc.addActionListener(this);
		anspanel.add(wc);
		wc.setEnabled(false);
		wc.setVisible(false);
		anspanel.add(Box.createVerticalStrut(15));

		mirror = button[cardNumber++];
		mirror.setFont(new Font("細明體", Font.BOLD, 20));
		mirror.setBackground(new Color(135, 206, 250));
		mirror.addActionListener(this);
		anspanel.add(mirror);
		mirror.setEnabled(false);
		mirror.setVisible(false);
		anspanel.add(Box.createVerticalStrut(15));
		
		gbbg = button[cardNumber++];
		gbbg.setFont(new Font("細明體", Font.BOLD, 20));
		gbbg.setBackground(new Color(135, 206, 250));
		gbbg.addActionListener(this);
		anspanel.add(gbbg);
		gbbg.setEnabled(false);
		gbbg.setVisible(false);
		anspanel.add(Box.createVerticalStrut(15));
		
		paper = button[cardNumber++];
		paper.setFont(new Font("細明體", Font.BOLD, 20));
		paper.setBackground(new Color(135, 206, 250));
		paper.addActionListener(this);
		anspanel.add(paper);
		paper.setEnabled(false);
		paper.setVisible(false);
		anspanel.add(Box.createVerticalStrut(15));

		pswd = button[cardNumber++];
		pswd.setFont(new Font("細明體", Font.BOLD, 20));
		pswd.setBackground(new Color(135, 206, 250));
		pswd.addActionListener(this);
		anspanel.add(pswd);
		pswd.setEnabled(false);
		pswd.setVisible(false);
		anspanel.add(Box.createVerticalStrut(15));

		add(scroll, BorderLayout.EAST);

	}

	CatchExpressionDemo express = new CatchExpressionDemo();
	String expression = null;
	private boolean isSubjectEmpty = true, isObjectEmpty = true;

	@Override
	public void actionPerformed(ActionEvent ate) {
		int i;
		String tmpCardType = null;

		for (i = 0; i < cardNumber; i++) {
			if (ate.getSource() == button[i]) {
				tmpCardType = cardType[i];
				break;
			}
		}
		if (tmpCardType.equals("SubjectObject")) {
			// if (tmpCardType == cardType[i]) {
			if (isSubjectEmpty == true) {
				subject.setText(card[i]);
				isSubjectEmpty = false;
			} else if (isObjectEmpty == true) {
				object.setText(card[i]);
				isObjectEmpty = false;
			} else {
				subject.setText(card[i]);
				verb.setText(null);
				object.setText(null);
				isSubjectEmpty = false;
				isObjectEmpty = true;
			}			
		express.getSubOrOb(card[i]);
		}
		else {
			verb.setText(card[i]);
 			express.getVerb(card[i]);
		}	
		
		int storyLine = 0;
		
		// 從資料庫中抓取描述句
		expression = express.getExpression();
		storyLine = express.getStoryLineNum();
		text.setText(expression);
		text.setLineWrap(true);

		switch(storyLine) {
			case 1: 
				door.setVisible(true);
				door.setEnabled(true);
				screen.setVisible(true);
				screen.setEnabled(true);
				break;
			case 2:
				open.setVisible(true);
				open.setEnabled(true);
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				stair.setVisible(true);
				stair.setEnabled(true);
				
				E201.setEnabled(false);
				E201.setVisible(false);
				door.setVisible(false);
				door.setEnabled(false);
				screen.setVisible(false);
				screen.setEnabled(false);
				break;
			case 6:
				bigdoor.setVisible(true);
				bigdoor.setEnabled(true);
				break;
			case 7:
				open.setVisible(true);
				open.setEnabled(true);
				wc.setVisible(true);
				wc.setEnabled(true);
				
				stair.setVisible(false);
				stair.setEnabled(false);
				mirror.setVisible(false);
				mirror.setEnabled(false);
				gbbg.setVisible(false);
				gbbg.setEnabled(false);
				paper.setVisible(false);
				paper.setEnabled(false);
				break;
			case 8:
				open.setVisible(false);
				open.setEnabled(false);
				break;
			case 9:
				mirror.setVisible(true);
				mirror.setEnabled(true);
				gbbg.setVisible(true);
				gbbg.setEnabled(true);
				
				open.setVisible(false);
				open.setEnabled(false);
				break;
			case 10:
				paper.setVisible(true);
				paper.setEnabled(true);
				break;
			case 11:
				break;
			case 12:
				bigdoor.setVisible(true);
				bigdoor.setEnabled(true);
				pswd.setVisible(true);
				pswd.setEnabled(true);
				break;
			case 13:
				stair.setVisible(false);
				stair.setEnabled(false);
				mirror.setVisible(false);
				mirror.setEnabled(false);
				gbbg.setVisible(false);
				gbbg.setEnabled(false);
				paper.setVisible(false);
				paper.setEnabled(false);
				break;
			case 14:
				stair.setVisible(false);
				stair.setEnabled(false);
				break;
			case 15:
				stair.setVisible(false);
				stair.setEnabled(false);
				mirror.setVisible(false);
				mirror.setEnabled(false);
				gbbg.setVisible(false);
				gbbg.setEnabled(false);
				break;
			default:
				break;
			
		}
		

/*
		if(subject.getText().equals("我")&&verb.getText().equals("查看")&&object.getText().equals("E201")) {
			door.setVisible(true);
			door.setEnabled(true);
			screen.setVisible(true);
			screen.setEnabled(true);
		}
		if(subject.getText().equals("我")&&verb.getText().equals("查看")&&object.getText().equals("門")) {
			open.setVisible(true);
			open.setEnabled(true);
		}
		if(subject.getText().equals("E201")&&verb.getText().equals("開啟")&&object.getText().equals("門")) {
			stair.setVisible(true);
			stair.setEnabled(true);
		}
		if(subject.getText().equals("我")&&verb.getText().equals("移動到")&&object.getText().equals("樓梯")) {
			bigdoor.setVisible(true);
			bigdoor.setEnabled(true);
		}
		if(subject.getText().equals("我")&&verb.getText().equals("查看")&&object.getText().equals("大門")) {
			wc.setVisible(true);
			wc.setEnabled(true);
		}
		if(subject.getText().equals("我")&&verb.getText().equals("查看")&&object.getText().equals("廁所")) {
			mirror.setVisible(true);
			mirror.setEnabled(true);
			gbbg.setVisible(true);
			gbbg.setEnabled(true);
		}
		if(subject.getText().equals("我")&&verb.getText().equals("查看")&&object.getText().equals("垃圾袋")) {
			paper.setVisible(true);
			paper.setEnabled(true);
		}
		if(subject.getText().equals("碎紙")&&verb.getText().equals("移動到")&&object.getText().equals("鏡子")) {
			pswd.setVisible(true);
			pswd.setEnabled(true);
		}
*/		
		
	}
}
