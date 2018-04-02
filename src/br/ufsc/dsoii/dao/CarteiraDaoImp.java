package br.ufsc.dsoii.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.ufsc.dsoii.connector.ConectaBD;
import br.ufsc.dsoii.model.Carteira;
import br.ufsc.dsoii.model.Cliente;

public class CarteiraDaoImp implements CarteiraDao {

	private ConectaBD conexao;
	private PreparedStatement ps = null;
	
	public CarteiraDaoImp() {
		conexao = new ConectaBD();
	}
	
	@Override
	public void create(Carteira c) {
		Double saldo = c.getSaldo();
		Cliente cliente = c.getCliente();
		String sql = "INSERT into carteira (saldo) values (?)";
		String sqlUpdateCliente = "UPDATE cliente SET fk_carteira = ? WHERE id = ?";
		try {
			Connection con = conexao.conexao();
			ps = con.prepareStatement(sql);
			ps.setObject(1, saldo);
			ps.executeUpdate();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id FROM carteira WHERE saldo = " + "\'" + saldo 	+ "\'");
			rs.next();
			c.setId(Long.parseLong(rs.getString(1)));
			ps = con.prepareStatement(sqlUpdateCliente);
			ps.setObject(1, c.getId());
			ps.setObject(2, cliente.getId());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void read(Carteira object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Carteira object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Carteira object) {
		// TODO Auto-generated method stub
		
	}

	

}
