package conversor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Menu {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Conversor ");
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		
		JPanel painel = new JPanel();
		
		JMenuBar menuBar = new JMenuBar();
		
		// Cria o menu Arquivo
		JMenu menuArquivo = new JMenu("Arquivo");
		menuArquivo.setMnemonic(KeyEvent.VK_A);
		JTabbedPane tabPane = new JTabbedPane();
		JPanel painelMoedas = CriarPainelMoeda();
		JPanel painelTemperatura = CriarPainelTemperatura();
		JPanel painelComprimento = CriarPainelComprimento();
		// Cria os itens do menu
		JMenuItem item = new JMenuItem("Sair",KeyEvent.VK_I);
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Fecha a tela
				//frame.setVisible(false);
				//frame.dispose();
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		menuArquivo.add(item);
		
		JMenu menuConfigs = new JMenu("Configura√ßoes");
		JMenuItem limpcamp = new JMenuItem("Limpar Campos",KeyEvent.VK_A);
		JCheckBoxMenuItem emoedas = new JCheckBoxMenuItem("Exibir Moedas");
		emoedas.setSelected(true);
		emoedas.addItemListener(new ItemListener() {
	
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (emoedas.isSelected()) {
					tabPane.addTab("Moeda",painelMoedas);
				}else {
					tabPane.remove(painelMoedas);
				}
			}
		});
		
		JCheckBoxMenuItem etemp = new JCheckBoxMenuItem("Exibir Temperatura");
		etemp.setSelected(true);
		etemp.addItemListener(new ItemListener() {
	
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (etemp.isSelected()) {
					tabPane.addTab("Temperatura",painelTemperatura);
				}else {
					tabPane.remove(painelTemperatura);
				}
			}
			
		});
		
		JCheckBoxMenuItem ecompri = new JCheckBoxMenuItem("Exibir Comprimento");
		ecompri.setSelected(true);
		ecompri.addItemListener(new ItemListener() {
	
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (ecompri.isSelected()) {
					tabPane.addTab("Comprimento",painelComprimento);
				}else {
					tabPane.remove(painelComprimento);
				}
			}
		});

		
		ImageIcon icon = new ImageIcon("assets/imgs/icone_folder.png");
		
		
		Color colors[] = {Color.WHITE,};
		
		tabPane.addTab("Moeda",painelMoedas);
		tabPane.addTab("Temperatura",painelTemperatura);
		tabPane.addTab("Comprimento",painelComprimento);
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		menuConfigs.add(limpcamp);
		menuConfigs.addSeparator();
		menuConfigs.add(emoedas);
		menuConfigs.add(etemp);
		menuConfigs.add(ecompri);
		JMenu menu2 = new JMenu("Ajuda");
		JMenuItem item5 = new JMenuItem("Desenvolvedor",KeyEvent.VK_S);
		JMenuItem item6 = new JMenuItem("Repositorio do Github",KeyEvent.VK_L);
		JMenuItem item7 = new JMenuItem("Sobre",KeyEvent.VK_O);
		menu2.add(item5);
		menu2.add(item6);
		menu2.add(item7);
		// Adicina o menu na barra
		menuBar.add(menuArquivo);
		menuBar.add(menuConfigs);
		menuBar.add(menu2);	
		//Adiciona Menu Bar
		frame.setJMenuBar(menuBar);
		// Adiciona o painel na janela
		frame.add(tabPane);

		
		frame.show();

	}
	private static JPanel CriarPainelMoeda() {
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
				JLabel label = new JLabel("Usu·rio:");
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
				return(panel);
}
	
	private static JPanel CriarPainelTemperatura() {
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
				JLabel label = new JLabel("Usu·rio:");
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
				return(panel);
}

	private static JPanel CriarPainelComprimento() {
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
				JLabel label = new JLabel("Usu·rio:");
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
				return(panel);
}
}

