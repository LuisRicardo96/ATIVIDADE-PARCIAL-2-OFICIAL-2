/*
	* < UNIME >
	* < B.S.I >
	* < PROGRAMAÇÃO ORIENTADA A OBJETOS 2 >
	* < PABLO ROXO >
	* < LUIS RICARDO SOUSA BORGES >
	*/

import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpresaRepositorio {
	private BD bd;

	public EmpresaRepositorio(BD bd) {
		this.bd = bd;
	}
	
	public void cadastrar(Empresa empresa) {
		String query = "INSERT INTO "
					 + "empresa "
					 + "(nome, bairro, cidade, endereco, profissao) "
					 + "VALUES "
					 + "('" + empresa.getNome() + "', "
					 + "'" + empresa.getBairro() + "', "
					 + "'" + empresa.getCidade() + "', "
					 + "'" + empresa.getEndereco() + "',"
		             + "'" + empresa.getProfissao() + "');";
		this.bd.executeUpdate(query);
	}
	
	public Empresa obter(int id) {
		String query = "SELECT * FROM empresa WHERE id = " + id + ";";
		ResultSet dados = this.bd.executeQuery(query);
		Empresa empresa = new Empresa();
		try {
			dados.next();
			empresa.setId(dados.getInt("id"));
			empresa.setNome(dados.getString("nome"));
			empresa.setCidade(dados.getString("cidade"));
			empresa.setBairro(dados.getString("bairro"));
			empresa.setEndereco(dados.getString("endereco"));
			empresa.setProfissao(dados.getString("profissao"));
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return empresa;
	}
	
	public ArrayList<Empresa> listar() {
		String query = "SELECT * FROM empresa;";
		ResultSet dados = this.bd.executeQuery(query);
		ArrayList<Empresa> Empresas = new ArrayList<>();
		try {
			while(dados.next()) {
				Empresa empresa = new Empresa();
				empresa.setId(dados.getInt("id"));
				empresa.setNome(dados.getString("nome"));
				empresa.setCidade(dados.getString("cidade"));
				empresa.setBairro(dados.getString("bairro"));
				empresa.setEndereco(dados.getString("endereco"));
				empresa.setProfissao(dados.getString("profissao"));
				Empresas.add(empresa);
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return Empresas;
	}

	public void excluir(int id) {
		String query = "DELETE FROM empresa WHERE id = " + id + ";";
		this.bd.executeUpdate(query);
	}

	public void editar(Empresa empresa) {
		String query = "UPDATE empresa SET "
				     + "nome = '" + empresa.getNome() + "', "
				     + "cidade = '" + empresa.getCidade() + "', "
				     + "bairro = '" + empresa.getBairro() + "', "
				     + "endereco = '" + empresa.getEndereco() + "', "
					 + "profissao = '" + empresa.getProfissao() + "' "
				     + "WHERE id = " + empresa.getId() + ";";
		this.bd.executeUpdate(query);
	}
}
