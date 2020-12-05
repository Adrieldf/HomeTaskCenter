package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

import dao.DAOFactory;
import database.PostgresqlDBFactory;
import model.User;

//import view.InitialPage;
//import test.TestePanel;

public class InitialPage extends JFrame {

	protected static InitialPage INSTANCE;

	private JDesktopPane desktopPane;

	private JMenuBar menuBar_1;

	private DAOFactory daoFact;

	private User user = null;

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InitialPage f = InitialPage.getInstance();
				f.setVisible(true);
			}
		});
	}

	public static InitialPage getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new InitialPage();
			INSTANCE.daoFact = new PostgresqlDBFactory();
		}
		return INSTANCE;
	}

	private InitialPage() {

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);

		buildMenuArchive(menuBar_1);
		buildMenuOptions(menuBar_1);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowActivated(e);
				initial();
			}
		});
	}

	private void initial() {
		showPanelFullScreen(new PendingTasks(user), "Home Task Center");

		// TODO: validar se o login foi realizado com sucesso para mostrar as tasks
		if (this.user == null)
			createInternalFrame(new LoginPage(user), "Home Task Center", 380, 350);
	}

	public DAOFactory getDaoFactory() {
		return this.daoFact;
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

		JMenu mnTasks = new JMenu("Tarefas");
		JMenu mnUsers = new JMenu("Usuários");
		JMenu mnItems = new JMenu("Itens");
		JMenu mnCategories = new JMenu("Categorias");

		menuBar.add(mnTasks);
		menuBar.add(mnUsers);
		menuBar.add(mnCategories);
		menuBar.add(mnItems);

		// Tarefas
		JMenuItem mntmTarefas = new JMenuItem("Visualizar Tarefas Pendentes");
		mntmTarefas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createInternalFrame(new PendingTasks(user), "Home Task Center", 800, 600);
			}
		});
		mnTasks.add(mntmTarefas);

		JMenuItem mntmCreateTask = new JMenuItem("Cadastro de Tarefas");
		mntmCreateTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg3) {
				createInternalFrame(new CreateTask(user), "Home Task Center", 500, 700);
			}
		});
		mnTasks.add(mntmCreateTask);

		// Usuários
		JMenuItem mntmUserEdit = new JMenuItem("Cadastro de Usuários");
		mntmUserEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				createInternalFrame(new UserEdit(user), "Home Task Center", 500, 380);
			}
		});
		mnUsers.add(mntmUserEdit);

		JMenuItem mntmFamilyRegistration = new JMenuItem("Cadastro de Família");
		mntmFamilyRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg4) {
				createInternalFrame(new FamilyRegistration(user), "Home Task Center", 600, 500);
			}
		});
		mnUsers.add(mntmFamilyRegistration);

		// Criar Itens
		JMenuItem mntmCreateItems = new JMenuItem("Cadastro de Itens");
		mntmCreateItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg5) {
				createInternalFrame(new CreateItems(user), "Home Task Center", 500, 450);
				// createIntFrame();
			}
		});
		mnItems.add(mntmCreateItems);

		// Categorias
		JMenuItem mntmCategoryRegistration = new JMenuItem("Cadastro de Categorias");
		mntmCategoryRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg2) {
				createInternalFrame(new CategoryRegistration(user), "Home Task Center", 600, 600);
			}
		});
		mnCategories.add(mntmCategoryRegistration);

	}

	// abrir janela irma, pelos filhos
	/*
	 * protected void showPanel2(JPanel panel, String title) { final JInternalFrame
	 * intFrame = new JInternalFrame(title, false, false, false, false);
	 * showPanel(panel, intFrame); }
	 */

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

//	protected void createIntFrame() {
//		new CreateItem();
//	}

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

		// cascade();
		int pos = desktopPane.getAllFrames().length * 25;
		intFrame.setLocation(pos, pos);

		try {
			intFrame.setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

	}

	public void enableMenu(boolean habilita) {
		int quantos = menuBar_1.getMenuCount();
		for (int i = 0; i < quantos; i++) {
			menuBar_1.getMenu(i).setEnabled(habilita);
		}
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return this.user;
	}
}
