import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameMenu implements ActionListener{
	CardLayout cl;
	JButton Start,Quit;
	JPanel menu,game;
	JFrame f;
	GameUI ui;
	

	public void GameMenu() {	
		
		cl = new CardLayout();
		
		Start = new JButton("start");
		Quit = new JButton("quit");
		menu = new JPanel();
		game = new JPanel();
		
		//ui.setMaximumSize(new Dimension(800,650));
		
		menu.setLayout(null);
		Start.setBounds(340, 300, 100, 50);
		Quit.setBounds(340, 430, 100, 50);
		
		Start.addActionListener(this);
		Quit.addActionListener(this);
		
		menu.add(Start);
		menu.add(Quit);
		game.setLayout(cl);
		game.add(menu,"1");
		game.add(ui, "2");
		cl.show(game, "1");
		
		f = new JFrame("Escape");
		f.setSize(800, 650);
		f.setLocationRelativeTo(null);
		f.setVisible(true);

		f.add(game);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Start) {
			cl.show(game, "2");
			
		}
		if(e.getSource()==Quit) {
			System.exit(0);
		}
	}

}
