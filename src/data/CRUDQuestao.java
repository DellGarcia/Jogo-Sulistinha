package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class CRUDQuestao {
	
	Statement state;

	ResultSet resultset;

	Conexao conex = new Conexao();
	
	public ArrayList<String[]> retornaQuestoes() {
		String sql = "select * from tbQuestao";

		conex.conectar();
		ArrayList<String[]> str = new ArrayList<String[]>();
		
		try {
			state = (Statement) Conexao.con.createStatement();
			resultset = state.executeQuery(sql);
			
			while(resultset.next()) {
				String linha[] = new String[6];
				linha[0] = resultset.getString(1);
				linha[1] = resultset.getString(2);
				linha[2] = resultset.getString(3);
				linha[3] = resultset.getString(4);
				linha[4] = resultset.getString(5);
				linha[5] = resultset.getString(6);
				str.add(linha);
			}
			
		} catch (SQLException erro) {
			System.out.println("Não foi possível realizar a consulta");
		}

		conex.desconectar();
		return str;
	}
	
	public void insereQuestao(String pergunta, String correta, String errada[]) {
		
		
		String sql = "insert into tbQuestao(pergunta, correta, errada1, errada2, errada3)"+
						"values('" + pergunta + "', '" + correta + "', '" + errada[0] + "', '" + errada[1] + "', '" + errada[2] + "')";

		conex.conectar();
		
		try {
			state = (Statement) Conexao.con.createStatement();
			state.execute(sql);
			
		} catch (SQLException erro) {
			System.out.println("Problema ao tentar inserir");
		}

		conex.desconectar();
	}

	public void deletarQuestao(int idQuestao) {
		
		
		String sql = "delete from tbQuestao "
					+ "where idQuestao = " + idQuestao;

		conex.conectar();
		
		try {
			state = (Statement) Conexao.con.createStatement();
			state.execute(sql);
			
		} catch (SQLException erro) {
			System.out.println("Problema ao tentar excluir");
		}

		conex.desconectar();
	}

	public void alterarQuestao(int idQuestao, String pergunta, String correta, String errada[]) {
		String sql = "UPDATE tbQuestao"
				+ " set pergunta = '" + pergunta + "', correta = '" + correta + "', errada1 = '" + errada[0] + "', errada2 = '" + errada[1] + "', errada3 = '" + errada[2] + "'" +
						" where idQuestao = '" + idQuestao + "'";

		conex.conectar();
		
		try {
			state = (Statement) Conexao.con.createStatement();
			state.execute(sql);
		} catch (SQLException erro) {
			System.out.println("Problema ao tentar alterar");
		}
	
		conex.desconectar();
	}
}
