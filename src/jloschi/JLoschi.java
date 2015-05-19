package jloschi;

import javax.swing.*;
import java.awt.*;

public class JLoschi {

	public static void main(String[] args) {
		JFrame f = new JFrame("JLoschi");
		JPanel p = new JPanel();
		
		p.setLayout(new GridLayout(5, 2));
		
		JTextField txtRe = new JTextField(10);
		JTextField txtIm = new JTextField(10);
		
		JTextField txtModulus = new JTextField(10);
		JTextField txtArgument = new JTextField(10);
		
		p.add(new JLabel("Re:", JLabel.RIGHT));
		p.add(txtRe);
		p.add(new JLabel("Im:", JLabel.RIGHT));
		p.add(txtIm);
		p.add(new JLabel("Modulus:", JLabel.RIGHT));
		p.add(txtModulus);
		p.add(new JLabel("Argument:", JLabel.RIGHT));
		p.add(txtArgument);
		
		JButton btnConvertToPolar = new JButton("Convert to Polar");
		JButton btnConvertToRectangular = new JButton("Convert to Rectangular");
		
		GestoreEventi g = new GestoreEventi(
				txtRe,
				txtIm,
				txtModulus,
				txtArgument
				);
		
		btnConvertToPolar.addActionListener(g);
		btnConvertToRectangular.addActionListener(g);
		
		p.add(btnConvertToPolar);
		p.add(btnConvertToRectangular);
		
		f.getContentPane().add(p);
		
		f.setSize(500, 200);
		f.setVisible(true);
		
		int i=0;
		while(true) {
			System.out.println("Ciao Roland, " + (i++) + " volte");
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {
				System.err.println("Qualcosa è andato storto");
			}
		}
	}

}
