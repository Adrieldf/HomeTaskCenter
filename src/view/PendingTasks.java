package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import dao.TaskDAO;
import model.Category;
import model.Task;
import model.User;
import view.tableModel.CategoryTableModel;
import view.tableModel.ItemTableModel;
import view.tableModel.TaskTableModel;

//jPanel frame
public class PendingTasks extends JPanel implements ActionListener{
	private JTable tabTasks;
	private JDesktopPane desktopPane;
	
	private JButton btnCreateTask;
	private JLabel lbTitle;
	private User user;
	
	private TaskDAO taskDAO = InitialPage.getInstance().getDaoFactory().getTaskDAO();
	private TaskTableModel model;
	
	public PendingTasks(User user) {
		this.user = user;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lbTitle = new JLabel("Tarefas Pendentes");
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lbTitle = new GridBagConstraints();
		gbc_lbTitle.gridwidth = 15;
		gbc_lbTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lbTitle.gridx = 0;
		gbc_lbTitle.gridy = 1;
		add(lbTitle, gbc_lbTitle);
		
		model = new TaskTableModel();
		tabTasks = new JTable(model);
		GridBagConstraints gbc_tabTasks = new GridBagConstraints();
		gbc_tabTasks.gridheight = 6;
		gbc_tabTasks.gridwidth = 13;
		gbc_tabTasks.insets = new Insets(0, 0, 5, 5);
		gbc_tabTasks.fill = GridBagConstraints.BOTH;
		gbc_tabTasks.gridx = 1;
		gbc_tabTasks.gridy = 3;
		add(tabTasks, gbc_tabTasks);
		
		btnCreateTask = new JButton("Criar Tarefa");
		btnCreateTask.addActionListener(this);
		GridBagConstraints gbc_btnCreateTask = new GridBagConstraints();
		gbc_btnCreateTask.gridwidth = 13;
		gbc_btnCreateTask.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateTask.gridx = 1;
		gbc_btnCreateTask.gridy = 10;
		add(btnCreateTask, gbc_btnCreateTask);
		
		popula();
	}


	private void popula() {
		// TODO Auto-generated method stub
//		for(Task tas : taskDAO.getAll(user.getIdFamily())) {
//			model.addTask(tas);
//		}
		//model.fireTableDataChanged();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==btnCreateTask) {
			actionCreateTask();
		}
	}
	
	void actionCreateTask() {
		InitialPage.getInstance().createInternalFrame(new CreateTask(user), "Criar nova tarefa", 800, 600);
	}

}
