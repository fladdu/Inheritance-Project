import java.awt.*;
import java.awt.geom.*;

import javax.swing.JPanel;

public class Leg extends Limb{
	private double runningSpeed;
	static DrawLeg leg = new DrawLeg();
	public Leg(double strength, double weight, double length){
		//TODO: init strength length and weight and location and essential somewhere up the high-archie
		//figure out how to strength --> speed
		//also do gui stuff
		setStrength(strength);
		setWeight(weight);
		setLength(length);
		setEssential(false);
		GUI legGUI = new GUI("Arm");
			legGUI.setSize(320, 320);
			legGUI.setVisible(true);
		Container c = legGUI.getContentPane();
		c.add(legGUI);
	}

	public void doFunction(double input){
		//TODO: check if input is less than speed
		//do stuff
	}
}

class DrawLeg extends JPanel{
	public DrawLeg(){
		setLayout(null);
	}
	public void draw(){
		repaint();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(new Color(242,225,189));//skin-color
		Rectangle2D upper = new Rectangle2D.Double(0,0,85,10);
		Rectangle2D lower = new Rectangle2D.Double(0,0,85,10);//65 110
		Ellipse2D muscle = new Ellipse2D.Double(0,0, 20, 25);
		AffineTransform transform = new AffineTransform();
		//First Rectangle	
			transform.rotate(0.7);
			transform.translate(40, 180);
			Shape rotatedUpper = transform.createTransformedShape(upper);
		g2d.fill(rotatedUpper);
		//Second Rectangle
			transform.rotate(Arm.angle);
			transform.translate(Arm.xCord,Arm.yCord);
			Shape rotatedLower = transform.createTransformedShape(lower);
		g2d.fill(rotatedLower);
		g.fillOval(145,105,15,15);

		
		
		
		//Pre: Angle: -2.9 Transform: 0,-8
		//Post: Angle: -1.4 Transfomr: 0, 0
	}
}