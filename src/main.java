import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class main {
	static JButton ButtonHeart = new JButton();
	static JButton ButtonArm = new JButton();
	static JButton ButtonLeg = new JButton();
	static JButton ButtonStom = new JButton();
	static JButton ButtonLung = new JButton();
	
	public static void main(String[] args) {
		GUI GUI = new GUI("Black Market Bodypart Store Manager");
		GUI.setVisible(true);
		Container c = GUI.getContentPane();
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		ButtonHeart.setText("Heart");
		ButtonHeart.setPreferredSize(new Dimension(200, 20));
		ButtonHeart.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Heart heart = new Heart(100);
				}
			});
		ButtonLung.setText("Lung");
		ButtonLung.setPreferredSize(new Dimension(200, 20));
		ButtonLung.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Lung lung = new Lung(100, 100);
				}
			});
		ButtonStom.setText("Stomach");
		ButtonStom.setPreferredSize(new Dimension(200, 20));
		ButtonStom.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Stomach stomach = new Stomach(100, 150);
				}
			});
		ButtonArm.setText("Arm");
		ButtonArm.setPreferredSize(new Dimension(200, 20));
		ButtonArm.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Arm arm = new Arm(100, 15, 85);
				}
			});
		ButtonLeg.setText("Leg");
		ButtonLeg.setPreferredSize(new Dimension(200, 20));
		ButtonLeg.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Leg leg = new Leg(100, 15, 85);
				}
			});
		p.add(ButtonHeart);
		p.add(ButtonArm);
		p.add(ButtonLeg);
		p.add(ButtonLung);
		p.add(ButtonStom);
		c.add(p);
		
		

	}

}
/*											Product
 *							Food							 	Misc	
 *		Dairy Grain Fruit-Vegetable Meat Other					 
 * 
 * 
 * 
 */
//D: Milk% LactosFree
//FOOD: ExpirationDate, Organic,     
//PRODUCT: Barcode, Price

