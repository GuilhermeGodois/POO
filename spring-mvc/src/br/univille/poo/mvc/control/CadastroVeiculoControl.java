package br.univille.poo.mvc.control;

import br.univille.poo.mvc.model.VeiculoModel;
import br.univille.poo.mvc.view.CadastroVeiculoView;

public class CadastroVeiculoControl {
	
	private CadastroVeiculoView view;
	private VeiculoModel model;
	
	public CadastroVeiculoControl(CadastroVeiculoView view, VeiculoModel model) {
		this.view = view;
		this.model = model;
		model.attach(view);
		view.setModel(model);
		view.setControl(this);
	}
	
	public void exibirTela() {
		view.show();
		model.notifyObservers();
	}

	public void deletar() {
		model.deletar();
		view.setMensagemStatusBar("Registro deletado.");
		view.getBotaoDeletar().setEnabled(false);
	}

	public void novo() {
		model.novoRegistro();
		view.getBotaoDeletar().setEnabled(false);
		view.setMensagemStatusBar("Registro novo.");
	}
	
	public void salvar() {
		model.setPlaca(view.getPlaca());
		model.setMarca(view.getMarca());
		model.setNome(view.getNome());
		try {
			model.salvar();
			view.setMensagemStatusBar("Registro salvo com sucesso.");
			view.getBotaoDeletar().setEnabled(true);
		}catch(Exception e) {
			e.printStackTrace();
			view.setMensagemStatusBar("Erro: "+e.getMessage());
		}
	}

}
