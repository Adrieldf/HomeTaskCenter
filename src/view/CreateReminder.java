package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class CreateReminder extends JPanel {
	private JTextField tfTask;
	private JTextField tfTitleReminder;
	
	public CreateReminder() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 0, 30, 100, 100, 100, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30, 0, 0, 30, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel("Criar/editar lembrete");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 6;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		add(lblTitle, gbc_lblTitle);
		
		JLabel lblTask = new JLabel("Tarefa vinculada");
		lblTask.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblTask = new GridBagConstraints();
		gbc_lblTask.anchor = GridBagConstraints.WEST;
		gbc_lblTask.insets = new Insets(0, 0, 5, 5);
		gbc_lblTask.gridx = 1;
		gbc_lblTask.gridy = 2;
		add(lblTask, gbc_lblTask);
		
		tfTask = new JTextField();
		tfTask.setEnabled(false);
		tfTask.setEditable(false);
		GridBagConstraints gbc_tfTask = new GridBagConstraints();
		gbc_tfTask.gridwidth = 3;
		gbc_tfTask.insets = new Insets(0, 0, 5, 5);
		gbc_tfTask.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTask.gridx = 3;
		gbc_tfTask.gridy = 2;
		add(tfTask, gbc_tfTask);
		tfTask.setColumns(10);
		
		JLabel lblTitleReminder = new JLabel("Nome");
		lblTitleReminder.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblTitleReminder = new GridBagConstraints();
		gbc_lblTitleReminder.anchor = GridBagConstraints.WEST;
		gbc_lblTitleReminder.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitleReminder.gridx = 1;
		gbc_lblTitleReminder.gridy = 4;
		add(lblTitleReminder, gbc_lblTitleReminder);
		
		tfTitleReminder = new JTextField();
		GridBagConstraints gbc_tfTitleReminder = new GridBagConstraints();
		gbc_tfTitleReminder.gridwidth = 3;
		gbc_tfTitleReminder.insets = new Insets(0, 0, 5, 5);
		gbc_tfTitleReminder.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTitleReminder.gridx = 3;
		gbc_tfTitleReminder.gridy = 4;
		add(tfTitleReminder, gbc_tfTitleReminder);
		tfTitleReminder.setColumns(10);
		
		JLabel lblDescription = new JLabel("Descri\u00E7\u00E3o");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.WEST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 1;
		gbc_lblDescription.gridy = 6;
		add(lblDescription, gbc_lblDescription);
		
		JTextArea taDescription = new JTextArea();
		GridBagConstraints gbc_taDescription = new GridBagConstraints();
		gbc_taDescription.gridheight = 3;
		gbc_taDescription.gridwidth = 3;
		gbc_taDescription.insets = new Insets(0, 0, 5, 5);
		gbc_taDescription.fill = GridBagConstraints.BOTH;
		gbc_taDescription.gridx = 3;
		gbc_taDescription.gridy = 6;
		add(taDescription, gbc_taDescription);
		
		JButton btnCreateReminder = new JButton("Criar lembrete");
		GridBagConstraints gbc_btnCreateReminder = new GridBagConstraints();
		gbc_btnCreateReminder.insets = new Insets(0, 0, 0, 5);
		gbc_btnCreateReminder.gridx = 3;
		gbc_btnCreateReminder.gridy = 10;
		add(btnCreateReminder, gbc_btnCreateReminder);
		
		JButton btnUpdateReminder = new JButton("Alterar");
		GridBagConstraints gbc_btnUpdateReminder = new GridBagConstraints();
		gbc_btnUpdateReminder.anchor = GridBagConstraints.EAST;
		gbc_btnUpdateReminder.insets = new Insets(0, 0, 0, 5);
		gbc_btnUpdateReminder.gridx = 4;
		gbc_btnUpdateReminder.gridy = 10;
		add(btnUpdateReminder, gbc_btnUpdateReminder);
		
		JButton btnDeleteReminder = new JButton("Excluir\r\n");
		GridBagConstraints gbc_btnDeleteReminder = new GridBagConstraints();
		gbc_btnDeleteReminder.insets = new Insets(0, 0, 0, 5);
		gbc_btnDeleteReminder.anchor = GridBagConstraints.EAST;
		gbc_btnDeleteReminder.gridx = 5;
		gbc_btnDeleteReminder.gridy = 10;
		add(btnDeleteReminder, gbc_btnDeleteReminder);
	}
	
	

}
