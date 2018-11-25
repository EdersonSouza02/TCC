package Validator;

import javax.swing.JOptionPane;

public class ValidarCep {

	public boolean validaCep(String cep) {
		if(cep.replaceAll("[-]", "").trim().equals("")){
			JOptionPane.showMessageDialog(null, "É nescessário preencher o campo CEP");
			return false;
		}
		if(cep.replaceAll("[-]", "").trim().equals(null)){
			JOptionPane.showMessageDialog(null, "É nescessário preencher o campo CEP");
			return false;
		}
		return true;
	}
}
