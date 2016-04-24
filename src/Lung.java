import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class Lung extends Organ{
	JButton breathButton = new JButton();
	JLabel capLabel = new JLabel();
	drawLung rec = new drawLung();
	JButton infoButton = new JButton();
	public static int w = 50 ,h = 50, x = 125, y = 40, delta = 0;//ENCAPSULATION
	int capacity;

	/*	
	pre: parameters are defined + non-zero
	post: constructs a Lung object
    */
	public Lung(double weight, int capacity){
		//declaring instance vars
		setWeight(weight);
		this.capacity = capacity;
		setBodySystem("Breath-ulatory System");
		setLocation("Inside Chest");
		setEssential(true);

		//timer!!!
		Timer breathAnim = new Timer(50, new ActionListener(){
				public void actionPerformed(ActionEvent e){
					doFunction();
					if (w <= 50){
						w = 50;
						h = 50;
						x = 125;
						y = 40;
						delta = 0;
					} else if (w == capacity || w == capacity - 1){
						delta = 0;
					}
				}
		});
		breathAnim.start();
		
		//setting up gui components
		capLabel.setText("Capacity: " + (((double)w / capacity) * 100) + "%");
		capLabel.setBounds(10,10,120,20);
		
		breathButton.setText("Breath");
		breathButton.setBounds(115,200,75,20);
		breathButton.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					delta = 2;
				}
				public void mouseReleased (MouseEvent e){
					delta = -2;
				}
		});
		
		infoButton.setText("Info");
		infoButton.setBounds(10,250,60,20);
		String contents = toString();
		infoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				JOptionPane.showMessageDialog(rec, contents);
			}
		});
		//packing gui components
		GUI lungGUI = new GUI("Lung");
		lungGUI.setSize(320, 320);
		lungGUI.setVisible(true);
		
		rec.draw();	
		rec.add(capLabel);
		rec.add(breathButton);
		rec.add(infoButton);
		Container c = lungGUI.getContentPane();
		c.add(rec);	

		lungGUI.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				main.GUI.setVisible(true);
			}
		});	
	}

	/*	
	pre: there is a Lung object, delta is defined
	post: changes the size of the lung by 'delta'
    */
	@Override
	public void doFunction(){
		w += delta;
		h += delta;
		x -= delta / 2;
		y -= delta / 2;
		rec.draw();
		capLabel.setText("Capacity: " + (((double)w / capacity) * 100) + "%");
	}//dofunc
	@Override
	public String toString(){
		String info = "Name: Lung" + "\nLocation: " + getLocation() + "\nBody System: " + getBodySystem() + 
				"\nEssential: " + getEssential() + "\nWeight: " + getWeight() + "\nCapacity: " + capacity;
		return info;
	}
}//class lung


class drawLung extends JPanel{

	/*	
	pre: nothing
	post: constructs a drawLung objct
    */
	public drawLung(){
		setLayout(null);
	}

	/*	
	pre: there is a drawLung object
	post: calls the repaint method
    */
	public void draw(){
		repaint();
	}

	/*	
	pre: there is a drawLung object
	post: paints the lung
    */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(Lung.x, Lung.y, Lung.w, Lung.h);		
	}
}