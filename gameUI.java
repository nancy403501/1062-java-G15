import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

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

public class gameUI extends JFrame implements ActionListener{
	
	int x1,x2,y1,y2;
	Icon save;
	JButton savebt,clear;
	JButton E201,me,screen,stair,search,move,open,upto;
	JButton wc,mirror,pswd,paper,gbbg;
	JTextArea text,bttext;
	JTextField subject,verb,object;
	JLabel plus,plus2;
	JOptionPane op;
	
	Mouse mouse = new Mouse();
	
	public gameUI() {

		JPanel southct = new JPanel();
		
		save = new ImageIcon(getClass().getResource("save.png"));
		savebt = new JButton(save);
		savebt.addMouseListener(mouse);
		savebt.addActionListener(this);
		savebt.setBounds(25, 450,60,60);
	    southct.add(savebt);
	    
	    clear = new JButton("clear");
	    clear.setBounds(20,550,74,35);
		clear.addMouseListener(mouse);
		clear.addActionListener(this);
	    clear.setFont(new Font("�ө���", Font.BOLD, 15));
	    southct.add(clear);
		  
		text = new JTextArea(3,4);
		text.setBounds(160,490, 400, 110);
		text.setEditable(true);
		text.setFont(new Font("�ө���", Font.PLAIN, 25));
		southct.add(text);
		
		subject = new JTextField();
		subject.setBounds(160, 430, 80, 40);
		subject.setFont(new Font("�ө���", Font.PLAIN, 25));
		southct.add(subject);
		
		plus = new JLabel("+");
		plus.setBounds(260,430,80,40);
		southct.add(plus);
		
		verb = new JTextField();
		verb.setBounds(290, 430, 80, 40);
		verb.setFont(new Font("�ө���", Font.PLAIN, 25));
		southct.add(verb);
		
		plus2 = new JLabel("+");
		plus2.setBounds(390,430,80,40);
		southct.add(plus2);
		
		object = new JTextField();
		object.setBounds(420, 430, 80, 40);
		object.setFont(new Font("�ө���", Font.PLAIN, 25));
		southct.add(object);
		southct.setLayout(null);
		add(southct);
		
		JPanel anspanel = new JPanel();
		
		JScrollPane scroll = new JScrollPane(anspanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(120,100));

		anspanel.setLayout(new BoxLayout(anspanel,BoxLayout.Y_AXIS));
		
		anspanel.add(Box.createVerticalStrut(13));
		E201= new JButton("E201");
		E201.setBounds(850,15,100,35);
		E201.setFont(new Font("�ө���", Font.BOLD, 20));
		E201.setBackground(new Color(135,206,250));
		E201.addMouseListener(mouse);
		E201.addActionListener(this);
		anspanel.add(E201);
		anspanel.add(Box.createVerticalStrut(15));
		
		me= new JButton("��");
		me.setBounds(850,15,100,35);
		me.setFont(new Font("�ө���", Font.BOLD, 20));
		me.setBackground(new Color(135,206,250));
		me.addMouseListener(mouse);
		me.addActionListener(this);
		anspanel.add(me);
		anspanel.add(Box.createVerticalStrut(15));
		
		screen= new JButton("�ù�");
		screen.setBounds(850,15,100,35);
		screen.setFont(new Font("�ө���", Font.BOLD, 20));
		screen.setBackground(new Color(135,206,250));
		screen.addMouseListener(mouse);
		screen.addActionListener(this);
		anspanel.add(screen);
		anspanel.add(Box.createVerticalStrut(15));
		
		stair= new JButton("�ӱ�");
		stair.setBounds(850,15,100,35);
		stair.setFont(new Font("�ө���", Font.BOLD, 20));
		stair.setBackground(new Color(135,206,250));
		stair.addMouseListener(mouse);
		stair.addActionListener(this);
		anspanel.add(stair);
		anspanel.add(Box.createVerticalStrut(15));
		
		search= new JButton("�d��");
		search.setBounds(850,15,100,35);
		search.setFont(new Font("�ө���", Font.BOLD, 20));
		search.setBackground(new Color(240,128,128));
		search.addMouseListener(mouse);
		search.addActionListener(this);
		anspanel.add(search);
		anspanel.add(Box.createVerticalStrut(15));
		
		move= new JButton("���ʨ�");
		move.setBounds(850,15,100,35);
		move.setFont(new Font("�ө���", Font.BOLD, 20));
		move.setBackground(new Color(240,128,128));
		move.addMouseListener(mouse);
		move.addActionListener(this);
		anspanel.add(move);
		anspanel.add(Box.createVerticalStrut(15));
		
		open= new JButton("�}��");
		open.setBounds(850,15,100,35);
		open.setFont(new Font("�ө���", Font.BOLD, 20));
		open.setBackground(new Color(240,128,128));
		open.addMouseListener(mouse);
		open.addActionListener(this);
		anspanel.add(open);
		anspanel.add(Box.createVerticalStrut(15));
		
		upto= new JButton("���W");
		upto.setBounds(850,15,100,35);
		upto.setFont(new Font("�ө���", Font.BOLD, 20));
		upto.setBackground(new Color(240,128,128));
		upto.addMouseListener(mouse);
		upto.addActionListener(this);
		anspanel.add(upto);
		anspanel.add(Box.createVerticalStrut(15));
		
		wc= new JButton("�Z��");
		wc.setBounds(850,15,100,35);
		wc.setFont(new Font("�ө���", Font.BOLD, 20));
		wc.setBackground(new Color(135,206,250));
		wc.addMouseListener(mouse);
		wc.addActionListener(this);
		anspanel.add(wc);
		anspanel.add(Box.createVerticalStrut(15));
		
		mirror= new JButton("��l");
		mirror.setBounds(850,15,100,35);
		mirror.setFont(new Font("�ө���", Font.BOLD, 20));
		mirror.setBackground(new Color(135,206,250));
		mirror.addMouseListener(mouse);
		mirror.addActionListener(this);
		anspanel.add(mirror);
		anspanel.add(Box.createVerticalStrut(15));
		
		paper= new JButton("�H��");
		paper.setBounds(850,15,100,35);
		paper.setFont(new Font("�ө���", Font.BOLD, 20));
		paper.setBackground(new Color(135,206,250));
		paper.addMouseListener(mouse);
		paper.addActionListener(this);
		anspanel.add(paper);
		anspanel.add(Box.createVerticalStrut(15));
		
		pswd= new JButton("�K�X");
		pswd.setBounds(850,15,100,35);
		pswd.setFont(new Font("�ө���", Font.BOLD, 20));
		pswd.setBackground(new Color(135,206,250));
		pswd.addMouseListener(mouse);
		pswd.addActionListener(this);
		anspanel.add(pswd);
		anspanel.add(Box.createVerticalStrut(15));
		
		gbbg= new JButton("�U���U");
		gbbg.setBounds(850,15,100,35);
		gbbg.setFont(new Font("�ө���", Font.BOLD, 20));
		gbbg.setBackground(new Color(135,206,250));
		gbbg.addMouseListener(mouse);
		gbbg.addActionListener(this);
		anspanel.add(gbbg);
		anspanel.add(Box.createVerticalStrut(15));
		
		add(scroll,BorderLayout.EAST);
		
	}
	//S,O:E201,me,screen,stair,wc,mirror,pswd,paper,gbbg
	//V:search,move,open,upto
	@Override
	public void actionPerformed(ActionEvent ate) {
		if(ate.getSource()==clear) {
			subject.setText(null);
			verb.setText(null);
			object.setText(null);
		}
		if(ate.getSource()==E201) {
			if(subject.getText().equals("")) {
				subject.setText("E201");
			}
			else{
				object.setText("E201");
			}
		}
		if(ate.getSource()==me) {
			if(subject.getText().equals("")) {
				subject.setText("��");
			}
			else{
				object.setText("��");
			}	
		}
		if(ate.getSource()==screen) {
			if(subject.getText().equals("")) {
				subject.setText("�ù�");
			}
			else{
				object.setText("�ù�");
			}
		}
		if(ate.getSource()==stair) {
			if(subject.getText().equals("")) {
				subject.setText("�ӱ�");
			}
			else{
				object.setText("�ӱ�");
			}
		}
		if(ate.getSource()==wc) {
			if(subject.getText().equals("")) {
				subject.setText("�Z��");
			}
			else{
				object.setText("�Z��");
			}	
		}
		if(ate.getSource()==mirror) {
			if(subject.getText().equals("")) {
				subject.setText("��l");
			}
			else{
				object.setText("��l");
			}
		}
		if(ate.getSource()==pswd) {
			if(subject.getText().equals("")) {
				subject.setText("�K�X");
			}
			else{
				object.setText("�K�X");
			}
		}
		if(ate.getSource()==paper) {
			if(subject.getText().equals("")) {
				subject.setText("�H��");
			}
			else{
				object.setText("�H��");
			}
		}
		if(ate.getSource()==gbbg) {
			if(subject.getText().equals("")) {
				subject.setText("�U���U");
			}
			else{
				object.setText("�U���U");
			}	
		}
		if(ate.getSource()==search) {
			verb.setText("�d��");
		}
		if(ate.getSource()==move) {
			verb.setText("���ʨ�");	
		}
		if(ate.getSource()==open) {
			verb.setText("�}��");	
		}
		if(ate.getSource()==upto) {
			verb.setText("���W");
		}
	}

	class Mouse implements MouseListener,MouseMotionListener{
		@Override
		public void mousePressed(MouseEvent e) {
			x1 = e.getX();
			y1 = e.getY();
			System.out.print("x1"+x1+"y1"+y1);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			// motion
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}	

		public void mouseMoved(MouseEvent arg0) {
//motion
		}

		public void mouseEntered(MouseEvent arg0) {
		}

		public void mouseExited(MouseEvent arg0) {	
		}
	}		
}