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
	
	Mouse mouse = new Mouse();
	
	public gameUI() {

		JPanel southct = new JPanel();
		
		save = new ImageIcon(getClass().getResource("save.png"));
		savebt = new JButton(save);
		savebt.setBounds(23, 450,60,60);
	    southct.add(savebt);
	    
	    clear = new JButton("clear");
	    clear.setBounds(20,550,70,35);
	    clear.setFont(new Font("細明體", Font.PLAIN, 15));
	    southct.add(clear);
		  
		text = new JTextArea(3,4);
		text.setBounds(160,490, 400, 110);
		text.setEditable(true);
		text.setFont(new Font("細明體", Font.PLAIN, 25));
		southct.add(text);
		
		subject = new JTextField();
		subject.setBounds(160, 430, 80, 40);
		subject.setFont(new Font("細明體", Font.PLAIN, 25));
		southct.add(subject);
		
		plus = new JLabel("+");
		plus.setBounds(260,430,80,40);
		southct.add(plus);
		
		verb = new JTextField();
		verb.setBounds(290, 430, 80, 40);
		verb.setFont(new Font("細明體", Font.PLAIN, 25));
		southct.add(verb);
		
		plus2 = new JLabel("+");
		plus2.setBounds(390,430,80,40);
		southct.add(plus2);
		
		object = new JTextField();
		object.setBounds(420, 430, 80, 40);
		object.setFont(new Font("細明體", Font.PLAIN, 25));
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
		E201.setFont(new Font("細明體", Font.BOLD, 20));
		E201.addMouseListener(mouse);
		E201.addActionListener(this);
		anspanel.add(E201);
		anspanel.add(Box.createVerticalStrut(15));
		
		me= new JButton("我");
		me.setBounds(850,15,100,35);
		me.setFont(new Font("細明體", Font.BOLD, 20));
		me.addMouseListener(mouse);
		me.addActionListener(this);
		anspanel.add(me);
		anspanel.add(Box.createVerticalStrut(15));
		
		screen= new JButton("螢幕");
		screen.setBounds(850,15,100,35);
		screen.setFont(new Font("細明體", Font.BOLD, 20));
		screen.addMouseListener(mouse);
		screen.addActionListener(this);
		anspanel.add(screen);
		anspanel.add(Box.createVerticalStrut(15));
		
		stair= new JButton("樓梯");
		stair.setBounds(850,15,100,35);
		stair.setFont(new Font("細明體", Font.BOLD, 20));
		stair.addMouseListener(mouse);
		stair.addActionListener(this);
		anspanel.add(stair);
		anspanel.add(Box.createVerticalStrut(15));
		
		search= new JButton("查看");
		search.setBounds(850,15,100,35);
		search.setFont(new Font("細明體", Font.BOLD, 20));
		search.addMouseListener(mouse);
		search.addActionListener(this);
		anspanel.add(search);
		anspanel.add(Box.createVerticalStrut(15));
		
		move= new JButton("移動到");
		move.setBounds(850,15,100,35);
		move.setFont(new Font("細明體", Font.BOLD, 20));
		move.addMouseListener(mouse);
		move.addActionListener(this);
		anspanel.add(move);
		anspanel.add(Box.createVerticalStrut(15));
		
		open= new JButton("開啟");
		open.setBounds(850,15,100,35);
		open.setFont(new Font("細明體", Font.BOLD, 20));
		open.addMouseListener(mouse);
		open.addActionListener(this);
		anspanel.add(open);
		anspanel.add(Box.createVerticalStrut(15));
		
		upto= new JButton("走上");
		upto.setBounds(850,15,100,35);
		upto.setFont(new Font("細明體", Font.BOLD, 20));
		upto.addMouseListener(mouse);
		upto.addActionListener(this);
		anspanel.add(upto);
		anspanel.add(Box.createVerticalStrut(15));
		
		wc= new JButton("廁所");
		wc.setBounds(850,15,100,35);
		wc.setFont(new Font("細明體", Font.BOLD, 20));
		wc.addMouseListener(mouse);
		wc.addActionListener(this);
		anspanel.add(wc);
		anspanel.add(Box.createVerticalStrut(15));
		
		mirror= new JButton("鏡子");
		mirror.setBounds(850,15,100,35);
		mirror.setFont(new Font("細明體", Font.BOLD, 20));
		mirror.addMouseListener(mouse);
		mirror.addActionListener(this);
		anspanel.add(mirror);
		anspanel.add(Box.createVerticalStrut(15));
		
		paper= new JButton("碎紙");
		paper.setBounds(850,15,100,35);
		paper.setFont(new Font("細明體", Font.BOLD, 20));
		paper.addMouseListener(mouse);
		paper.addActionListener(this);
		anspanel.add(paper);
		anspanel.add(Box.createVerticalStrut(15));
		
		pswd= new JButton("密碼");
		pswd.setBounds(850,15,100,35);
		pswd.setFont(new Font("細明體", Font.BOLD, 20));
		pswd.addMouseListener(mouse);
		pswd.addActionListener(this);
		anspanel.add(pswd);
		anspanel.add(Box.createVerticalStrut(15));
		
		gbbg= new JButton("垃圾袋");
		gbbg.setBounds(850,15,100,35);
		gbbg.setFont(new Font("細明體", Font.BOLD, 20));
		gbbg.setBackground(Color.YELLOW);
		gbbg.addMouseListener(mouse);
		gbbg.addActionListener(this);
		anspanel.add(gbbg);
		anspanel.add(Box.createVerticalStrut(15));
		
		add(scroll,BorderLayout.EAST);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ate) {
		
			if(ate.getSource()==E201) {
				subject.setText("E201");	
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
