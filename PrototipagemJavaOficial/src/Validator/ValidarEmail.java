package Validator;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class ValidarEmail {
	public boolean validaEmail(String email) {
		boolean isEmailIdValid = false;
		
		if(email.replaceAll("[.-]", "").trim().equals("")||email.replaceAll("[.-]", "").trim().equals(null)){
			int dialogtextEmail = JOptionPane.YES_NO_OPTION;

			int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja continuar com E-mail  em branco?", "Warning",
					dialogtextEmail);

			if (dialogResult == JOptionPane.YES_OPTION) {
				return true;

			} else if (dialogResult == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Digite o E-mail");
				return false;
			}
		}
			
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            java.util.regex.Matcher matcher = pattern.matcher(email);

            if (matcher.matches()) {
                
                isEmailIdValid = true;

            } else {
                JOptionPane.showMessageDialog(null, "Corrija o Campo do E-MAIL");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Corrija o Campo do E-MAIL");
        }
        return isEmailIdValid;
	}

}
