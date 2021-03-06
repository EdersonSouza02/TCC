package BO;

import java.sql.SQLException;
import java.util.List;

import DAO.LembreteDAO;
import VO.LembreteVO;
import Validator.LembreteValidation;

public class LembreteBO {

	public void cadastrarLembrete(LembreteVO lVO) throws Exception{
		LembreteValidation lValidation = new LembreteValidation();
		LembreteDAO lDAO = new LembreteDAO();
		
		
		
		boolean retorno = lValidation.validaLembrete(lVO);
		
		if(retorno){
			lDAO.cadastraLembrete(lVO);
		}
	}

	public List<LembreteVO> getDados() throws Exception {
		LembreteDAO lDAO = new LembreteDAO();
		
		return lDAO.pesquisaLembreteTodos();
	}

	public void deletarTodos() throws Exception {
		LembreteDAO lDAO = new LembreteDAO();
		
		lDAO.deletarTodos();
	}

	public LembreteVO pesquisarPorCodigo(int codigo) throws Exception {
		LembreteDAO lDAO = new LembreteDAO();
		return lDAO.pesquisarPorCodigo(codigo);
	}

}
