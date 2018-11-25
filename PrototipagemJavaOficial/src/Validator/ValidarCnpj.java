package Validator;

import java.awt.event.ActionEvent;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class ValidarCnpj {
	public boolean validaCnpj(String cnpj) {

		boolean retorno = true;

		if (cnpj.replaceAll("[./-]", "").trim().equals("") || cnpj.replaceAll("[./-]", "").trim().equals(null)) {

			int dialogtextCnpj_1 = JOptionPane.YES_NO_OPTION;

			int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja continuar com CPNJ  em branco?", "Warning",
					dialogtextCnpj_1);

			if (dialogResult == JOptionPane.YES_OPTION) {
				return true;

			} else if (dialogResult == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Digite o CNPJ");
				return false;
			}

		}

		if (       cnpj.replaceAll("[./-]", "").trim().equals("00000000000000")
				|| cnpj.replaceAll("[./-]", "").trim().equals("11111111111111")
				|| cnpj.replaceAll("[./-]", "").trim().equals("22222222222222")
				|| cnpj.replaceAll("[./-]", "").trim().equals("33333333333333")
				|| cnpj.replaceAll("[./-]", "").trim().equals("44444444444444")
				|| cnpj.replaceAll("[./-]", "").trim().equals("55555555555555")
				|| cnpj.replaceAll("[./-]", "").trim().equals("66666666666666")
				|| cnpj.replaceAll("[./-]", "").trim().equals("77777777777777")
				|| cnpj.replaceAll("[./-]", "").trim().equals("88888888888888")
				|| cnpj.replaceAll("[./-]", "").trim().equals("99999999999999")
				|| (cnpj.replaceAll("[./-]","").trim().length() != 14)) {
			JOptionPane.showMessageDialog(null, "Modelo de CNPJ inexistênte");
			retorno = false;
		} else {

			char dig13, dig14;
			int sm, i, r, num, peso;
			try {
				sm = 0;
				peso = 2;
				for (i = 11; i >= 0; i--) {
					num = (int) (cnpj.replaceAll("[./-]", "").trim().charAt(i) - 48);
					sm = sm + (num * peso);
					peso = peso + 1;
					if (peso == 10) {
						peso = 2;
					}
				}
				r = (sm % 11);
				if ((r == 0) || (r == 1)) {
					dig13 = '0';
				} else {
					dig13 = (char) ((11 - r) + 48);
				}

				sm = 0;
				peso = 2;
				for (i = 12; i >= 0; i--) {
					num = (int) (cnpj.replaceAll("[./-]", "").trim().charAt(i) - 48);
					sm = sm + (num * peso);
					peso = peso + 1;
					if (peso == 10) {
						peso = 2;
					}
				}
				r = (sm % 11);
				if ((r == 0) || (r == 1)) {
					dig14 = '0';
				} else {
					dig14 = (char) ((11 - r) + 48);
				}
				if ((dig13 == cnpj.replaceAll("[./-]", "").trim().charAt(12))
						&& (dig14 == cnpj.replaceAll("[./-]", "").trim().charAt(13))) {
					retorno = (true);
				} else {
					JOptionPane.showMessageDialog(null, "Favor informar um CNPJ Válido");
					retorno = (false);
				}
			} catch (InputMismatchException erro) {
				retorno = (false);
			}
		}

		return retorno;

	}

}
