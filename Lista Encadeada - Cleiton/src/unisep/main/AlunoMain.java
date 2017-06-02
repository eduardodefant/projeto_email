package unisep.main;

import unisep.vo.AlunoVO;

public class AlunoMain {

	public static void main(String[] args) {

		ListaAluno lista = new ListaAluno();

		AlunoVO aluno = new AlunoVO("João", 7);

		lista.adicionarNoComeco(aluno);
		lista.adicionarNoComeco(new AlunoVO("Paulo", 12));
		lista.adicionar(1, new AlunoVO("posicao-1", 1010));

		lista.removerDoComecao();

		for (int i = 0; i < lista.tamanho(); i++) {

			AlunoBO alunoBO = lista.buscarAlunoBO(i);

			if (i <= 0) {
				System.out.println("Posicao inicial <-- " + "<-- "
						+ alunoBO.getAlunoPosicao().getNome()
						+ "-->"
						+ alunoBO.getAlunoProximo().getAlunoPosicao().getNome());

			} else if (i == lista.tamanho() - 1) {
				System.out.println(alunoBO.getAlunoAnterior().getAlunoPosicao().getNome()
						+ " <-- "
						+ alunoBO.getAlunoPosicao().getNome() + "-->" + "Posicao final ");

			} else {
				System.out.println(alunoBO.getAlunoAnterior().getAlunoPosicao().getNome()
						+ "<-- "
						+ alunoBO.getAlunoPosicao().getNome() + "-->"
						+ alunoBO.getAlunoProximo().getAlunoPosicao().getNome());

			}

		}

	}

}
