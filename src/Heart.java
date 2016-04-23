import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class Heart extends Organ implements ChangeListener{
	JButton pumpButton = new JButton();
	JLabel BPMLabel = new JLabel();
	draw rec = new draw();
	JSlider weightSlider = new JSlider(JSlider.HORIZONTAL, 0, 1000,450);
	public static int w = 50 ,h = 50, x = 125, y = 30;
	double BPM = 0;
	public Heart(double weight){
		setWeight(weight);
		setBodySystem("Circulatory System");
		setLocation("Inside Chest");
		setEssential(true);
		
		weightSlider.setBounds(50, 150, 200,50);
		weightSlider.setMajorTickSpacing(250);
	    weightSlider.setMinorTickSpacing(50);
	    weightSlider.setPaintTicks(true);
	    weightSlider.setPaintLabels(true);
	    weightSlider.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
	    weightSlider.addChangeListener(this);
	    weightSlider.setValue((int)getWeight());
		BPMLabel.setText("BPM: " + Double.toString(BPM));
		BPMLabel.setBounds(10,10,70,20);
		pumpButton.setText("Pump");
		pumpButton.setBounds(115,200,75,20);
		pumpButton.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					doFunction();
					int count = e.getClickCount();
					System.out.println(count);
				}
				public void mouseReleased (MouseEvent e){
					w = (int)getWeight()/5;
					h = w;
					x = 125 - (w - 50)/2;
					y = 30 - (w - 50)/2;
					rec.draw();
				}
		});
		
		GUI heartGUI = new GUI("Heart");
			heartGUI.setSize(320, 320);
			heartGUI.setVisible(true);
		
			rec.draw();	
			rec.add(BPMLabel);
			rec.add(pumpButton);
			rec.add(weightSlider);
		Container c = heartGUI.getContentPane();
			c.add(rec);
			//c.add(heartIMG);
		heartGUI.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				main.GUI.setVisible(true);
			}
		});	
	}
	@Override
	public void doFunction(){
		BPM++;
		BPMLabel.setText("BPM: " + Double.toString(BPM));
		//BPMLabel.setText();
		w = (int)getWeight()/5 - 10;
		h = w;
		x = 125 - (w - 50)/2;
		y = 30 - (w - 50)/2;
		rec.draw();
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		setWeight(weightSlider.getValue());
		w = (int)getWeight()/5;
		h = w;
		x = 125 - (w - 50)/2;
		y = 30 - (w - 50)/2;
		rec.draw();
		System.out.println(w +" " + getWeight());
	}
}
class draw extends JPanel{
	public draw(){
		setLayout(null);
	}
	public void draw(){
		repaint();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(Heart.x, Heart.y, Heart.w, Heart.h);		
	}
}
