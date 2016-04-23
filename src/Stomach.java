import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
public class Stomach extends Organ{
	JButton eatButton = new JButton();
	JLabel capLabel = new JLabel();
	drawStomach rec = new drawStomach();
	public static int w = 50 ,h = 50, x = 125, y = 40, delta = 0;
	int capacity;
	public Stomach(double weight, int capacity){
		//declaring instance vars
		setWeight(weight);
		this.capacity = capacity;
		setBodySystem("Nom-ulatory System");
		setLocation("Inside Chest");
		setEssential(true);

		//timer!!!
		Timer eatAnim = new Timer(300, new ActionListener(){
				public void actionPerformed(ActionEvent e){
					doFunction();
					if (w <= 50){
						w = 50;
						h = 50;
						x = 125;
						y = 40;
						delta = 0;
					}
				}
		});
		eatAnim.start();
		
		//setting up gui components
		capLabel.setText("Capacity: " + (((double)w / capacity) * 100) + "%");
		System.out.println(w + " " + capacity);
		capLabel.setBounds(10,10,120,20);
		eatButton.setText("Eateth");
		eatButton.setBounds(115,200,75,20);
		eatButton.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					if (w < capacity){
						int food = 10/*(int) (Math.random() * 5 + 1)*/;
						w += food;
						h += food;
						x -= food / 2;
						y -= food / 2;
					}
				}
				public void mouseReleased (MouseEvent e){
					delta = -2;
				}
		});
		
		//packing (correct term?) gui components
		GUI stomGUI = new GUI("Stomach");
			stomGUI.setSize(320, 320);
			stomGUI.setVisible(true);
		
			rec.draw();	
			rec.add(capLabel);
			rec.add(eatButton);
		Container c = stomGUI.getContentPane();
			c.add(rec);	
		stomGUI.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					main.GUI.setVisible(true);
				}
			});	
	}

	@Override
	public void doFunction(){
		if (Math.random() > .60){
			w += delta;
			h += delta;
			x -= delta / 2;
			y -= delta / 2;
		}
		capLabel.setText("Capacity: " + (((double)w / capacity) * 100) + "%");
		rec.draw();
		
	}
}//class stom


class drawStomach extends JPanel{
	public drawStomach(){
		setLayout(null);
	}
	public void draw(){
		repaint();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(Stomach.x, Stomach.y, Stomach.w, Stomach.h);		
	}
}