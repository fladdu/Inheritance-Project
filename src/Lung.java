import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
public class Lung extends Organ{
	JButton breathButton = new JButton();
	JLabel capLabel = new JLabel();
	drawLung rec = new drawLung();
	public static int w = 50 ,h = 50, x = 125, y = 40, delta = 0;
	int capacity;
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
		capLabel.setText("Capacity: " + /*(w / */capacity/* * 100)*/ + "%");
		capLabel.setBounds(10,10,70,20);
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
		
		//packing (correct term?) gui components
		GUI lungGUI = new GUI("Lung");
			lungGUI.setSize(320, 320);
			lungGUI.setVisible(true);
		
			rec.draw();	
			rec.add(capLabel);
			rec.add(breathButton);
		Container c = lungGUI.getContentPane();
			c.add(rec);	
	}

	@Override
	public void doFunction(){
		w += delta;
		h += delta;
		x -= delta / 2;
		y -= delta / 2;
		rec.draw();
		capLabel.setText("Capacity: " + /*(w / */capacity/* * 100)*/ + "%");
	}
}//class lung


class drawLung extends JPanel{
	public drawLung(){
		setLayout(null);
	}
	public void draw(){
		repaint();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(Lung.x, Lung.y, Lung.w, Lung.h);		
	}
}