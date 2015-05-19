package jloschi;

import java.awt.event.*;

import javax.swing.*;
import java.awt.*;

import complexnumber.*;

public class GestoreEventi implements ActionListener {
	private JTextField txtRe;
	private JTextField txtIm;
	private JTextField txtModulus;
	private JTextField txtArgument;
	
	GestoreEventi(
			JTextField txtRe,
			JTextField txtIm,
			JTextField txtModulus,
			JTextField txtArgument
			) {
		this.txtRe = txtRe;
		this.txtIm = txtIm;
		this.txtArgument = txtArgument;
		this.txtModulus = txtModulus;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals("Convert to Polar")) {
			String strRe = txtRe.getText();
			String strIm = txtIm.getText();
			if(strRe != null && strIm != null) {
				try {
					double re = Double.valueOf(strRe).doubleValue();
					double im = Double.valueOf(strIm).doubleValue();
					ComplexNumber.setInitRectangular(re, im);
					ComplexNumber n = new ComplexNumber();
					txtModulus.setText("" + n.getModulus());
					txtArgument.setText(Double.toString(n.getArgument()));
				}
				catch(NumberFormatException ex) {
					System.err.println("Errore di conversione");
				}
			}
		}
		else if(command.equals("Convert to Rectangular")) {
			String strModulus = txtModulus.getText();
			String strArgument = txtArgument.getText();
			if(strModulus != null && strArgument != null) {
				double modulus = Double.valueOf(strModulus).doubleValue();
				double argument = Double.valueOf(strArgument).doubleValue();
				ComplexNumber.setInitPolar(modulus, argument);
				ComplexNumber n = new ComplexNumber();
				txtRe.setText("" + n.getRe());
				txtIm.setText(Double.toString(n.getIm()));
			}
		}
		else {
			System.err.println("Unhandled command \"" + command + "\"");
		}
	}

}
