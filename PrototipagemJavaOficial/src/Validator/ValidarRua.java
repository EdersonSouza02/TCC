package Validator;

import javax.swing.JOptionPane;

public class ValidarRua {
	public boolean validaRua(String rua) {
		if (rua.trim().equals("")) {

			JOptionPane.showMessageDialog(null, "Favor informar o nome da RUA");

			return false;
		} else {
			return true;
		}
}
}
