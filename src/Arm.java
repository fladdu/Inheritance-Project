import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Arm extends Limb implements ChangeListener{
	DrawArm arm = new DrawArm();
	JButton liftButton = new JButton();
	JSlider strSlider = new JSlider(JSlider.HORIZONTAL, 0, 100 ,20);
	JButton infoButton = new JButton();

	static double angle = -2.9, xCord = 0, yCord = -8; //Variables for Arm MORE ENCAP
	static int xCordD1 = 67, xCordD2 =77, yCordD1 = 168, yCordD2 = 125, dumbellSize = 20;//ENCAPSULATION
	static int buffer = 1000;//ENCAP

	/*	
	pre: parameter is positive non-zero
	post: constructs and Arm object
    */
	public Arm(double length){
		setWeight(strSlider.getValue()/4);
		setStrength(strSlider.getValue());
		setLength(length);
		setLocation("Top Two Limbs");
		setEssential(false);
		
		GUI armGUI = new GUI("Arm");
			armGUI.setSize(320, 320);
			armGUI.setVisible(true);
		arm.draw();
		strSlider.setBounds(50, 195, 200,50);
		strSlider.setMajorTickSpacing(20);
	    strSlider.setMinorTickSpacing(2);
	    strSlider.setPaintTicks(true);
	    strSlider.setPaintLabels(true);
	    strSlider.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
	    strSlider.addChangeListener(this);
	    
	    infoButton.setText("Info");
		infoButton.setBounds(10,250,60,20);
		String contents = toString();
		infoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				JOptionPane.showMessageDialog(arm, contents);
			}
		});
	    
		liftButton.setText("Lift");
		liftButton.setBounds(115,245,75,20);
		liftButton.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					doFunction(0);
				}
				public void mouseReleased (MouseEvent e){
					xCord= 0.0;
					yCord= -8.0;
					angle = -2.9;
					xCordD1 = 67;
					xCordD2 = 77;
					yCordD1 = 168;
					yCordD2 = 125;		
					buffer = 1000;
					arm.draw();
				}
		});	
		Container c = armGUI.getContentPane();
		arm.add(liftButton);
		arm.add(strSlider);
		arm.add(infoButton);
		c.add(arm);
		armGUI.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				main.GUI.setVisible(true);
			}
		});	
	}

	/*	
	pre: input is positive + non-zero, there is an arm object
	post: switches arm to 'lifted'
    */
    @Override
	public void doFunction(double input){ //REMOVED INPUT FOR NOW
		//TODO: check if input is less than lifting stuff
		//do stuff
		angle = -1.4;
		xCord = 0.0;
		yCord = 0.0;
		xCordD1 = 93;
		xCordD2 = 136;
		yCordD1 = 31;
		yCordD2 = 39;
		buffer = 0;
		arm.draw();
	}

	/*	
	pre: arg0 is defined, there is an Arm object
	post: updates instance variables based on sliders
    */
	@Override
	public void stateChanged(ChangeEvent arg0) {
		dumbellSize = strSlider.getValue()/2;
		setStrength(strSlider.getValue());
		setWeight(strSlider.getValue()/4);
		arm.draw();
	}
	
	@Override
	public String toString(){
		String info = "Name: Arm" + "\nLocation: " + getLocation() + "\nEssential: " + getEssential() + "\nStrength: " + getStrenght() 
				 + "\nWeight: " + getWeight() + "\nLength: " + getLength();
		return info;
	}

}
class DrawArm extends JPanel{

	/*	
	pre: nothing
	post: constucts DrawArm object
    */
	public DrawArm(){
		setLayout(null);
	}

	/*	
	pre: there is a DrawArm object
	post: calls repaint method
    */
	public void draw(){
		repaint();
	}

	/*	
	pre: there is a DrawArm object, g is defined
	post: paints arm + dumbell
    */
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
		Rectangle2D dumbell = new Rectangle2D.Double(0, -10, 5, 50);
		transform.rotate(0.7);
		transform.translate(67, -60);
		Shape rotatedDumbell = transform.createTransformedShape(dumbell);
		g2d.fill(rotatedDumbell);
		//I WAS TRYING STUFF TO MAKE IT CENTER vvvvvv//
		g.fillOval(Arm.xCordD1-(Arm.dumbellSize/2), Arm.yCordD1-(Arm.dumbellSize/2), Arm.dumbellSize, Arm.dumbellSize);//55,155 // 85,20
		g.fillOval(Arm.xCordD2-(Arm.dumbellSize/2), Arm.yCordD2-(Arm.dumbellSize/2), Arm.dumbellSize, Arm.dumbellSize);//65,115// 122, 27
		transform.rotate(-0.7);
		transform.translate(-92 + Arm.buffer, 35);
		Shape rotatedMuscle = transform.createTransformedShape(muscle);
		g2d.setColor(new Color(242,225,189));
		g2d.fill(rotatedMuscle);
		
		
		
		
		//Pre: Angle: -2.9 Transform: 0,-8
		//Post: Angle: -1.4 Transfomr: 0, 0
	}
}