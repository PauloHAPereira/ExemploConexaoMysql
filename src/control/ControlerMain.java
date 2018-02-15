package control;

import java.util.ArrayList;
import java.util.Scanner;
import model.Aluno;
import model.AlunoDAO;
/**
 * 
 * @author Paulo Pereira
 *
 */
public class ControlerMain {
	private Scanner  scanner = new Scanner(System.in);
	private AlunoDAO alunoDAO = new AlunoDAO();
	ArrayList<Aluno> listaAluno = new ArrayList<>();
	private String 	 nome;
	private int 	 idade;
	private String	 sexo;
	
	public void cadastrarAluno(){
		System.out.println("Entre com os dados do aluno:");
		//cadastra um novo alundo
		alunoDAO.cadastrarAluno(coletarDadosAluno());
	}
	
	public void deletarAluno(){
		String quem;
		
		System.out.println("Entre com o nome do aluno que sera deletado: ");
		quem = scanner.next();
	
		if(alunoExiste(quem)){
			//se o aluno existir então podemos delea-lo
			alunoDAO.deletarAluno(quem);
		}
		
	}
	
	public void editarAluno(){
		String quem;
		
		System.out.println("Entre com o nome do aluno que sera editado: ");
		quem = scanner.next();
		System.out.println("Entre com os novos dados do Aluno");
		
		if(alunoExiste(quem)){
			//se o aluno existe então podemos deleta-lo
			alunoDAO.editarAluno(quem,coletarDadosAluno());
		}
	}
	
	public String listarAluno(){
		String listaAlunos = "\n=====================";
		listaAluno.clear();
		listaAluno = alunoDAO.listar();
		
		//varre a lista vinda do BD e guarda os dados na String lista Alunos
		for (Aluno aluno : listaAluno) {
			listaAlunos += "\nNome: "  + aluno.getNome();
			listaAlunos += "\nIdade: " + aluno.getIdade();
			if(aluno.isSexo()){
				listaAlunos += "\nSexo: Masculino";
			}else{
				listaAlunos += "\nSexo: Feminino";
			}
			listaAlunos += "\n=====================";
		}
		
		return listaAlunos;
	}
	
	private boolean alunoExiste(String quem){
		
		listaAluno.clear();						//limpa a lista
		listaAluno = alunoDAO.listar(); 		//obtem uma nova lista do BD
		boolean alunoExiste = false;
		//varre a lista de aluno para verificar se o aluno esta cadastrado
		for (Aluno aluno : listaAluno) {
			if(aluno.getNome().equals(quem)){
				alunoExiste = true;
				break;
			}
		}
		return alunoExiste;
	}
	
	private Aluno coletarDadosAluno(){
		// este metodo coleta os dados do aluno e adiciona em u objeto do tipo aluno, o retornando ao final do método
		Aluno aluno;
		//Coletando os dados do aluno
		System.out.println("Nome do aluno: ");
		nome = scanner.next();
		System.out.println("Idade do aluno: ");
		idade = scanner.nextInt();
		System.out.println("Sexo do aluno (M/F): ");
		sexo = scanner.next();
		
		//verificando se a entrada foi para um homem ou mulher
		if(sexo.equals("M")||sexo.equals("m")){
			aluno = new Aluno(nome, idade, true);
		}else{
			aluno = new Aluno(nome, idade, false);
		}
		return aluno;
	}
}
