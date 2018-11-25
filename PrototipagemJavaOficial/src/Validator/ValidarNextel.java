package Validator;

import javax.swing.JOptionPane;

public class ValidarNextel {
	
	public boolean validaNextel(String nextel){
		if(nextel.trim().equals("")){
			int dialogtext = JOptionPane.YES_NO_OPTION;

			int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja continuar com Nextel  em branco?", "Warning",
					dialogtext);

			if (dialogResult == JOptionPane.YES_OPTION) {
				return true;

			} else if (dialogResult == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Digite o Nextel");
				return false;
			}
		}
		if(nextel.length() <= 6 || nextel.length() > 16){
			JOptionPane.showMessageDialog(null, "Quantidade de Dígitos do Nextel Inválidos");
			return false;
		}	
		
	return true;	
	}

}
