package br.univille.poo.mvc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.univille.poo.mvc.control.CadastroVeiculoControl;
import br.univille.poo.mvc.model.VeiculoModel;
import br.univille.poo.mvc.util.Observer;
import br.univille.poo.mvc.util.Subject;

public class CadastroVeiculoView extends JFrame implements Observer{

	private VeiculoModel model;
	private CadastroVeiculoControl control;
	
	private JTextField codigoTextField;
	private JTextField nomeTextField;
	private JTextField marcaTextField;
	private JTextField placaTextField;
	private JButton    salvarButton;
	private JButton    cancelarButton;
	private JButton    novoButton;
	private JButton    deletarButton;
	private JLabel statusLabel;
	
	public CadastroVeiculoView() {
		setSize(400,280);
		setTitle("Cadastro de Veiculo");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildLayout();
	}
	
	public void setModel(VeiculoModel model) {
		this.model = model;
	}
	
	public void setControl(CadastroVeiculoControl control) {
		this.control = control;
	}

	private void buildLayout() {
		JPanel root = new JPanel();
		root.setLayout(new BorderLayout());
		
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setBorder(BorderFactory.createCompoundBorder(
				
				  BorderFactory.createEmptyBorder(20, 20, 0, 20)
				, BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Detalhes da Pessoa")
						,BorderFactory.createEmptyBorder(10, 10, 10, 10))));

		codigoTextField = new JTextField(20);
		codigoTextField.setEnabled(false);
		nomeTextField = new JTextField(20);
		marcaTextField = new JTextField(20);
		placaTextField = new JTextField(20);
		
		salvarButton = new JButton("Salvar");
		salvarButton.setToolTipText("Salvar as alteracoes");
		salvarButton.addActionListener(e -> salvar());
		
		cancelarButton = new JButton("Cancelar");
		novoButton = new JButton("Novo");
		novoButton.setToolTipText("Criar novo registro de veiculo");
		novoButton.addActionListener(e -> novo());
		deletarButton = new JButton("Deletar");
		deletarButton.setToolTipText("Excluir registro de veiculo");
		deletarButton.setEnabled(true);
		deletarButton.addActionListener(e -> deletar());
		
		
		JLabel l = new JLabel("codigo",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(60,16));
		panel.add(l);
		panel.add(codigoTextField);
		
		l = new JLabel("Nome",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(60,16));
		panel.add(l);
		panel.add(nomeTextField);
		l = new JLabel("Marca",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(60,16));
		panel.add(l);
		panel.add(marcaTextField);
		l = new JLabel("Placa",JLabel.RIGHT);
		l.setPreferredSize(new Dimension(60,16));
		panel.add(l);
		panel.add(placaTextField);
		l = new JLabel();
		l.setPreferredSize(new Dimension(60,16));
		panel.add(l);
		panel.add(novoButton);
		panel.add(salvarButton);
		panel.add(deletarButton);
		
		JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		statusPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
		statusLabel = new JLabel("Cadastre um novo registro de veiculo");
		statusPanel.add(statusLabel);
		
		
		root.add(statusPanel,BorderLayout.SOUTH);
		root.add(panel,BorderLayout.CENTER);
		
		add(root);
	}
	
	private void exibirDados() {
		codigoTextField.setText(Long.toString(model.getId()));
		nomeTextField.setText(model.getNome());
		placaTextField.setText(model.getPlaca());
		marcaTextField.setText(model.getMarca());
	}
	
	
	private void salvar() {
		control.salvar();
	}
	
	private void deletar() {
		control.deletar();
	}
	
	private void novo() {
		control.novo();
	}

	public JButton getBotaoDeletar() {
		return deletarButton;
	}

	public void setMensagemStatusBar(String text) {
		statusLabel.setText(text);
	}

	@Override
	public void update(Subject s, Object o) {
		model = (VeiculoModel) o;
		exibirDados();
	}
	
	public String getMarca() {
		return marcaTextField.getText();
	}
	
	public String getPlaca() {
		return placaTextField.getText();
	}
	
	public String getNome() {
		return nomeTextField.getText();
	}
	
}
