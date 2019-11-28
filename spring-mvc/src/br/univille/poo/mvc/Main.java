package br.univille.poo.mvc;

import br.univille.poo.mvc.control.CadastroPessoaControl;
import br.univille.poo.mvc.model.PessoaModel;
import br.univille.poo.mvc.view.CadastroPessoaView;

public class Main {

	public static void main(String[] args) {
		PessoaModel p = new PessoaModel();
		p.setCpf("456.455.454-31");
		p.setEmail("fulano@gmail.com");
		p.setNome("Fulano");

		
		CadastroPessoaControl control = new CadastroPessoaControl(new CadastroPessoaView(),p);
		control.exibirTela();
	}

}
