package Validator;

import javax.swing.JOptionPane;

public class ValidarCodigo {

	public boolean validaCodigo(int codigo) {

		if (codigo <= 0) {
			JOptionPane.showMessageDialog(null, "Código Inválido");

			return false;
		} else {
			return true;

		}
	}
}
