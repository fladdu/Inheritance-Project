import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class main {
	static JButton ButtonHeart = new JButton();
	
	public static void main(String[] args) {
		GUI GUI = new GUI("Grocery Store Manager");
		GUI.setVisible(true);
		Container c = GUI.getContentPane();
		JPanel p = new JPanel();
		ButtonHeart.setText("Heart");
		ButtonHeart.setPreferredSize(new Dimension(200, 20));
		ButtonHeart.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Heart heart = new Heart(100);
					//heart.doFunction();
				}
			});
		
		p.add(ButtonHeart);
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

