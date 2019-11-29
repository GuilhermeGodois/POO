package br.univille.poo.mvc;

import br.univille.poo.mvc.control.CadastroVeiculoControl;
import br.univille.poo.mvc.model.VeiculoModel;
import br.univille.poo.mvc.view.CadastroVeiculoView;

public class Main {

	public static void main(String[] args) {
		VeiculoModel p = new VeiculoModel();
		p.setMarca("FIAT");
		p.setPlaca("985-HDFF");
		p.setNome("UNO");

		
		CadastroVeiculoControl control = new CadastroVeiculoControl(new CadastroVeiculoView(),p);
		control.exibirTela();
	}

}
