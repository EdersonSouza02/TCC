package Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class ValidarNome {
public boolean validaNome(String nome){

		if (nome.trim().equals("")) {

			JOptionPane.showMessageDialog(null,
					"O espa�o nome n�o pode ficar em BRANCO");

			return false;
		} 
	
		else {
			return true;
		}
}


}

