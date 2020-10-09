package view;

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

//import view.InitialPage;
//import test.TestePanel;

public class InitialPage extends JFrame {

	protected static InitialPage INSTANCE;
	
	private JDesktopPane desktopPane;
	
	private JMenuBar menuBar_1;

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InitialPage f = InitialPage.getInstance();
				f.setVisible(true);
			}
		});
	}

	public static synchronized InitialPage getInstance(){
		if(INSTANCE==null) {
			INSTANCE = new InitialPage();
		}
		return (InitialPage)INSTANCE;
	}
	
	protected InitialPage() {
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

		buildMenuArchive(menuBar_1);
		buildMenuOptions(menuBar_1);
		
		
		showPanelFullScreen(new PendingTasks(), "Tarefas");
		
	}
	
	private void buildMenuArchive(JMenuBar menuBar) {
		JMenu mnArchive = new JMenu("Arquivo");
		menuBar.add(mnArchive);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mnArchive.add(mntmSair);
	}
	
	private void buildMenuOptions(JMenuBar menuBar) {
		JMenu mnOptions = new JMenu("Opções");
		menuBar.add(mnOptions);
		
		JMenuItem mntmTarefas = new JMenuItem("Visualizar Tarefas Pendentes");
		mntmTarefas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				showPanelFullScreen(new PendingTasks());
				showPanel(new PendingTasks(), "Tarefas Pendentes");
			}
		});
		mnOptions.add(mntmTarefas);
		
		// Segunda opcao
//		JMenuItem mntmTarefas2 = new JMenuItem("Tarefas 2");
//		mntmTarefas2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				showPanel(new TestePanel(), "Tarefas 2");
//			}
//		});
//		mnOptions.add(mntmTarefas2);
	}
	
	protected void showPanelFullScreen(JPanel panel, String title) {
		final JInternalFrame intFrame = new JInternalFrame(title, false, false, false, false);
		showPanel(panel, intFrame);
		if (intFrame.getSize().height != 0) {
			try {
				intFrame.setMaximum(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void showPanel(JPanel panel, String title) {
		final JInternalFrame intFrame = new JInternalFrame(title, true, true, true, true);
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
