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

import javafx.scene.control.ComboBox;

import javax.swing.JComboBox;

public class Menu {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Conversor ");
		frame.setSize(450,400);
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
		
		JMenu menuConfigs = new JMenu("ConfiguraÃ§oes");
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
		panel.setBackground(Color.white);
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(20, 20, 20, 20)
			   ,BorderFactory.createTitledBorder("Moedas")));
		String origem [] = {"Reais","Dolares","Euros"};
		JComboBox<String> comboBoxOrigem = new JComboBox<String>(origem);
		comboBoxOrigem.setBounds(80, 65, 100, 30);
		
		String destino [] = {"Reais","Dolares","Euros"};
		JComboBox<String> comboBoxDestino = new JComboBox<String>(destino);
		comboBoxDestino.setBounds(300, 65, 100, 30);
		
		JLabel lblorigem = new JLabel("De: ");
		lblorigem.setForeground(Color.BLACK);
		lblorigem.setBounds(35, 65, 80, 30);
		
		JTextField txtorigem = new JTextField(200);
		txtorigem.setBounds(80, 125, 100, 30);
		  
		JLabel lbldestino = new JLabel("Para: ");
		lbldestino.setForeground(Color.BLACK);
		lbldestino.setBounds(245, 65, 80, 30);
		
		JTextField txtdestino = new JTextField(200);
		txtdestino.setBounds(300, 125, 100, 30);
		txtdestino.setEditable(false);
					
		JButton bttnconverter = new JButton("Converter!!");
		bttnconverter.setBounds(300, 185, 100, 30);
		
		bttnconverter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String moedade = (String) comboBoxOrigem.getSelectedItem();
				String moedapara = (String) comboBoxDestino.getSelectedItem();
				
				double valorde = Double.parseDouble(txtorigem.getText());
				double valorpara = 0;
					
				if(moedade.equals("Reais")&& moedapara.equals("Dolares")) {
					valorpara = valorde / 3.99;
				}
				
				if(moedade.equals("Dolares")&& moedapara.equals("Reais")) {
					valorpara = valorde * 3.99;
				}
				
				if(moedade.equals("Reais")&& moedapara.equals("Euros")) {
					valorpara = valorde / 4.47;
				}
				
				if(moedade.equals("Euros")&& moedapara.equals("Reais")) {
					valorpara = valorde * 4.47;
				}
				
				if(moedade.equals("Dolares")&& moedapara.equals("Euros")) {
					valorpara = valorde / 1.12;
				}
				
				if(moedade.equals("Euros")&& moedapara.equals("Dolares")) {
					valorpara = valorde * 1.12;
				}
				
				txtdestino.setText(String.format("%.2f", valorpara));		
				
			}
		});
		
		panel.add(lblorigem);
		panel.add(lbldestino);
		panel.add(comboBoxOrigem);
		panel.add(comboBoxDestino);
		panel.add(txtorigem);
		panel.add(txtdestino);
		panel.add(bttnconverter);
				
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
			   ,BorderFactory.createTitledBorder("Temperaturas")));
		
		String origem [] = {"Celsius","Fahrenheit","Kelvin"};
		
		JComboBox<String> comboBoxOrigem = new JComboBox<String>(origem);
		comboBoxOrigem.setBounds(80, 65, 100, 30);

				
		String destino [] = {"Celsius","Fahrenheit","Kelvin"};
				
		JComboBox<String> comboBoxDestino = new JComboBox<String>(destino);
		comboBoxDestino.setBounds(300, 65, 100, 30);

		
		JLabel lblorigem = new JLabel("De: ");
		lblorigem.setForeground(Color.BLACK);
		lblorigem.setBounds(35, 65, 80, 30);
		
		JTextField txtorigem = new JTextField(200);
		txtorigem.setBounds(80, 125, 100, 30);
		  
		JLabel lbldestino = new JLabel("Para: ");
		lbldestino.setForeground(Color.BLACK);
		lbldestino.setBounds(245, 65, 80, 30);
		
		JTextField txtdestino = new JTextField(200);
		txtdestino.setBounds(300, 125, 100, 30);
		txtdestino.setEditable(false);
					
		JButton bttnconverter = new JButton("Converter!!");
		bttnconverter.setBounds(300, 185, 100, 30);
		
		// Ação do Botão Converter
		
		bttnconverter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String moedade = (String) comboBoxOrigem.getSelectedItem();
				String moedapara = (String) comboBoxDestino.getSelectedItem();
				
				double valorde = Double.parseDouble(txtorigem.getText());
				double valorpara = 0;
					
				if(moedade.equals("Celsius")&& moedapara.equals("Fahrenheit")) {
					valorpara = (valorde * 9.0/5.0) + 32.0;
				}
				
				if(moedade.equals("Fahrenheit")&& moedapara.equals("Celsius")) {
					valorpara = (valorde - 32.0) * 5.0/9.0;
				}
				
				if(moedade.equals("Celsius")&& moedapara.equals("Kelvin")) {
					valorpara = valorde + 273.15;
				}
				
				if(moedade.equals("Kelvin")&& moedapara.equals("Celsius")) {
					valorpara = valorde - 273.15;
				}
				
				if(moedade.equals("Fahrenheit")&& moedapara.equals("Kelvin")) {
					valorpara = (valorde - 32.0) * 5.0/9.0 + 273.15;
				}
				
				if(moedade.equals("Kelvin")&& moedapara.equals("Fahrenheit")) {
					valorpara = (valorde - 273.15) * 9.0/5.0 + 32;
				}
				
				txtdestino.setText(String.format("%.2f", valorpara));		
				
			}
		});
		
		panel.add(lblorigem);
		panel.add(lbldestino);
		panel.add(comboBoxOrigem);
		panel.add(comboBoxDestino);
		panel.add(txtorigem);
		panel.add(txtdestino);
		panel.add(bttnconverter);				
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
		
		String origem [] = {"quilômetro","metro","centímetro","milímetro"};
		
		JComboBox<String> comboBoxOrigem = new JComboBox<String>(origem);
		comboBoxOrigem.setBounds(80, 65, 100, 30);
		// comboBoxOrigem.setSelectedIndex(-1);
						
		// Fim Bloco JComboBox Comprimento Origem  
		
		// Início Bloco JComboBox Comprimento Destino
				
		String destino [] = {"quilômetro","metro","centímetro","milímetro"};
				
		JComboBox<String> comboBoxDestino = new JComboBox<String>(destino);
		comboBoxDestino.setBounds(300, 65, 100, 30);
		// comboBoxDestino.setSelectedIndex(-1);
							
		// Fim Bloco JComboBox Comprimento Destino 
		
		JLabel lblorigem = new JLabel("De: ");
		lblorigem.setForeground(Color.BLACK);
		lblorigem.setBounds(35, 65, 80, 30);
		
		JTextField txtorigem = new JTextField(200);
		txtorigem.setBounds(80, 125, 100, 30);
		  
		JLabel lbldestino = new JLabel("Para: ");
		lbldestino.setForeground(Color.BLACK);
		lbldestino.setBounds(245, 65, 80, 30);
		
		JTextField txtdestino = new JTextField(200);
		txtdestino.setBounds(300, 125, 100, 30);
		txtdestino.setEditable(false);
					
		JButton bttnconverter = new JButton("Converter!!");
		bttnconverter.setBounds(300, 185, 100, 30);
		
		// Ação do Botão Converter
		
		bttnconverter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String moedade = (String) comboBoxOrigem.getSelectedItem();
				String moedapara = (String) comboBoxDestino.getSelectedItem();
				
				double valorde = Double.parseDouble(txtorigem.getText());
				double valorpara = 0;
					
				if(moedade.equals("quilômetro")&& moedapara.equals("metro")) {
					valorpara = valorde * 1000;
				}
				
				if(moedade.equals("metro")&& moedapara.equals("quilômetro")) {
					valorpara = valorde / 1000;
				}
				
				if(moedade.equals("quilômetro")&& moedapara.equals("centímetro")) {
					valorpara = valorde * 100000;
				}
				
				if(moedade.equals("centímetro")&& moedapara.equals("quilômetro")) {
					valorpara = valorde / 100000;
				}
				
				if(moedade.equals("quilômetro")&& moedapara.equals("milímetro")) {
					valorpara = valorde * 1000000;
				}
				
				if(moedade.equals("milímetro")&& moedapara.equals("quilômetro")) {
					valorpara = valorde / 1000000;
				}
				
				if(moedade.equals("metro")&& moedapara.equals("centímetro")) {
					valorpara = valorde * 100;
				}
				
				if(moedade.equals("centímetro")&& moedapara.equals("metro")) {
					valorpara = valorde / 100;
				}
				
				if(moedade.equals("metro")&& moedapara.equals("milímetro")) {
					valorpara = valorde * 1000;
				}
				
				if(moedade.equals("milímetro")&& moedapara.equals("metro")) {
					valorpara = valorde / 1000;
				}
				
				if(moedade.equals("centímetro")&& moedapara.equals("milímetro")) {
					valorpara = valorde * 10;
				}
				
				if(moedade.equals("milímetro")&& moedapara.equals("centímetro")) {
					valorpara = valorde / 10;
				}
				
				txtdestino.setText(String.format("%.2f", valorpara));		
				
			}
		});
		
		// Fim Ação Botão Converter
		
		// Adiciona os itens no frame
		panel.add(lblorigem);
		panel.add(lbldestino);
		panel.add(comboBoxOrigem);
		panel.add(comboBoxDestino);
		panel.add(txtorigem);
		panel.add(txtdestino);
		panel.add(bttnconverter);
				
				//Adiciona o painel no frame
				return(panel);
}
}


