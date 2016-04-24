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
	
	//instance vars
	private JButton pumpButton = new JButton();
	private JLabel BPMLabel = new JLabel();
	private JButton infoButton = new JButton();
	private draw rec = new draw();
	private JSlider weightSlider = new JSlider(JSlider.HORIZONTAL, 0, 1000,450);
	private int w = 50 ,h = 50, x = 125, y = 30;
	private double BPM = 0;
	private double temp = 0;
	private int i = 1;
	private JButton heartInfoButton = new JButton();

	/*	
	pre: weight is defeined + non-zero
	post: constructs Heart object
    */
	public Heart(double weight){

		//setting instance vars
		setWeight(weight);
		setBodySystem("Circulatory System");
		setLocation("Inside Chest");
		setEssential(true);
		
		pumpButton.setText("Heart Info");
		pumpButton.setBounds(115,200,75,20);
		
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
		
		infoButton.setText("Info");
		infoButton.setBounds(10,250,60,20);
		String contents = toString();
		infoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				JOptionPane.showMessageDialog(rec, contents);
			}
		});
		pumpButton.setText("Pump");
		pumpButton.setBounds(115,200,75,20);

		pumpButton.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					doFunction();
				}
				public void mouseReleased (MouseEvent e){
					w = (int)getWeight()/5;
					h = w;
					x = 125 - (w - 50)/2;
					y = 30 - (w - 50)/2;
					rec.draw();
				}
		});

		//Timer!!!!!!
		Timer bpm = new Timer(1000, new ActionListener(){
			public void actionPerformed (ActionEvent e) {
					
					BPM *= i-1;
					BPM += temp * 60;//this here calculates the average BPM over the lifetime of the Heart gui
					BPM /= i;
					i++;
					temp = 0;

					BPMLabel.setText("BPM: " + Double.toString(BPM));
					rec.draw();
			}
		});
		bpm.start();
		
		GUI heartGUI = new GUI("Heart");
		heartGUI.setSize(320, 320);
		heartGUI.setVisible(true);
		
		rec.draw();	
		rec.add(BPMLabel);
		rec.add(pumpButton);
		rec.add(weightSlider);
		rec.add(infoButton);
		Container c = heartGUI.getContentPane();
		c.add(rec);
		
		heartGUI.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				main.GUI.setVisible(true);
				bpm.stop();
			}
		});	

	}

	/*	
	pre: there is a Heart object
	post: 'contracts' the heart
    */
	@Override
	public void doFunction(){
		temp++;
		w = (int)getWeight()/5 - 10;
		h = w;
		x = 125 - (w - 50)/2;
		y = 30 - (w - 50)/2;
		rec.draw();
	}

	/*	
	pre: there is a Heart object
	post: updates image based on slider values
    */
	@Override
	public void stateChanged(ChangeEvent e) {
		setWeight(weightSlider.getValue());
		w = (int)getWeight()/5;
		h = w;
		x = 125 - (w - 50)/2;
		y = 30 - (w - 50)/2;
		rec.draw();
	}
	@Override
	public String toString(){
		String info = "Name: Heart" + "\nLocation: " + getLocation() + "\nBody System: " + getBodySystem() + 
				"\nEssential: " + getEssential() + "\nWeight: " + getWeight() + "\nBPM: " + BPM;
		return info;
	}

	class draw extends JPanel{

	/*	
	pre: nothing
	post: constructs a draw object
    */
	public draw(){
		setLayout(null);
	}

	/*	
	pre: there is a draw object
	post: calls the repaint method
    */
	public void draw(){
		repaint();
	}

	/*	
	pre: there is a Heart + draw object
	post: paints the heart
    */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(x, y, w, h);		
	}
}
	
}//class
