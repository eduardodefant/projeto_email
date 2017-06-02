package unisep.main;

import unisep.vo.AlunoVO;

public class ListaAluno {

	private AlunoBO primeiroLista;
	private AlunoBO ultimoLista;
	private Integer tamanhoLista;

	public void adicionarNoComeco(AlunoVO aluno) {

		if (this.tamanhoLista == null || this.tamanhoLista == 0) {
			this.tamanhoLista = 0;
			AlunoBO novoAluno = new AlunoBO(aluno);

			this.primeiroLista = novoAluno;

		} else {
			AlunoBO novoAluno = new AlunoBO(aluno, this.primeiroLista);
			this.primeiroLista.setAlunoAnterior(novoAluno);
			this.primeiroLista = novoAluno;
		}
		this.tamanhoLista++;
	}

	public void adicionarNoFinal(AlunoVO aluno) {

	}

	public void adicionar(int posicao, AlunoVO aluno) {

		if(posicao == 0){
			//Adicionar no começo
			this.adicionarNoComeco(aluno);
		}else if(posicao == this.tamanhoLista){
			//Adicionar no final
			this.adicionar(aluno);
		}else{
			//Para a posição
			AlunoBO alunoAnterior = this.buscarAlunoBO(posicao-1);
			AlunoBO alunoProximo = alunoAnterior.getAlunoProximo();

			AlunoBO novoAluno = new AlunoBO(aluno, alunoProximo);
			novoAluno.setAlunoAnterior(alunoAnterior);
			alunoAnterior.setAlunoProximo(novoAluno);
			alunoProximo.setAlunoAnterior(novoAluno);
			this.tamanhoLista++;
		}

	}

	public void adicionar(AlunoVO aluno) {

		if (this.tamanhoLista == 0) {

			this.adicionarNoComeco(aluno);

		} else {

			AlunoBO novoAluno = new AlunoBO(aluno);

			this.ultimoLista.setAlunoProximo(novoAluno);
			novoAluno.setAlunoAnterior(this.ultimoLista);
			this.ultimoLista = novoAluno;
			this.tamanhoLista++;

		}

	}

	public void removerPosicao(int posicao) {

		if(!this.posicaoOcupada(posicao)){
			throw new IllegalArgumentException("Posição não existe !");
		}

		if(posicao == 0){
			this.removerDoComecao();
		}else if(posicao == this.tamanhoLista -1){
			this.removerDoFinal();
		}else{
			AlunoBO anterior = this.buscarAlunoBO(posicao - 1);
			AlunoBO atual = anterior.getAlunoProximo();
			AlunoBO proximo = atual.getAlunoProximo();

			anterior.setAlunoProximo(proximo);
			proximo.setAlunoAnterior(anterior);

			this.tamanhoLista--;
		}

	}

	public void removerDoComecao() {

		if(!this.posicaoOcupada(0)){
			throw new IllegalArgumentException("Posicao não existe ! ");
		}
		this.primeiroLista = this.primeiroLista.getAlunoProximo();
		this.primeiroLista.setAlunoAnterior(null);
		this.tamanhoLista--;

		if(this.tamanhoLista == 0){
			this.ultimoLista = null;
		}
	}

	public void removerDoFinal() {

		if(!this.posicaoOcupada(this.tamanhoLista -1)){
			throw new IllegalArgumentException("Posicao não existe ! ");
	}
		if(this.tamanhoLista == 1){
			this.removerDoComecao();
		}else{
			AlunoBO alunoAnterior = this.ultimoLista.getAlunoAnterior();
			alunoAnterior.setAlunoProximo(null);
			this.ultimoLista = alunoAnterior;
			this.tamanhoLista --;
		}
	}


	public boolean posicaoOcupada(int posicao) {

		return posicao >= 0 && posicao < this.tamanhoLista;

	}

	public AlunoVO buscarAluno(int posicao) {

		return this.buscarAlunoBO(posicao).getAlunoPosicao();
	}

	public AlunoBO buscarAlunoBO(int posicao) {

		if (!this.posicaoOcupada(posicao)) {
			// VAI ACIONAR UM EXCEPTION
			throw new IllegalArgumentException("Posicao não existe");
		}

		AlunoBO alunoAtual = primeiroLista;

		for (int i = 0; i < posicao; i++) {
			alunoAtual = alunoAtual.getAlunoProximo();

		}
		return alunoAtual;

	}

	public boolean contemAluno(AlunoVO aluno) {
		return false;
	}

	public int tamanho() {
		return this.tamanhoLista;
	}

}
