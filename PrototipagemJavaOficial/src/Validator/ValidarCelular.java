package Validator;

import javax.swing.JOptionPane;

public class ValidarCelular {

	public boolean validaCelular(String celular) {
		if (celular.replaceAll("[()-]", "").trim().equals("")) {
			int dialogtext = JOptionPane.YES_NO_OPTION;

			int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja continuar com Celular  em branco?", "Warning",
					dialogtext);

			if (dialogResult == JOptionPane.YES_OPTION) {
				return true;

			} else if (dialogResult == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Digite o Celular");
				return false;
			}
		}
		if (celular.replaceAll("[()-]", "").length() != 11) {
			JOptionPane.showMessageDialog(null, "Celular Inválido abaixo de 11 digitos");
			return false;
		}

		return true;
	}

}
