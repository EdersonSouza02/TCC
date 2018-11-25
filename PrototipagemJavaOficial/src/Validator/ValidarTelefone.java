package Validator;

import javax.swing.JOptionPane;

public class ValidarTelefone {

	public boolean validaTelefone(String telefone) {
		if (telefone.replaceAll("[()-]", "").trim().equals("")) {
			int dialogtext = JOptionPane.YES_NO_OPTION;

			int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja continuar com Telefone  em branco?", "Warning",
					dialogtext);

			if (dialogResult == JOptionPane.YES_OPTION) {
				return true;

			} else if (dialogResult == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Digite o Telefone");
				return false;
			}
		}
		if (telefone.replaceAll("[()-]", "").length() != 10) {
			JOptionPane.showMessageDialog(null, "Telefone Inválido abaixo de 10 digitos");
			return false;
		}

		return true;
	}
}
