package unisep.main;

import unisep.vo.AlunoVO;

public class AlunoBO {

	private AlunoVO alunoPosicao;

	private AlunoBO alunoAnterior;

	private AlunoBO alunoProximo;

	public AlunoVO getAlunoPosicao() {
		return alunoPosicao;
	}



	public void setAlunoPosicao(AlunoVO alunoPosicao) {
		this.alunoPosicao = alunoPosicao;
	}

	public AlunoBO getAlunoAnterior() {
		return alunoAnterior;
	}

	public void setAlunoAnterior(AlunoBO alunoAnterior) {
		this.alunoAnterior = alunoAnterior;
	}

	public AlunoBO getAlunoProximo() {
		return alunoProximo;
	}

	public void setAlunoProximo(AlunoBO alunoProximo) {
		this.alunoProximo = alunoProximo;
	}

	public AlunoBO(AlunoVO aluno, AlunoBO primeiroLista) {
		this.alunoPosicao = aluno;
		this.alunoProximo = primeiroLista;
	}

	public AlunoBO(AlunoVO aluno) {
		this.alunoPosicao = aluno;
	}

}
