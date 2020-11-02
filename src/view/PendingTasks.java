package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import dao.ProductDAO;
import database.PostgresqlProductDB;
import model.Task;

//jPanel frame
public class PendingTasks extends JPanel {
	private JTable tabTasks;
	private JDesktopPane desktopPane;
	
	public PendingTasks(InitialPage iP) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0};
		gridBagLayout.rowHeights = new int[]{0, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lbTitle = new JLabel("Tarefas Pendentes");
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lbTitle = new GridBagConstraints();
		gbc_lbTitle.gridwidth = 15;
		gbc_lbTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lbTitle.gridx = 0;
		gbc_lbTitle.gridy = 0;
		add(lbTitle, gbc_lbTitle);
		
		tabTasks = new JTable();
		GridBagConstraints gbc_tabTasks = new GridBagConstraints();
		gbc_tabTasks.gridheight = 6;
		gbc_tabTasks.gridwidth = 13;
		gbc_tabTasks.insets = new Insets(0, 0, 5, 5);
		gbc_tabTasks.fill = GridBagConstraints.BOTH;
		gbc_tabTasks.gridx = 1;
		gbc_tabTasks.gridy = 2;
		add(tabTasks, gbc_tabTasks);
		
		JButton btnCreateTask = new JButton("Criar Tarefa");
		btnCreateTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCreateTask(iP);
			}
		});
		GridBagConstraints gbc_btnCreateTask = new GridBagConstraints();
		gbc_btnCreateTask.gridwidth = 13;
		gbc_btnCreateTask.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateTask.gridx = 1;
		gbc_btnCreateTask.gridy = 9;
		add(btnCreateTask, gbc_btnCreateTask);
	}
	
	void actionCreateTask(InitialPage initPage) {
		initPage.createInternalFrame(new CreateTask(), "Criar nova tarefa", 800, 600);
	}
	
	

}
