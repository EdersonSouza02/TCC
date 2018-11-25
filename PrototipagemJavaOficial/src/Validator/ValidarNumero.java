package Validator;

import javax.swing.JOptionPane;

public class ValidarNumero {
	
	public boolean validaNumero(String numero){
		if(numero.trim().equals("")){
			int dialogtext = JOptionPane.YES_NO_OPTION;

			int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja continuar com Número  em branco?", "Warning",
					dialogtext);

			if (dialogResult == JOptionPane.YES_OPTION) {
			
				return true;

			} else if (dialogResult == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Digite o Número");
				return false;
			}
			
			
		}
		
		
	return true;	
	}

}
