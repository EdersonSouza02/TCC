package Validator;

import javax.swing.JOptionPane;

public class ValidarPagamento {
	
	public boolean validaPagamento(String formaDePagamento){
		if(formaDePagamento.trim().equals("")){
			JOptionPane.showMessageDialog(null,
					"Escolho a forma de pagamento para esse Cliente");
			return false;
		}else{
			return true;
		}
	}

}
