package com.escola.trabalho;

import java.util.*;

public class Turma {
	Scanner read = new Scanner(System.in);
	
	private String NomeTurma;
	private String Turno;
	private String Periodo;
	private int QtdAlunos;
	private int MaxAlunos;
	public ArrayList<Aluno> aluno = new ArrayList<Aluno>();
	
	public Turma() {}
	
	public void CadastrarTurma() {
		System.out.printf("\nNome da turma: ");
		setNomeTurma(read.nextLine());
		System.out.printf("\nTurno: ");
		setTurno(read.nextLine());
		System.out.printf("\nPeríodo: ");
		setPeriodo(read.nextLine());
		System.out.printf("\nQuantidade máxima de alunos: ");
		setMaxAlunos(read.nextInt());
		System.out.printf("\nQuantidade atual de alunos: ");
		QtdAtualAlunos();
		VerificarQtdAlunos();
	}
	
	public boolean QtdAtualAlunos() {
		int temp = read.nextInt();
		if(temp <= getMaxAlunos()) {
			setQtdAlunos(temp);
			return true;
		} else {
			System.out.println("\nAtenção: Valor acima do máximo de alunos permitido!");
			return false;
		}
	}
	
	public void VerificarQtdAlunos() {
		if (getQtdAlunos() == getMaxAlunos()) {
			System.out.println("A quantidade máxima da turma foi atingida!");
		} else {
			System.out.println("Existem " + (getMaxAlunos() - getQtdAlunos()) + " vagas remanecentes na turma.");
		}
	}
	
	public String getTurno() {
		return Turno;
	}
	public void setTurno(String turno) {
		Turno = turno;
	}
	public String getPeriodo() {
		return Periodo;
	}
	public void setPeriodo(String periodo) {
		Periodo = periodo;
	}
	public int getQtdAlunos() {
		return QtdAlunos;
	}
	public void setQtdAlunos(int qtdAlunos) {
		QtdAlunos = qtdAlunos;
	}
	public int getMaxAlunos() {
		return MaxAlunos;
	}
	public void setMaxAlunos(int maxAlunos) {
		MaxAlunos = maxAlunos;
	}

	public String getNomeTurma() {
		return NomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		NomeTurma = nomeTurma;
	}
}
