import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import javax.swing.*;

public class Arm extends Limb{
	DrawArm arm = new DrawArm();
	JButton liftButton = new JButton();
	static double angle = -2.9, xCord = 0, yCord = -8; //Variables for Arm
	static int xCordD1 = 55, xCordD2 =65, yCordD1 = 155, yCordD2 = 115;
	static int buffer = 1000;
	public Arm(double strength, double weight, double length){
		setWeight(weight);
		setStrength(strength);
		setLength(length);
		setEssential(false);
		
		GUI armGUI = new GUI("Arm");
			armGUI.setSize(320, 320);
			armGUI.setVisible(true);
		arm.draw();
		liftButton.setText("Lift");
		liftButton.setBounds(115,200,75,20);
		liftButton.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					doFunction(0);
				}
				public void mouseReleased (MouseEvent e){
					xCord= 0.0;
					yCord= -8.0;
					angle = -2.9;
					xCordD1 = 55;
					xCordD2 = 65;
					yCordD1 = 155;
					yCordD2 = 115;		
					buffer = 1000;
					arm.draw();
				}
		});	
		Container c = armGUI.getContentPane();
		arm.add(liftButton);
		c.add(arm);
		
	}

	public void doFunction(double input){ //REMOVED INPUT FOR NOW
		//TODO: check if input is less than lifting stuff
		//do stuff
		angle = -1.4;
		xCord = 0.0;
		yCord = 0.0;
		xCordD1 = 85;
		xCordD2 = 122;
		yCordD1 = 20;
		yCordD2 = 27;
		buffer = 0;
		arm.draw();
	}

}
class DrawArm extends JPanel{
	public DrawArm(){
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
			transform.rotate(-0.7);
			transform.translate(40, 180);
			Shape rotatedUpper = transform.createTransformedShape(upper);
		g2d.fill(rotatedUpper);
		//Second Rectangle
			transform.rotate(Arm.angle);
			transform.translate(Arm.xCord,Arm.yCord);
			Shape rotatedLower = transform.createTransformedShape(lower);
		g2d.fill(rotatedLower);
		g.fillOval(145,105,15,15);
		g.setColor(Color.BLACK);
		Rectangle2D dumbell = new Rectangle2D.Double(0, 0, 10, 30);
		transform.rotate(0.7);
		transform.translate(67, -60);
		Shape rotatedDumbell = transform.createTransformedShape(dumbell);
		g2d.fill(rotatedDumbell);
		g.fillOval(Arm.xCordD1, Arm.yCordD1, 20, 20);//55,155 // 85,20
		g.fillOval(Arm.xCordD2, Arm.yCordD2, 20, 20);//65,115// 122, 27
		transform.rotate(-0.7);
		transform.translate(-92 + Arm.buffer, 35);
		Shape rotatedMuscle = transform.createTransformedShape(muscle);
		g2d.setColor(new Color(242,225,189));
		g2d.fill(rotatedMuscle);
		
		
		
		
		//Pre: Angle: -2.9 Transform: 0,-8
		//Post: Angle: -1.4 Transfomr: 0, 0
	}
}