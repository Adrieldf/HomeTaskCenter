package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends JFrame {

	protected static MainFrame INSTANCE;
	
	private JDesktopPane desktopPane;
	
	private JMenuBar menuBar_1;

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame f = MainFrame.getInstance();
				f.setVisible(true);
			}
		});
	}

	public static synchronized MainFrame getInstance(){
		if(INSTANCE==null) {
			INSTANCE = new MainFrame();
		}
		return (MainFrame)INSTANCE;
	}
	
	protected MainFrame() {
		desktopPane = new JDesktopPane() ;
		desktopPane.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);

		buildMenuArquivo(menuBar_1);
		buildMenuOpcoes(menuBar_1);
		
		
		showPanelFullScreen(new TestePanel(), "Tarefas");
		
	}
	
	private void buildMenuArquivo(JMenuBar menuBar) {
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mnArquivo.add(mntmSair);
	}
	
	
	private void buildMenuOpcoes(JMenuBar menuBar) {
		JMenu mnOpcoes = new JMenu("Opções");
		menuBar.add(mnOpcoes);
		
		JMenuItem mntmTarefas = new JMenuItem("Tarefas");
		mntmTarefas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				showPanelFullScreen(new TestePanel());
				showPanel(new TestePanel(), "Tarefas");
			}
		});
		mnOpcoes.add(mntmTarefas);
		
		JMenuItem mntmTarefas2 = new JMenuItem("Tarefas 2");
		mntmTarefas2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				showPanelFullScreen(new TestePanel());
				showPanel(new TestePanel(), "Tarefas 2");
			}
		});
		mnOpcoes.add(mntmTarefas2);
	}
	
	protected void showPanelFullScreen(JPanel panel, String titulo) {
		final JInternalFrame intFrame = new JInternalFrame(titulo, false, false, false, false);
		showPanel(panel, intFrame);
		if (intFrame.getSize().height != 0) {
			try {
				intFrame.setMaximum(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void showPanel(JPanel panel, String titulo) {
		final JInternalFrame intFrame = new JInternalFrame(titulo, true, true, true, true);
		showPanel(panel, intFrame);
	}
	
	protected void showPanel(JPanel panel, final JInternalFrame intFrame) {
		showPanel(panel, intFrame, 800, 600);
	}
	
	protected void showPanel(JPanel panel, final JInternalFrame intFrame, Integer width, Integer height) {
			
		intFrame.getContentPane().add(panel);
		intFrame.setName(panel.getName());
		
		Dimension d = new Dimension(width, height);
		intFrame.setMinimumSize(d);
		intFrame.setSize(d);
		desktopPane.add(intFrame);
		intFrame.setVisible(true);
		
		final JButton bt = new JButton(panel.getName());
		bt.addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					intFrame.setSelected(true);
					intFrame.setIcon(false);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});			
		
		//cascade();			
		int pos = desktopPane.getAllFrames().length * 25;
		intFrame.setLocation(pos, pos);
		
		try {
			intFrame.setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
