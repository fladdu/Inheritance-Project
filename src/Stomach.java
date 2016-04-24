import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class Stomach extends Organ{

	//declaring vars
	private JButton eatButton = new JButton();
	private JButton digestButton = new JButton();
	private JLabel capLabel = new JLabel();
	private drawStomach rec = new drawStomach();
	private JButton infoButton = new JButton();
	private int w = 50 ,h = 50, x = 125, y = 40, delta = 0;
	private int capacity,digestSpeed = 1;

	/*	
	pre: parameters are defeined + >= 0
	post:
    */
	public Stomach(double weight, int capacity){
		
		//instance vars
		setWeight(weight);
		this.capacity = capacity;
		setBodySystem("Nom-ulatory System");
		setLocation("Inside Chest");
		setEssential(true);

		//timer!!!
		Timer eatAnim = new Timer(300, new ActionListener(){
				public void actionPerformed(ActionEvent e){
					doFunction();
					if (w <= 29){
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
		capLabel.setBounds(10,10,120,20);
		
		eatButton.setText("Eateth");
		eatButton.setBounds(115,200,75,20);
		
		infoButton.setText("Info");
		infoButton.setBounds(10,250,60,20);
		String contents = toString();
		infoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				JOptionPane.showMessageDialog(rec, contents);
			}
		});
		
		digestButton.setText("Digest");
		digestButton.setBounds(115, 230, 75, 20);
		digestButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(w>=50)
					digestSpeed++;
				else
					digestSpeed=1;
				delta = -2*digestSpeed;
			}
		});
		eatButton.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					if (w < capacity){
						int food = (int) (Math.random() * 5 + 1);
						w += food;
						h += food;
						x -= food / 2;
						y -= food / 2;
					}
				}
				public void mouseReleased (MouseEvent e){
					delta = -2*digestSpeed;
				}
		});
		
		//packing gui components
		GUI stomGUI = new GUI("Stomach");
		stomGUI.setSize(320, 320);
		stomGUI.setVisible(true);
		
		rec.draw();	
		rec.add(capLabel);
		rec.add(eatButton);
		rec.add(digestButton);
		rec.add(infoButton);
		Container c = stomGUI.getContentPane();
		c.add(rec);	
		stomGUI.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				main.GUI.setVisible(true);
			}
		});	
	}

	/*	
	pre: there is a Stomach object
	post: randomly (40% of the time) decreases the size of the stomach
    */
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
		
	}//dofunc
	@Override
	public String toString(){
		String info = "Name: Stomach" + "\nLocation: " + getLocation() + "\nBody System: " + getBodySystem() + 
				"\nEssential: " + getEssential() + "\nWeight: " + getWeight() + "\nCapacity: " + capacity;
		return info;
	}

	class drawStomach extends JPanel{

	/*	
	pre: nothing
	post: constructs a drawStomach object
    */
	public drawStomach(){
		setLayout(null);
	}

	/*	
	pre: there is a drawStomach object
	post: calls the repaint method
    */
	public void draw(){
		repaint();
	}

	/*	
	pre: there is a Stomach object
	post: paints the stomach
    */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(x, y, w, h);		
	}
}
}//class stom


