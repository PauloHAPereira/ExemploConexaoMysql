package model;
/**
 * 
 * @author Paulo Pereira
 *
 */
public class Aluno {
	
	private String 	nome;
	private int 	idade;
	private boolean sexo; //true = Homen, False = Mulher 
	
	//construtor generico
	public Aluno(){
		
	}
	//construtor completo
	public Aluno (String nome, int idade, boolean sexo){
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}
	
	//getters e setters dos atributos
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	
	
}
