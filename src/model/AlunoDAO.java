package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * 
 * @author Paulo Pereira
 *
 */
public class AlunoDAO {
	private Connection conexao;
	private PreparedStatement preparedStatement;
	private ResultSet resultado;
	ConecxaoDB conexaoDB = new ConecxaoDB();

	public void cadastrarAluno (Aluno aluno){

		try {
			//abre uma conexão com o banco
			conexao = conexaoDB.conectar();
			//adiciona uma query que sera enviada ao banco
			preparedStatement = conexao.prepareStatement("INSERT INTO ALUNO (NOME,IDADE,SEXO) VALUES (?,?,?)");
			preparedStatement.setString(1, aluno.getNome());
			preparedStatement.setInt(2, aluno.getIdade());
			preparedStatement.setBoolean(3, aluno.isSexo());
			//executa o update passando a query com os valores do aluno
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				//termina a conexão
				conexaoDB.desconectar(conexao, preparedStatement, resultado);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deletarAluno(String quem){
		try {
			//abre uma conexão com o banco
			conexao = conexaoDB.conectar();
			//adiciona uma query que sera enviada ao banco
			preparedStatement = conexao.prepareStatement("DELETE FROM ALUNO WHERE NOME=?");
			preparedStatement.setString(1, quem);
			//executa o update passando a query 
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				//termina a conexão
				conexaoDB.desconectar(conexao, preparedStatement, resultado);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public ArrayList<Aluno> listar(){
		ArrayList<Aluno> listaAlunos = new ArrayList<>();
		
		try {
			//abre uma conexão com o banco
			conexao = conexaoDB.conectar();
			//adiciona uma query que sera enviada ao banco
			preparedStatement = conexao.prepareStatement("SELECT * FROM ALUNO");
			//executo a query e guardo o resultado
			resultado = preparedStatement.executeQuery();
			while(resultado.next()){
				//enquanto houver alunos salve-os na lista de alundos 
				Aluno alunoDB = new Aluno();
				alunoDB.setNome(resultado.getString("nome"));
				alunoDB.setIdade(resultado.getInt("idade"));
				alunoDB.setSexo(resultado.getBoolean("sexo"));
				listaAlunos.add(alunoDB);
			}
			//retorna a lista de alunos
			return listaAlunos;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				//termina a conexão
				conexaoDB.desconectar(conexao, preparedStatement, resultado);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return listaAlunos;
	}
	
	public void editarAluno(String quem, Aluno aluno){
		
		try {
			//abre uma conexão com o banco
			conexao = conexaoDB.conectar();
			//adiciona uma query que sera enviada ao banco
			preparedStatement = conexao.prepareStatement("UPDATE ALUNO SET NOME=?, IDADE=?, SEXO=? WHERE NOME=?");
			preparedStatement.setString(1, aluno.getNome());
			preparedStatement.setInt(2, aluno.getIdade());
			preparedStatement.setBoolean(3, aluno.isSexo());
			preparedStatement.setString(4, quem);
			//executa o update passando a query com os valores do aluno
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				//fecha a conexão com o banco
				conexaoDB.desconectar(conexao, preparedStatement, resultado);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
