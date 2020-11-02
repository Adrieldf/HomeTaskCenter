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
		
		showPanelFullScreen(new PendingTasks(INSTANCE), "Tarefas Pendentes");			
		
		// TODO: validar se o login foi realizado com sucesso para mostrar as tasks
		createInternalFrame(new LoginPage(), "Login", 400, 300);
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
		
		// Primeira opção
		JMenuItem mntmTarefas = new JMenuItem("Visualizar Tarefas Pendentes");
		mntmTarefas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				showPanelFullScreen(new PendingTasks());
				createInternalFrame(new PendingTasks(INSTANCE), "Tarefas Pendentes", 800, 600);
			}
		});
		mnOptions.add(mntmTarefas);
		
		// Segunda opção
		JMenuItem mntmUserEdit = new JMenuItem("Criar/editar usuário");
		mntmUserEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				createInternalFrame(new UserEdit(), "Criar/editar usuário", 400, 300);
			}
		});
		mnOptions.add(mntmUserEdit);
		
		// Terceira opção
		JMenuItem mntmCategoryRegistration = new JMenuItem("Criar/editar categoria");
		mntmCategoryRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg2) {
				createInternalFrame(new CategoryRegistration(), "Criar/editar categoria", 600, 600);
			}
		});
		mnOptions.add(mntmCategoryRegistration);
		
		// Quarta opção
		JMenuItem mntmCreateTask = new JMenuItem("Criar/editar tarefa");
		mntmCreateTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg3) {
				createInternalFrame(new CreateTask(), "Criar/editar tarefa", 500, 550);
			}
		});
		mnOptions.add(mntmCreateTask);
		
		// Quinta opção
		JMenuItem mntmFamilyRegistration = new JMenuItem("Criar/editar família");
		mntmFamilyRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg4) {
				createInternalFrame(new FamilyRegistration(), "Criar/editar família", 600, 400);
			}
		});
		mnOptions.add(mntmFamilyRegistration);
		
	}
	
	//abrir janela irma, pelos filhos
	/*
	protected void showPanel2(JPanel panel, String title) {
		final JInternalFrame intFrame = new JInternalFrame(title, false, false, false, false);
		showPanel(panel, intFrame);
	}*/
	
	
	protected void showPanelFullScreen(JPanel panel, String title) {
		final JInternalFrame intFrame = new JInternalFrame(title, false, false, false, false);
		showPanel(panel, intFrame, 800, 600);
		if (intFrame.getSize().height != 0) {
			try {
				intFrame.setMaximum(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void createInternalFrame(JPanel panel, String title, Integer width, Integer height) {
		final JInternalFrame intFrame = new JInternalFrame(title, true, true, true, true);
		showPanel(panel, intFrame, width, height);
	}
	
//	protected void showPanel(JPanel panel, final JInternalFrame intFrame) {
//		showPanel(panel, intFrame, 800, 600);
//	}
	
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
