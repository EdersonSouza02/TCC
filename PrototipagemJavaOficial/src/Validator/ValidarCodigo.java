package Validator;

import javax.swing.JOptionPane;

public class ValidarCodigo {

	public boolean validaCodigo(int codigo) {

		if (codigo <= 0) {
			JOptionPane.showMessageDialog(null, "C�digo Inv�lido");

			return false;
		} else {
			return true;

		}
	}
}
