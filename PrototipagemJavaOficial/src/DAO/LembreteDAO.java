package DAO;

import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import DAOFactory.DAOFactory;
import VO.LembreteVO;
import VO.ProdutoVO;

public class LembreteDAO {

	private Connection connection;

	public LembreteDAO() throws Exception {
		this.connection = DAOFactory.conexao();
	}

	public void cadastraLembrete(LembreteVO lVO) throws Exception {

		PreparedStatement preparedStatement = this.connection.prepareStatement(
				"INSERT INTO Lembrete (Data_Lembrete,Descricao_Lembrete,Assunto_Lembrete) VALUES(?,?,?) ");
		java.util.Date dataUtil = new java.util.Date();
		java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

		preparedStatement.setDate(1, new java.sql.Date(lVO.getData().getTime()));
		preparedStatement.setString(2, lVO.getDescricao());
		preparedStatement.setString(3, lVO.getAssunto());

		int cont = preparedStatement.executeUpdate();
		if (cont == 1) {
			JOptionPane.showMessageDialog(null, "Lembrete cadastrado com sucesso");
		}
	}

	public List<LembreteVO> pesquisaLembreteTodos() throws Exception {
		List<LembreteVO> retorno = new ArrayList<LembreteVO>();

		int cont = 1;
		PreparedStatement preparedStatement = this.connection.prepareStatement("Select*from Lembrete");
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			LembreteVO lembreteVO = new LembreteVO();
			lembreteVO.setCodigo(resultSet.getInt("Codigo_Lembrete"));
			lembreteVO.setData(resultSet.getDate("Data_Lembrete"));
			lembreteVO.setAssunto(resultSet.getString("Assunto_Lembrete"));
			lembreteVO.setDescricao(resultSet.getString("Descricao_Lembrete"));
			retorno.add(lembreteVO);

			cont++;
		}
		return retorno;
	}

	public String delete(LembreteVO lVO) throws Exception {
		String retorno = "N�o foi possivel excluir o produto";
		PreparedStatement preparedStatement = this.connection.prepareStatement(
				"DELETE FROM Lembrete WHERE Codigo_Lembrete = ? ");

		preparedStatement.setInt(1, lVO.getCodigo());

		int cont = preparedStatement.executeUpdate();
		
		if(cont==1){
			
			retorno="Lembrete Deletado com sucesso";
		
		}

		return retorno;
	}

	public void deletarTodos() throws  Exception {
		String retorno = "N�o foi possivel excluir o produto";
		PreparedStatement preparedStatement = this.connection.prepareStatement(
				"DELETE FROM Lembrete");

		int cont = preparedStatement.executeUpdate();
		
		if(cont==1){
			
			JOptionPane.showMessageDialog(null, "Lembrete Deletado com sucesso");
		
		}

	}

	public LembreteVO pesquisarPorCodigo(int codigo) throws Exception {
		int cont = 1;
		PreparedStatement preparedStatement = this.connection.prepareStatement("Select * from Lembrete where Codigo_Lembrete = ?");
		
		preparedStatement.setInt(1, codigo);
		
		ResultSet resultSet = preparedStatement.executeQuery();

		LembreteVO lembreteVO = new LembreteVO();
		
		if(resultSet.next()) {
			
			lembreteVO.setCodigo(resultSet.getInt("Codigo_Lembrete"));
			lembreteVO.setData(resultSet.getDate("Data_Lembrete"));
			lembreteVO.setAssunto(resultSet.getString("Assunto_Lembrete"));
			lembreteVO.setDescricao(resultSet.getString("Descricao_Lembrete"));
		}
		return lembreteVO;
	}

}
