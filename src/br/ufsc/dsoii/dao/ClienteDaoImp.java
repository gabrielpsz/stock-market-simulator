package br.ufsc.dsoii.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.ufsc.dsoii.connector.ConectaBD;
import br.ufsc.dsoii.model.Cliente;

public class ClienteDaoImp implements ClienteDao {

	private ConectaBD conexao;
	private PreparedStatement ps = null;
	
	public ClienteDaoImp() {
		// TODO Auto-generated constructor stub
		conexao = new ConectaBD();
	}

	@Override
	public void create(Cliente e) {
		String nome = e.getNome();
		String cpf = e.getCpf();
		String sql = "INSERT into cliente (nome,cpf) values (?,?)";
		try {
			Connection con = conexao.conexao();
			ps = con.prepareStatement(sql);
			ps.setObject(1, nome);
			ps.setObject(2, cpf);
			ps.executeUpdate();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id FROM cliente WHERE cpf = " + "\'" + cpf 	+ "\'");
			rs.next();
			e.setId(Long.parseLong(rs.getString(1)));
			con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void read(Cliente object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Cliente object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cliente object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente findByCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Cliente findById(Long id) {
		Cliente c = new Cliente();
		try {
			Connection con = conexao.conexao();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT id, nome, cpf FROM cliente WHERE id = "
							+ "\'" + id + "\'");
			while (rs.next()) {
				c.setId(rs.getLong(1));
				c.setNome(rs.getString(2));
				c.setCpf(rs.getString(3));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
}