import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
public class Heart extends Organ{
	JButton pumpButton = new JButton();
	JLabel BPMLabel = new JLabel();
	draw rec = new draw();
	public static int w = 50 ,h = 50;
	double BPM = 0;
	public Heart(double weight){
		setWeight(weight);
		setBodySystem("Circulatory System");
		setLocation("Inside Chest");
		setEssential(true);
		
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
					w=50;
					h=50;
					rec.draw();
				}
		});
		
		JLabel heartIMG = new JLabel(new ImageIcon("heart2.jpg"));
			heartIMG.setBounds(125, 100, 250, 250);
			heartIMG.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			heartIMG.setVisible(true);
		GUI heartGUI = new GUI("Heart");
			heartGUI.setSize(320, 320);
			heartGUI.setVisible(true);
		
			rec.draw();	
			rec.add(BPMLabel);
			rec.add(pumpButton);
			rec.add(heartIMG);
		Container c = heartGUI.getContentPane();
			c.add(rec);
			//c.add(heartIMG);
			
	}
	@Override
	public void doFunction(){
		BPM++;
		BPMLabel.setText("BPM: " + Double.toString(BPM));
		//BPMLabel.setText();
		w=40;
		h=40;	
		rec.draw();
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
		g.fillRect(125, 30, Heart.w, Heart.h);		
	}
}
