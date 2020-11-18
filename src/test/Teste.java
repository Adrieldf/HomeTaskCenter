package test;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.SwitchList;

public class Teste extends JFrame{

	private JPanel fundo;
	private SwitchList listaSelecao;
	
	public void init() {
		
		this.setTitle("Teste duas listas");
		this.setSize(300,200);
		
		this.fundo = new JPanel(new BorderLayout());
		
		this.listaSelecao = new SwitchList();
		this.fundo.add(this.listaSelecao);
		
		this.getContentPane().add(this.fundo);
		
	}
	
	public static void main(String[] args) {
		
		Teste t = new Teste();
		t.init();
		t.setVisible(true);
		
	}

}
