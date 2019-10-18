package Swing;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;



public class Checkbox extends JFrame {
	
	public Checkbox() {
		setTitle("Interface Java Swing Pontos Cardeais");
		setSize(500,350);
		setLocation(1366/2 - 800/2,768/2 - 600/2);
		setResizable(false);
		setLayout();
	}
	
	private void setLayout() {
		
	JPanel norte = criarPanel(Color.GRAY,"Norte");
	JPanel oeste = criarPanel(Color.CYAN,"Oeste");
    JPanel sul = criarPanel(Color.MAGENTA,"Sul");
    JPanel centro = criarPanel(Color.GREEN,"Centro");
	JPanel leste = criarPanel(Color.WHITE,"Leste");
        
		
		JPanel panelesq = new JPanel();
		panelesq.setBorder(BorderFactory.createEmptyBorder(30,220,0,100));
		panelesq.setPreferredSize(new Dimension(350,550));
		
		JCheckBox nortebox = new JCheckBox();
		nortebox.setText(" NORTE");
		nortebox.setFont(new Font("Arial", Font.PLAIN, 40));
		nortebox.setPreferredSize(new Dimension(300,50));
		nortebox.setSelected(true);
		
		JCheckBox sulbox = new JCheckBox();
		sulbox.setText(" SUL");
		sulbox.setFont(new Font("Arial", Font.PLAIN, 40));
		sulbox.setPreferredSize(new Dimension(300,50));
		sulbox.setSelected(true);
		
		JCheckBox centrobox = new JCheckBox();
		centrobox.setText(" CENTRO");
		centrobox.setFont(new Font("Arial", Font.PLAIN, 40));
		centrobox.setPreferredSize(new Dimension(300,50));
		centrobox.setSelected(true);
		
		JCheckBox lestebox = new JCheckBox();
		lestebox.setText(" LESTE");
		lestebox.setFont(new Font("Arial", Font.PLAIN, 40));
		lestebox.setPreferredSize(new Dimension(300,50));
		lestebox.setSelected(true);
		
		JCheckBox oestebox = new JCheckBox();
		oestebox.setText(" OESTE");
		oestebox.setFont(new Font("Arial", Font.PLAIN, 40));
		oestebox.setPreferredSize(new Dimension(300,50));
		oestebox.setSelected(true);
		
		nortebox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				norte.setVisible(nortebox.isSelected());
				
			}
		});
		
		sulbox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sul.setVisible(sulbox.isSelected());
				
			}
		});
		
		centrobox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				centro.setVisible(centrobox.isSelected());
				
			}
		});
		
		lestebox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				leste.setVisible(lestebox.isSelected());
				
			}
		});
		
		oestebox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				oeste.setVisible(oestebox.isSelected());
				
			}
		});
		
		JPanel paneldir = new JPanel();
		paneldir.setPreferredSize(new Dimension(350,550));
		paneldir.setLayout(new BorderLayout());			
		paneldir.add(norte, BorderLayout.NORTH);
		paneldir.add(sul, BorderLayout.SOUTH);
		paneldir.add(leste, BorderLayout.EAST);
		paneldir.add(oeste, BorderLayout.WEST);
		paneldir.add(centro, BorderLayout.CENTER);
		
		
	JPanel root = new JPanel(new GridLayout(1, 2));
	
	root.add(panelesq);
	root.add(paneldir);
	
	add(root);

	panelesq.add(oestebox);
	panelesq.add(centrobox);
	panelesq.add(lestebox);
	panelesq.add(nortebox);
	panelesq.add(sulbox);
	}
	
	private JPanel criarPanel(Color color, String texto) {
    	JPanel panel = new JPanel();
    	panel.setBackground(color);
    	panel.add(new JLabel(texto));
    	// Configura um tamanho padrao do painel
    	return panel;
    }
		
		
}