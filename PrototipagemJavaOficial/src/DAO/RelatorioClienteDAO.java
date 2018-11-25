package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import DAOFactory.DAOFactory;
import VO.RelatorioClienteVO;

public class RelatorioClienteDAO {
	private Connection connection;

	public RelatorioClienteDAO() throws Exception {
		this.connection = DAOFactory.conexao();
	}

	public RelatorioClienteVO getDadosRelatoriosCliente(Date dataInicio, Date dataFinal) throws Exception {
RelatorioClienteVO cliente = new RelatorioClienteVO();
		PreparedStatement preparedStatement = this.connection.prepareStatement(
				"select cliente.Nome_Cliente, count(vendas.Codigo_Cliente) as 'Quantidade',sum(vendas.quantidade_venda) as 'relatorios' from cliente inner join vendas on(cliente.Codigo_Cliente = vendas.Codigo_Cliente) inner join estoque on(vendas.Codigo_Produto = estoque.Codigo_Produto)where data_venda between ?  and ? group by cliente.Nome_Cliente order by  vendas.quantidade_venda desc;");
		java.util.Date dataUtil = new java.util.Date();
		java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

		preparedStatement.setDate(1, new java.sql.Date(dataInicio.getTime()));
		preparedStatement.setDate(2, new java.sql.Date(dataFinal.getTime()));
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()){
			cliente.setNomeClienteMaior(resultSet.getString("Nome_Cliente"));
			cliente.setQuantidadeComprada(resultSet.getInt("Quantidade"));
			cliente.setValorMaior(resultSet.getInt("relatorios"));
		}

		return cliente;

	}

}
