import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.*;
import java.util.TimerTask;
import java.awt.*;
import javax.swing.*;

public class Leg extends Limb{
	private double runningSpeed;
	JButton kickButton = new JButton();
	Timer timer;
	static DrawLeg leg = new DrawLeg();
	static double angle = 0.6, xCord = 70, yCord = -45, xCordBall = 105, yCordBall = 250;
	public Leg(double strength, double weight, double length){
		//TODO: init strength length and weight and location and essential somewhere up the high-archie DONE
		//figure out how to strength --> speed....or not
		//also do gui stuff DONE
		setStrength(strength);
		setWeight(weight);
		setLength(length);
		setEssential(false);
		GUI legGUI = new GUI("Arm");
			legGUI.setSize(1080, 320);
			legGUI.setVisible(true);
		Container c = legGUI.getContentPane();
		c.add(leg);
		kickButton.setText("Kick");
		kickButton.setBounds(900,20,75,20);
		kickButton.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					doFunction(0);
					timer.start();
				}
				public void mouseReleased (MouseEvent e){
					angle = 0.6; 
					xCord = 70;
					yCord = -45;
					leg.draw();
				}
		});	
		leg.add(kickButton);
		timer = new Timer(1, new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//double x,y;
					xCordBall+=4;
					yCordBall = 0.001 * Math.pow(xCordBall - 420,2) + 150;
					leg.draw();
					if (yCordBall+55>= 315){
						try {
							Thread.sleep(200);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						xCordBall = 105;
						yCordBall = 250;
						leg.draw();
						timer.stop();
					}
				}
			});
		legGUI.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				main.GUI.setVisible(true);
			}
		});	
	}

	public void doFunction(double input){
		angle = -0.2; 
		xCord = 80;
		yCord = 17;
		leg.draw();
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
		Ellipse2D ball = new Ellipse2D.Double(Leg.xCordBall,Leg.yCordBall, 25, 25);
		Ellipse2D foot = new Ellipse2D.Double(80,-15, 10, 25);
		AffineTransform transform = new AffineTransform();	
			transform.rotate(1.2);
			transform.translate(120, -10);
			Shape rotatedUpper = transform.createTransformedShape(upper);
		g2d.fill(rotatedUpper);
		//Second Rectangle
			transform.rotate(Leg.angle);
			transform.translate(Leg.xCord,Leg.yCord);
			Shape rotatedLower = transform.createTransformedShape(lower);
			Shape rotatedFoot = transform.createTransformedShape(foot);
		g2d.fill(rotatedLower);
		g2d.fill(rotatedFoot);
		g.fillOval(69,178,15,15);
		g.setColor(Color.BLACK);
		g2d.fill(ball);

		
		
		
		//Pre: Angle: -2.9 Transform: 0,-8
		//Post: Angle: -1.4 Transfomr: 0, 0
	}
}