package test2;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class UI2 extends JFrame implements ActionListener{
	public UI2(){
		
		JButton clearbt = new JButton("Clear");
		clearbt.setFont(new Font("細明體",Font.BOLD,15));
		clearbt.setBounds(20, 650,80,50);
		add(clearbt);
			
		Icon save = new ImageIcon(getClass().getResource("save.png"));
		JButton savebt = new JButton(save);
//		setLayout(null);
		savebt.setBounds(20, 550,73,73);
		add(savebt);
		
		JTextArea text = new JTextArea(3,4);
		text.setBounds(180,550,600,160);
		text.setEditable(true);
		text.setFont(new Font("細明體",Font.PLAIN, 27));
		add(text);
		
		JPanel btpanel = new JPanel();
		
		
//		JTextArea bttext = new JTextArea(1,1);
//		bttext.setEditable(false);
//		bttext.setSize(140, 550);
//		btpanel.add(bttext);
		
		JPanel sc = new JPanel();
		sc.setLayout(new GridLayout(0, 1));
		JScrollPane scroll=new JScrollPane(btpanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setMaximumSize(new Dimension(220,200));
		
		JButton test = new JButton("E201");
		test.setFont(new Font("細明體",Font.BOLD,20));
//		mousetest mt = new mousetest();
//		test.addMouseListener(mt);
		
		btpanel.setLayout(new BoxLayout(btpanel, BoxLayout.Y_AXIS));
				
		JButton test2 = new JButton("E201");
		test2.setFont(new Font("細明體",Font.BOLD,20));
		
		JButton test3 = new JButton("E201");
		test3.setFont(new Font("細明體",Font.BOLD,20));
		
		JButton test4 = new JButton("E201");
		test4.setFont(new Font("細明體",Font.BOLD,20));

		JButton test5 = new JButton("E201");
		test5.setFont(new Font("細明體",Font.BOLD,20));

		JButton test6 = new JButton("E201");
		test6.setFont(new Font("細明體",Font.BOLD,20));
		
		JButton test7 = new JButton("E201");
		test7.setFont(new Font("細明體",Font.BOLD,20));
		
		JButton test8 = new JButton("E201");
		test8.setFont(new Font("細明體",Font.BOLD,20));
		
		btpanel.add(test);
		btpanel.add(Box.createVerticalStrut(8));
		btpanel.add(test2);
		btpanel.add(Box.createVerticalStrut(8));
		btpanel.add(test3);
		btpanel.add(Box.createVerticalStrut(8));
		btpanel.add(test4);
		btpanel.add(Box.createVerticalStrut(8));
		btpanel.add(test5);
		btpanel.add(Box.createVerticalStrut(8));
		btpanel.add(test6);
		btpanel.add(Box.createVerticalStrut(8));
		btpanel.add(test7);
		btpanel.add(Box.createVerticalStrut(8));
		btpanel.add(test8);
		
		sc.add(scroll);
	    add(sc,BorderLayout.EAST);
		
//		JScrollPane sp = new JScrollPane(btpanel);
//		sp.setLocation(830, 10);
//		add(sp);
		
//		JPanel btpanel = new JPanel();
//		btpanel.setVisible(true);
//		btpanel.setBounds(900, 0, 20, 100);
//	    add(btpanel);
	}
	
	class mousetest implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("e.getX:"+e.getX()+"e.getY:"+e.getY());
			//x1=e.getX()
			//y1=e.getY()
			//RECT class public void rect(){(x1,y1,x2,y2)}
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
