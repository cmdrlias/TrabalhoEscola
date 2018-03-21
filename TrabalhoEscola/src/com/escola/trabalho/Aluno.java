package com.escola.trabalho;

import java.util.*;

public class Aluno {
	Scanner read = new Scanner(System.in);
	
	private String TurmaAluno;
	private String Nome;
	private int Matricula;
	private float Nota01;
	private float Nota02;
	private float Nota03;
	public ArrayList<Integer> capacidade_turma = new ArrayList<Integer>();
	public ArrayList<Integer> qtd_turma = new ArrayList<Integer>();
	
	public Aluno() {}
	
	public void CadastrarAluno(ArrayList<Turma> turma) {
		System.out.printf("\nNome: ");
		setNome(read.nextLine());
		System.out.printf("\nMatrícula: ");
		setMatricula(read.nextInt());
		AdicionarAlunoTurma(turma);
	}
	
	public void AdicionarAlunoTurma(ArrayList<Turma> turma) {
		boolean opc_turma_value = false;
		do {
			System.out.printf("Selecionar turma: ");
			for(int i = 0; i < turma.size(); i++) {
				System.out.printf("\n" + (i + 1) + "." + turma.get(i).getNomeTurma());
				capacidade_turma.add(turma.get(i).getMaxAlunos());
				qtd_turma.add(turma.get(i).getQtdAlunos());
			}
			int opc_turma = read.nextInt();
			if (turma.get(opc_turma - 1).getQtdAlunos() < turma.get(opc_turma - 1).getMaxAlunos()) {
				setTurmaAluno(turma.get(opc_turma - 1).getNomeTurma());
				System.out.println("Aluno cadastrado na turma com sucesso!");
				Aluno_Turma(opc_turma);
				turma.get(opc_turma - 1).setQtdAlunos(turma.get(opc_turma - 1).getQtdAlunos() + 1);
				opc_turma_value = true;
			} else {
				System.out.println("Turma cheia!");
			}
			System.out.println("\n");
		} while (opc_turma_value == false);
	}
	
	public int Aluno_Turma(int turma) {
		return turma;
	}
	
	public void NotasAluno() {
		System.out.printf("\nNota de Matemática: ");
		setNota01(read.nextFloat());
		System.out.printf("\nNota de Português: ");
		setNota02(read.nextFloat());
		System.out.printf("\nNota de Ciências: ");
		setNota03(read.nextFloat());
		System.out.printf("\n\nMedia: " + CalcularMedia());
	}
	
	public float CalcularMedia() {
		return (getNota01() + getNota02() + getNota03()) / 3;
	}
	
	public String getTurmaAluno() {
		return TurmaAluno;
	}

	public void setTurmaAluno(String turmaAluno) {
		TurmaAluno = turmaAluno;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getMatricula() {
		return Matricula;
	}

	public void setMatricula(int matricula) {
		Matricula = matricula;
	}

	public float getNota01() {
		return Nota01;
	}

	public void setNota01(float nota01) {
		Nota01 = nota01;
	}

	public float getNota02() {
		return Nota02;
	}

	public void setNota02(float nota02) {
		Nota02 = nota02;
	}

	public float getNota03() {
		return Nota03;
	}

	public void setNota03(float nota03) {
		Nota03 = nota03;
	}
}
