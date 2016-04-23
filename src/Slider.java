import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Slider  implements ActionListener,ChangeListener{

	public Slider(int min, int max, int init, int majorSpacing, int minorSpacing, int x, int y, int width, int height){
		JSlider slider = new JSlider(JSlider.HORIZONTAL, min, max,init);
		
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
