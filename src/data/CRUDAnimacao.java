package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class CRUDAnimacao {
	
	Statement state;
	ResultSet resultset;
	Conexao conex = new Conexao();
	
	public ArrayList<String[]> retornaFrames(String nome) {
		String consulta = "SELECT caminho FROM tbframe "
				+ "INNER JOIN tbanimacao on tbframe.codAnimacao = tbanimacao.codAnimacao "
				+ "WHERE nomeAnimacao = '"+nome+"'";
		conex.conectar();
		ArrayList<String[]> str = new ArrayList<String[]>();
		
		try {
			state = (Statement) Conexao.con.createStatement();
			resultset = state.executeQuery(consulta);
			
			while(resultset.next()) {
				String linha[] = new String[1];
				linha[0] = resultset.getString(1);
				str.add(linha);
			}
			
		} catch (SQLException erro) {
			System.out.println("Não foi possível realizar a consulta");
		}

		conex.desconectar();
		return str;
	}

}
