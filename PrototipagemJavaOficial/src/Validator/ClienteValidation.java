package Validator;

import javax.swing.JOptionPane;

import DAO.ClienteDAO;
import VO.ClienteVO;

public class ClienteValidation {
	ValidarNome validarNome = new ValidarNome();
	ValidarCnpj validarCnpj = new ValidarCnpj();
	ValidarCpf validarCpf = new ValidarCpf();
	ValidarEmail validarEmail = new ValidarEmail();
	ValidarCep validarCep = new ValidarCep();
	ValidarRua validarRua = new ValidarRua();
	ValidarNumero validarNumero = new ValidarNumero();
	ValidarNextel validarNextel = new ValidarNextel();
	ValidarTelefone validarTelefone = new ValidarTelefone();
	ValidarCelular validarCelular = new ValidarCelular();
	ValidarPagamento validarPagamento = new ValidarPagamento();
	ValidarCodigo validarCodigo = new ValidarCodigo();

	public boolean validaCodigoCliente(ClienteVO cVO) throws Exception {

		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			boolean retornoCodigo_Cliente = clienteDAO.verificaExistenciaCodigo_Cliente(cVO.getCodigo());
			if (retornoCodigo_Cliente == true) {
				retornoCodigo_Cliente = true;
			} else {
				retornoCodigo_Cliente = false;
				JOptionPane.showMessageDialog(null, "Código do Cliente já Castrado", "Código Inválido",
						JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;

	}

	public boolean validarDados(ClienteVO cVO) {

		boolean retornoCodigo = validarCodigo.validaCodigo(cVO.getCodigo());
		boolean retornoNome = validarNome.validaNome(cVO.getNome());
		boolean retornoEmail = validarEmail.validaEmail(cVO.getEmail());
		boolean retornoTelefone = validarTelefone.validaTelefone(cVO.getFixo());
		boolean retornoNextel = validarNextel.validaNextel(cVO.getNextel());
		boolean retornoCelular = validarCelular.validaCelular(cVO.getCel());
		boolean retornoCnpj = validarCnpj.validaCnpj(cVO.getCnpj());
		boolean retornoCpf = validarCpf.validaCpf(cVO.getCpf());
		boolean retornoCep = validarCep.validaCep(cVO.getCep());
		boolean retornoRua = validarRua.validaRua(cVO.getRua());
		boolean retornoNumero = validarNumero.validaNumero(cVO.getNumero());
		boolean retornoPagamento = validarPagamento.validaPagamento(cVO.getFormaDePagamento());

		if (retornoCodigo == true && retornoNome == true && retornoEmail == true && retornoTelefone == true
				&& retornoNextel == true && retornoCelular == true && retornoCnpj == true && retornoCpf == true
				&& retornoCep == true && retornoRua == true && retornoNumero == true && retornoPagamento == true) {
			return true;
		}
		return false;
	}

}
