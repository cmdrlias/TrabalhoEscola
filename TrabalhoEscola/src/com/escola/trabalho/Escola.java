package com.escola.trabalho;

import java.util.*;

public class Escola {
	Scanner read = new Scanner(System.in);
	
	private String NomeEscola;
	private String Telefone;
	private String Endereco;
	public ArrayList<Turma> turma = new ArrayList<Turma>();
	public ArrayList<Aluno> aluno = new ArrayList<Aluno>();
	
	public Escola() {}
	
	public void CadastrarEscola() {
		System.out.printf("\nNome da escola: ");
		setNomeEscola(read.nextLine());
		System.out.printf("\nTelefone: ");
		setTelefone(read.nextLine());
		System.out.printf("\nEndereço: ");
		setEndereco(read.nextLine());
		Menu();
	}
	
	public void Menu() {
		int resp = 0;
		do {
			System.out.println("\nO QUE DESEJA FAZER?\n\n"
					+ "1. Cadastrar Turma"
					+ "\n2. Cadastrar Aluno"
					+ "\n3. Exibir Turmas"
					+ "\n4. Exibir Alunos"
					+ "\n5. Trocar Aluno de Sala"
					+ "\n6. Sair");
			resp = read.nextInt();
			switch(resp) {
				case 1:
					CadastrarTurma();
					break;
				case 2:
					CadastrarAluno();
					break;
				case 3:
					ExibirTurmas();
					break;
				case 4:
					ExibirAlunos();
					break;
				case 5:
					TrocarTurmaAluno();
					break;
				case 6:
					System.out.println("Obrigado!");
					break;
				default:
					System.out.println("Opção inválida!");
					break;
			}
		} while (resp != 6);
	}
	
	public void CadastrarTurma() {
		Turma t = new Turma();
		t.CadastrarTurma();
		turma.add(t);
	}
	
	public void CadastrarAluno() {
		Aluno a = new Aluno();
		a.CadastrarAluno(turma);
		aluno.add(a);
	}
	
	public void ExibirTurmas() {
		for(int i = 0; i < turma.size(); i++) {
			System.out.printf("\nNome da turma: " + turma.get(i).getNomeTurma());
			System.out.printf("\nTurno: " + turma.get(i).getTurno());
			System.out.printf("\nPeríodo: " + turma.get(i).getPeriodo());
			System.out.printf("\nQuantidade máxima de alunos: " + turma.get(i).getMaxAlunos());
			System.out.printf("\nQuantidade atual de alunos: " + turma.get(i).getQtdAlunos());
		}
	}
	
	public void ExibirAlunos() {
		for(int i = 0; i < aluno.size(); i++) {
			System.out.printf("\nNome: " + aluno.get(i).getNome());
			System.out.printf("\nMatrícula: " + aluno.get(i).getMatricula());
			System.out.printf("\nTurma: " + aluno.get(i).getTurmaAluno());
		}
	}
	
	public void TrocarTurmaAluno() {
		System.out.println("Selecione o aluno: ");
		for(int i = 0; i < aluno.size(); i++) {
			System.out.printf("\nMatrícula: " + aluno.get(i).getMatricula() + "\tNome: " 
											+ aluno.get(i).getNome());
		}
		int opc_aluno = read.nextInt();
		System.out.println("Selecione a turma: ");
		for(int i = 0; i < turma.size(); i++) {
			System.out.printf("\nNome da turma: " + turma.get(i).getNomeTurma() + 
						"\tTurno: " + turma.get(i).getTurno() + "\tPeríodo: " + turma.get(i).getPeriodo());
		}
		int opc_turma = read.nextInt();
		if (turma.get(opc_turma - 1).getQtdAlunos() < turma.get(opc_turma - 1).getMaxAlunos()) {
			aluno.get(opc_aluno - 1).setTurmaAluno(turma.get(opc_turma - 1).getNomeTurma());
			System.out.println("Aluno transferido para a turma com sucesso!");
			turma.get(opc_turma - 1).setQtdAlunos(turma.get(opc_turma - 1).getQtdAlunos() + 1);
		} else {
			System.out.println("Turma cheia!");
		}
	}
	
	public String getNomeEscola() {
		return NomeEscola;
	}
	public void setNomeEscola(String nomeEscola) {
		NomeEscola = nomeEscola;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
}
