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
	static GUI GUI = new GUI("Black Market Bodypart Store Manager");
	public static void main(String[] args) {
		GUI.setVisible(true);
		JPanel infoPanel = new JPanel(null);
		infoPanel.setVisible(false);
		Container c = GUI.getContentPane();
		JPanel p = new JPanel();
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		JOptionPane.showMessageDialog(infoPanel, "           Welcome to the Black Market.\nClick on one of the Body Parts to view their\n"
							+ "function and information. Some Body Parts\nmay take parameters. Please input valid\n"
							+ "values to avoid deformed body parts!\n\n                   Press OK to begin.");
		
		
		ButtonHeart.setText("Heart");
		ButtonHeart.setMnemonic('H');
		ButtonHeart.setMaximumSize(new Dimension(110, 30));
		ButtonHeart.setAlignmentX(Component.CENTER_ALIGNMENT);
		ButtonHeart.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Heart heart = new Heart(500);
					GUI.setVisible(false);
				}
			});
		ButtonLung.setText("Lung");
		ButtonLung.setMaximumSize(new Dimension(110, 30));
		ButtonLung.setAlignmentX(Component.CENTER_ALIGNMENT);
		ButtonLung.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Lung lung = new Lung(100, 100);
					GUI.setVisible(false);
				}
			});
		ButtonStom.setText("Stomach");
		ButtonStom.setMaximumSize(new Dimension(110, 30));
		ButtonStom.setAlignmentX(Component.CENTER_ALIGNMENT);
		ButtonStom.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Stomach stomach = new Stomach(100, 150);
					GUI.setVisible(false);
				}
			});
		ButtonArm.setText("Arm");
		ButtonArm.setMaximumSize(new Dimension(110, 30));
		ButtonArm.setAlignmentX(Component.CENTER_ALIGNMENT);
		ButtonArm.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Arm arm = new Arm(85);
					GUI.setVisible(false);
				}
			});
		ButtonLeg.setText("Leg");
		ButtonLeg.setMaximumSize(new Dimension(110, 30));
		ButtonLeg.setAlignmentX(Component.CENTER_ALIGNMENT);
		ButtonLeg.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Leg leg = new Leg(100, 15, 85);
					GUI.setVisible(false);
				}
			});
		p.add(Box.createRigidArea(new Dimension(200,15)));
		p.add(ButtonHeart);
		p.add(Box.createRigidArea(new Dimension(0,15)));
		p.add(ButtonArm);
		p.add(Box.createRigidArea(new Dimension(0,15)));
		p.add(ButtonLeg);
		p.add(Box.createRigidArea(new Dimension(0,15)));
		p.add(ButtonLung);
		p.add(Box.createRigidArea(new Dimension(0,15)));
		p.add(ButtonStom);
		p.add(Box.createRigidArea(new Dimension(0,15)));
		c.add(p);
		GUI.pack();
		
		

	}

}
/*											
 /TODO: 
  *
 */
//D: Milk% LactosFree
//FOOD: ExpirationDate, Organic,     
//PRODUCT: Barcode, Price

