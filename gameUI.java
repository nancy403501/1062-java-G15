
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

public class gameUI extends JFrame implements ActionListener {
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
	JButton E201, me, door, screen, stair, wc, mirror, pswd, paper, gbbg;
	JButton search, move, open, upto;
	JTextArea text, bttext;
	JTextField subject, verb, object;
	JLabel plus, plus2;
	JOptionPane op;

	Mouse mouse = new Mouse();

	public gameUI() {

		JPanel southct = new JPanel();

		save = new ImageIcon(getClass().getResource("save.png"));
		savebt = new JButton(save);
		savebt.addMouseListener(mouse);
		savebt.addActionListener(this);
		savebt.setBounds(23, 470, 60, 60);
		southct.add(savebt);

		text = new JTextArea(3, 4);
		text.setBounds(160, 490, 400, 110);
		text.setEditable(false);
		text.setFont(new Font("細明體", Font.PLAIN, 25));
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

		E201 = button[cardNumber++];
		E201.setFont(new Font("細明體", Font.BOLD, 20));
		E201.setBackground(new Color(135, 206, 250));
		E201.addMouseListener(mouse);
		E201.addActionListener(this);
		anspanel.add(E201);
		anspanel.add(Box.createVerticalStrut(15));

		me = button[cardNumber++];
		me.setFont(new Font("細明體", Font.BOLD, 20));
		me.setBackground(new Color(135, 206, 250));
		me.addMouseListener(mouse);
		me.addActionListener(this);
		anspanel.add(me);
		anspanel.add(Box.createVerticalStrut(15));

		door = button[cardNumber++];
		door.setFont(new Font("細明體", Font.BOLD, 20));
		door.setBackground(new Color(135, 206, 250));
		door.addMouseListener(mouse);
		door.addActionListener(this);
		anspanel.add(door);
		anspanel.add(Box.createVerticalStrut(15));

		screen = button[cardNumber++];
		screen.setFont(new Font("細明體", Font.BOLD, 20));
		screen.setBackground(new Color(135, 206, 250));
		screen.addMouseListener(mouse);
		screen.addActionListener(this);
		anspanel.add(screen);
		anspanel.add(Box.createVerticalStrut(15));

		stair = button[cardNumber++];
		stair.setBackground(new Color(135, 206, 250));
		stair.setFont(new Font("細明體", Font.BOLD, 20));
		stair.addMouseListener(mouse);
		stair.addActionListener(this);
		anspanel.add(stair);
		anspanel.add(Box.createVerticalStrut(15));

		wc = button[cardNumber++];
		wc.setFont(new Font("細明體", Font.BOLD, 20));
		wc.setBackground(new Color(135, 206, 250));
		wc.addMouseListener(mouse);
		wc.addActionListener(this);
		anspanel.add(wc);
		anspanel.add(Box.createVerticalStrut(15));

		mirror = button[cardNumber++];
		mirror.setFont(new Font("細明體", Font.BOLD, 20));
		mirror.setBackground(new Color(135, 206, 250));
		mirror.addMouseListener(mouse);
		mirror.addActionListener(this);
		anspanel.add(mirror);
		anspanel.add(Box.createVerticalStrut(15));

		pswd = button[cardNumber++];
		pswd.setFont(new Font("細明體", Font.BOLD, 20));
		pswd.setBackground(new Color(135, 206, 250));
		pswd.addMouseListener(mouse);
		pswd.addActionListener(this);
		anspanel.add(pswd);
		anspanel.add(Box.createVerticalStrut(15));

		paper = button[cardNumber++];
		paper.setFont(new Font("細明體", Font.BOLD, 20));
		paper.setBackground(new Color(135, 206, 250));
		paper.addMouseListener(mouse);
		paper.addActionListener(this);
		anspanel.add(paper);
		anspanel.add(Box.createVerticalStrut(15));

		gbbg = button[cardNumber++];
		gbbg.setFont(new Font("細明體", Font.BOLD, 20));
		gbbg.setBackground(new Color(135, 206, 250));
		gbbg.addMouseListener(mouse);
		gbbg.addActionListener(this);
		anspanel.add(gbbg);
		anspanel.add(Box.createVerticalStrut(15));

		search = button[cardNumber++];
		search.setFont(new Font("細明體", Font.BOLD, 20));
		search.setBackground(new Color(240, 128, 128));
		search.addMouseListener(mouse);
		search.addActionListener(this);
		anspanel.add(search);
		anspanel.add(Box.createVerticalStrut(15));

		move = button[cardNumber++];
		move.setFont(new Font("細明體", Font.BOLD, 20));
		move.setBackground(new Color(240, 128, 128));
		move.addMouseListener(mouse);
		move.addActionListener(this);
		anspanel.add(move);
		anspanel.add(Box.createVerticalStrut(15));

		open = button[cardNumber++];
		open.setFont(new Font("細明體", Font.BOLD, 20));
		open.setBackground(new Color(240, 128, 128));
		open.addMouseListener(mouse);
		open.addActionListener(this);
		anspanel.add(open);
		anspanel.add(Box.createVerticalStrut(15));

		upto = button[cardNumber++];
		upto.setFont(new Font("細明體", Font.BOLD, 20));
		upto.setBackground(new Color(240, 128, 128));
		upto.addMouseListener(mouse);
		upto.addActionListener(this);
		anspanel.add(upto);
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
		} else {
			verb.setText(card[i]);
			express.getVerb(card[i]);
		}

		// 從資料庫中抓取描述句
		expression = express.getExpression();
		text.setText(expression);
	}

	class Mouse implements MouseListener, MouseMotionListener {

		@Override
		public void mousePressed(MouseEvent e) {
			x1 = e.getX();
			y1 = e.getY();
			// System.out.print("x1"+x1+"y1"+y1);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// motion

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO motion
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
	}

}
