package Swing;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class Login extends JFrame{
	public Login() {
		// Titulo da Janela
		setTitle("Usuario");
		// Tamanho da Janela
		setSize(350, 250);
		// Nao permite modificar o tamanho da Tela
		setResizable(false);
		// Configura a tela
		setLayout();
	}
	
	// Configura a tela
	private void setLayout() {
		JPanel panel = new JPanel();
		// Seleciona a cor do painel
		panel.setBackground(Color.white);
		// Retira o gerenciador de layout
		panel.setLayout(null);
		// Adiciona bordas
		panel.setBorder(BorderFactory.createCompoundBorder(
				// Margem
				BorderFactory.createEmptyBorder(20, 20, 20, 20)
				// Com titulo
			   ,BorderFactory.createTitledBorder("Login")));
		
				// Campo texto com 10 caracteres
				JTextField text = new JTextField(10);
				text.setBounds(140, 40, 125, 30);
				JTextField text2 = new JTextField(10);
				text2.setBounds(140, 80, 125, 30);
				JTextField text3 = new JTextField(10);
				text3.setBounds(140, 80, 125, 30);
				JLabel label = new JLabel("Usuário:");
				JLabel label2 = new JLabel("Senha:");
				JLabel label3 = new JLabel("Esqueci minha senha");
				
				
				
				// Adicionar Checkbox
				JTextArea textArea = new JTextArea();
				JCheckBox r1 = new JCheckBox("Manter acessado");
				r1.setBounds(140, 150, 125, 30);
				r1.setBackground(Color.white);
				
				// Cor do texto
				label.setForeground(Color.BLACK);
				label.setBounds(80, 40, 80, 30);
				label2.setForeground(Color.BLACK);
				label2.setBounds(80, 80, 80, 30);
				label3.setForeground(Color.decode("#800080"));
				label3.setBounds(150, 170, 125, 30);
				JButton button = new JButton("Acessar");
				button.setBounds(140, 120, 125, 30);
	
				// Adicionar componentes no painel
				panel.add(text);
				panel.add(text2);
				panel.add(button);
				panel.add(label);
				panel.add(label2);
				panel.add(label3);
				panel.add(r1);
				
				//Adiciona o painel no frame
				add(panel);
}

}
