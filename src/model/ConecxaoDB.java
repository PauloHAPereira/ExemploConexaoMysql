package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * @author Paulo Pereira
 *
 */
public class ConecxaoDB {
	
	public Connection conectar () throws Exception{
		Class.forName(Constantes.DRIVER);
		Connection conexao = null;
		//abre uma conexão passando a URL do banco com seu nome e também o usuario e senha para login
		conexao = DriverManager.getConnection(Constantes.BD_URL +
				Constantes.BD_NOME , Constantes.BD_NOME_USUARIO,
				Constantes.BD_SENHA);
		return conexao;
	}
	
	public void desconectar (Connection conexao, PreparedStatement pStm, ResultSet resultado) throws SQLException{
		//termina a conexão
		if(resultado != null && pStm != null && conexao != null){
			resultado.close();
			pStm.close();
			conexao.close();
		}
	}
}
