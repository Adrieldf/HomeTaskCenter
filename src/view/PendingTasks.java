package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JButton;

public class PendingTasks extends JPanel{
	private JTable tabTasks;
	public PendingTasks() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lbTitle = new JLabel("Tarefas Pendentes");
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lbTitle = new GridBagConstraints();
		gbc_lbTitle.gridwidth = 11;
		gbc_lbTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lbTitle.gridx = 0;
		gbc_lbTitle.gridy = 0;
		add(lbTitle, gbc_lbTitle);
		
		tabTasks = new JTable();
		GridBagConstraints gbc_tabTasks = new GridBagConstraints();
		gbc_tabTasks.gridheight = 6;
		gbc_tabTasks.gridwidth = 8;
		gbc_tabTasks.insets = new Insets(0, 0, 5, 5);
		gbc_tabTasks.fill = GridBagConstraints.BOTH;
		gbc_tabTasks.gridx = 1;
		gbc_tabTasks.gridy = 2;
		add(tabTasks, gbc_tabTasks);
		
		JButton btnCreateTask = new JButton("Criar Tarefa");
		GridBagConstraints gbc_btnCreateTask = new GridBagConstraints();
		gbc_btnCreateTask.gridwidth = 3;
		gbc_btnCreateTask.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateTask.gridx = 1;
		gbc_btnCreateTask.gridy = 9;
		add(btnCreateTask, gbc_btnCreateTask);
	}

}
