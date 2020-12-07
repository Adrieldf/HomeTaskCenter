package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.ReminderDAO;
import model.Occurrence;
import model.Reminder;
import model.User;

public class EditReminder extends JPanel implements ActionListener {
	private JTextField tfTask;
	private JTextField tfTitleReminder;
	private JTextArea taDescription;
	private JButton btnCreateReminder, btnUpdateReminder, btnDeleteReminder;
	private JLabel lblDescription, lblTitleReminder, lblTitle, lblTask;
	private User user;
	
	public EditReminder(User user) {

		this.user = user;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths  = new int[]{30, 0, 30, 100, 100, 100, 30, 0};
		gridBagLayout.rowHeights    = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 0, 0, 30, 30, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights    = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblTitle = new JLabel("Editar Lembrete");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 6;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 1;
		add(lblTitle, gbc_lblTitle);
		
		lblTask = new JLabel("Tarefa vinculada");
		lblTask.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblTask = new GridBagConstraints();
		gbc_lblTask.anchor = GridBagConstraints.WEST;
		gbc_lblTask.insets = new Insets(0, 0, 5, 5);
		gbc_lblTask.gridx = 1;
		gbc_lblTask.gridy = 3;
		add(lblTask, gbc_lblTask);
		
		tfTask = new JTextField();
		tfTask.setEnabled(false);
		tfTask.setEditable(false);
		GridBagConstraints gbc_tfTask = new GridBagConstraints();
		gbc_tfTask.gridwidth = 3;
		gbc_tfTask.insets = new Insets(0, 0, 5, 5);
		gbc_tfTask.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTask.gridx = 3;
		gbc_tfTask.gridy = 3;
		add(tfTask, gbc_tfTask);
		tfTask.setColumns(10);
		
		lblTitleReminder = new JLabel("Nome");
		lblTitleReminder.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblTitleReminder = new GridBagConstraints();
		gbc_lblTitleReminder.anchor = GridBagConstraints.WEST;
		gbc_lblTitleReminder.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitleReminder.gridx = 1;
		gbc_lblTitleReminder.gridy = 5;
		add(lblTitleReminder, gbc_lblTitleReminder);
		
		tfTitleReminder = new JTextField();
		GridBagConstraints gbc_tfTitleReminder = new GridBagConstraints();
		gbc_tfTitleReminder.gridwidth = 3;
		gbc_tfTitleReminder.insets = new Insets(0, 0, 5, 5);
		gbc_tfTitleReminder.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTitleReminder.gridx = 3;
		gbc_tfTitleReminder.gridy = 5;
		add(tfTitleReminder, gbc_tfTitleReminder);
		tfTitleReminder.setColumns(10);
		
		lblDescription = new JLabel("Descri\u00E7\u00E3o");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.WEST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 1;
		gbc_lblDescription.gridy = 7;
		add(lblDescription, gbc_lblDescription);
		
		taDescription = new JTextArea();
		GridBagConstraints gbc_taDescription = new GridBagConstraints();
		gbc_taDescription.gridheight = 3;
		gbc_taDescription.gridwidth = 3;
		gbc_taDescription.insets = new Insets(0, 0, 5, 5);
		gbc_taDescription.fill = GridBagConstraints.BOTH;
		gbc_taDescription.gridx = 3;
		gbc_taDescription.gridy = 7;
		add(taDescription, gbc_taDescription);
		
//		btnCreateReminder = new JButton("Criar lembrete");
//		btnCreateReminder.addActionListener(this);
//		GridBagConstraints gbc_btnCreateReminder = new GridBagConstraints();
//		gbc_btnCreateReminder.insets = new Insets(0, 0, 5, 5);
//		gbc_btnCreateReminder.gridx = 3;
//		gbc_btnCreateReminder.gridy = 11;
//		add(btnCreateReminder, gbc_btnCreateReminder);
		
		btnUpdateReminder = new JButton("Alterar");
		btnUpdateReminder.addActionListener(this);
		GridBagConstraints gbc_btnUpdateReminder = new GridBagConstraints();
		gbc_btnUpdateReminder.gridwidth = 3;
		gbc_btnUpdateReminder.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdateReminder.gridx = 2;
		gbc_btnUpdateReminder.gridy = 11;
		add(btnUpdateReminder, gbc_btnUpdateReminder);
		
//		btnDeleteReminder = new JButton("Excluir\r\n");
//		btnDeleteReminder.addActionListener(this);
//		GridBagConstraints gbc_btnDeleteReminder = new GridBagConstraints();
//		gbc_btnDeleteReminder.insets = new Insets(0, 0, 5, 5);
//		gbc_btnDeleteReminder.anchor = GridBagConstraints.EAST;
//		gbc_btnDeleteReminder.gridx = 5;
//		gbc_btnDeleteReminder.gridy = 11;
//		add(btnDeleteReminder, gbc_btnDeleteReminder);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==btnCreateReminder) {
			actionCreateReminder();
		} else {
			if(arg0.getSource()==btnUpdateReminder) {
				actionUpdateReminder();
			} else {
				if(arg0.getSource()==btnDeleteReminder) {
					actionDeleteReminder();
				}
			}
		}
	}
	
	private void actionCreateReminder() {
		Reminder newReminder = new Reminder();
		newReminder.setTitle(tfTitleReminder.getText());
		newReminder.setDescription(taDescription.getText());
		//newReminder.setDate(t); faltando?
		
		ReminderDAO remDAO = InitialPage.getInstance().getDaoFactory().getReminderDAO();
		remDAO.insert(newReminder);
	}

	private void actionUpdateReminder() {
		Reminder newReminder = new Reminder();
		newReminder.setTitle(tfTitleReminder.getText());
		newReminder.setDescription(taDescription.getText());
		//newReminder.setDate(t); faltando?
		
		ReminderDAO remDAO = InitialPage.getInstance().getDaoFactory().getReminderDAO();
		remDAO.edit(newReminder);
	}

	private void actionDeleteReminder() {
		Reminder newReminder = new Reminder();
		newReminder.setTitle(tfTitleReminder.getText());
		newReminder.setDescription(taDescription.getText());
		//newReminder.setDate(t); faltando?
		
		ReminderDAO remDAO = InitialPage.getInstance().getDaoFactory().getReminderDAO();
		remDAO.remove(newReminder);
	}
	
}
