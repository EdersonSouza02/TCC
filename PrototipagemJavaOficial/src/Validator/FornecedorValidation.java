package Validator;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.hamcrest.Matcher;

import DAO.FornecedorDAO;
import VO.FornecedorVO;

public class FornecedorValidation {
	ValidarNome validarNome = new ValidarNome();
	ValidarCnpj validarCnpj = new ValidarCnpj();
	ValidarEmail validarEmail = new ValidarEmail();
	ValidarCep validarCep = new ValidarCep();
	ValidarRua validarRua = new ValidarRua();
	ValidarNumero validarNumero = new ValidarNumero();
	ValidarNextel validarNextel = new ValidarNextel();
	ValidarTelefone validarTelefone = new ValidarTelefone();
	ValidarCelular validarCelular = new ValidarCelular();
	ValidarCodigo validarCodigo = new ValidarCodigo();

	public boolean validarCodigoFornecedor(FornecedorVO fornecedorVO) {

			try {
				FornecedorDAO fornecedorDAO = new FornecedorDAO();
				boolean retornoCodigo_Fornecedor = fornecedorDAO.verificaExistenciaCodigo_Fornecedor(fornecedorVO.getCodigoFornecedor());
				if (retornoCodigo_Fornecedor == true) {
					retornoCodigo_Fornecedor = true;
				} else {
					retornoCodigo_Fornecedor = false;
					JOptionPane.showMessageDialog(null, "Código do Fornecedor já Castrado", "Código Inválido",
							JOptionPane.WARNING_MESSAGE);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

	return true;

	}

	public boolean validarDados(FornecedorVO fornecedorVO) {

		boolean retornoCodigo = validarCodigo.validaCodigo(fornecedorVO.getCodigoFornecedor());
		boolean retornoNome = validarNome.validaNome(fornecedorVO.getEmpresa());
		boolean retornoCnpj = validarCnpj.validaCnpj(fornecedorVO.getCnpj());
		boolean retornoEmail = validarEmail.validaEmail(fornecedorVO.getEmail());
		boolean retornoCep = validarCep.validaCep(fornecedorVO.getCep());
		boolean retornoRua = validarRua.validaRua(fornecedorVO.getRua());
		boolean retornoNumero = validarNumero.validaNumero(fornecedorVO.getNumero());
		boolean retornoTelefone = validarTelefone.validaTelefone(fornecedorVO.getTelefone());
		boolean retornoCelular = validarCelular.validaCelular(fornecedorVO.getTelefoneCelular());
		boolean retornoNextel = validarNextel.validaNextel(fornecedorVO.getNextel());

		if (retornoCodigo == true && retornoNome == true && retornoCnpj == true && retornoEmail == true && retornoCep == true &&retornoRua == true  
				&& retornoNumero == true && retornoTelefone == true && retornoCelular == true  && retornoNextel == true) {
			return true;
		}
		return false;

	}

}
