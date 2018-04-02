package br.ufsc.dsoii.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.ufsc.dsoii.connector.ConectaBD;
import br.ufsc.dsoii.model.Acao;

public class AcaoDaoImp implements AcaoDao{
	
	private ConectaBD conexao;
	private PreparedStatement ps = null;
	
	public AcaoDaoImp() {
			conexao = new ConectaBD();
	}

	@Override
	public void create(Acao a) {
		String nome = a.getNome();
		String nomeEmpresa = a.getNomeEmpresa();
		Double valor = a.getValor();
		String sql = "INSERT into acao (nome, nomeempresa, valor) values (?, ?, ?)";
		try {
			Connection con = conexao.conexao();
			ps = con.prepareStatement(sql);
			ps.setObject(1, nome);
			ps.setObject(2, nomeEmpresa);
			ps.setObject(3, valor);
			ps.executeUpdate();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id FROM acao WHERE nome = " + "\'" + nome 	+ "\'");
			rs.next();
			a.setId(Long.parseLong(rs.getString(1)));
			con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void read(Acao object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Acao object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Acao object) {
		// TODO Auto-generated method stub
		
	}

}
