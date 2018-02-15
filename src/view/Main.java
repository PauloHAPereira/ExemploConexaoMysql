package view;

import java.util.Scanner;

import control.ControlerMain;
/**
 * 
 * @author Paulo Pereira
 *
 */
public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int 	opcao;				//opção do menu
		boolean condicao = true;	//condição para sair do programa
		ControlerMain controleMain = new ControlerMain();
		
		while(condicao){
			System.out.println("Selecione uma opção: ");
			System.out.println("1 Cadastrar novo aluno"
					+ "\n2 Editar aluno" + "\n3 Excluir aluno" + "\n4 Listar todos os alunos" + "\n5 Sair");
			opcao = scanner.nextInt();
			switch (opcao) {
			case 1:
				controleMain.cadastrarAluno();
				break;
			case 2:
				controleMain.editarAluno();
				break;
			case 3:
				controleMain.deletarAluno();
				break;
			case 4:
				System.out.println(controleMain.listarAluno());
				break;
			case 5:
				condicao = false;
				break;
			
			default:
				System.out.println("Entre com uma opção valida");
				break;
			}
		}
	}

}
