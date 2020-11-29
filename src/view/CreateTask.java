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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.TaskDAO;
import model.Task;

public class CreateTask extends JPanel implements ActionListener {
	private JTextField tfTitleTask;
	private JTextField tfDate;
	private JTextField tfHour;
	private JTable tbResponsible;
	private JButton btnCreateTask,btnSearchTask,btnUpdateTask,btnDeleteTask,btnCreateReminder;
	private JLabel lblTitle,lblTitleTask,lblDescription,lblResponsible,lblDate,lblHour;
	private JTextArea taDescription;
	private Integer selected;
	private boolean isTrue = false;
	
	public CreateTask() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 30, 30, 100, 100, 100, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblTitle = new JLabel("Criar/editar tarefa");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 7;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		add(lblTitle, gbc_lblTitle);
		
		lblTitleTask = new JLabel("T\u00EDtulo\r\n");
		lblTitleTask.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblTitleTask = new GridBagConstraints();
		gbc_lblTitleTask.anchor = GridBagConstraints.WEST;
		gbc_lblTitleTask.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitleTask.gridx = 1;
		gbc_lblTitleTask.gridy = 2;
		add(lblTitleTask, gbc_lblTitleTask);
		
		tfTitleTask = new JTextField();
		GridBagConstraints gbc_tfTitleTask = new GridBagConstraints();
		gbc_tfTitleTask.gridwidth = 3;
		gbc_tfTitleTask.insets = new Insets(0, 0, 5, 5);
		gbc_tfTitleTask.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTitleTask.gridx = 3;
		gbc_tfTitleTask.gridy = 2;
		add(tfTitleTask, gbc_tfTitleTask);
		tfTitleTask.setColumns(10);
		
		lblDescription = new JLabel("Descri\u00E7\u00E3o\r\n");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.gridheight = 3;
		gbc_lblDescription.anchor = GridBagConstraints.WEST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 1;
		gbc_lblDescription.gridy = 4;
		add(lblDescription, gbc_lblDescription);
		
		taDescription = new JTextArea();
		GridBagConstraints gbc_taDescription = new GridBagConstraints();
		gbc_taDescription.gridheight = 3;
		gbc_taDescription.gridwidth = 3;
		gbc_taDescription.insets = new Insets(0, 0, 5, 5);
		gbc_taDescription.fill = GridBagConstraints.BOTH;
		gbc_taDescription.gridx = 3;
		gbc_taDescription.gridy = 4;
		add(taDescription, gbc_taDescription);
		
		lblResponsible = new JLabel("Respons\u00E1vel (s)");
		lblResponsible.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblResponsible = new GridBagConstraints();
		gbc_lblResponsible.gridheight = 2;
		gbc_lblResponsible.insets = new Insets(0, 0, 5, 5);
		gbc_lblResponsible.gridx = 1;
		gbc_lblResponsible.gridy = 8;
		add(lblResponsible, gbc_lblResponsible);
		
		tbResponsible = new JTable();
		tbResponsible.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ListSelectionModel selectionModel = tbResponsible.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				actionKeepSelected();
			}
		});
		GridBagConstraints gbc_tbResponsible = new GridBagConstraints();
		gbc_tbResponsible.gridheight = 3;
		gbc_tbResponsible.gridwidth = 3;
		gbc_tbResponsible.insets = new Insets(0, 0, 5, 5);
		gbc_tbResponsible.fill = GridBagConstraints.BOTH;
		gbc_tbResponsible.gridx = 3;
		gbc_tbResponsible.gridy = 8;
		add(tbResponsible, gbc_tbResponsible);
		
		lblDate = new JLabel("Data");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 1;
		gbc_lblDate.gridy = 12;
		add(lblDate, gbc_lblDate);
		
		tfDate = new JTextField();
		GridBagConstraints gbc_tfDate = new GridBagConstraints();
		gbc_tfDate.insets = new Insets(0, 0, 5, 5);
		gbc_tfDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDate.gridx = 3;
		gbc_tfDate.gridy = 12;
		add(tfDate, gbc_tfDate);
		tfDate.setColumns(10);
		
		lblHour = new JLabel("Hora");
		lblHour.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblHour = new GridBagConstraints();
		gbc_lblHour.insets = new Insets(0, 0, 5, 5);
		gbc_lblHour.gridx = 4;
		gbc_lblHour.gridy = 12;
		add(lblHour, gbc_lblHour);
		
		tfHour = new JTextField();
		GridBagConstraints gbc_tfHour = new GridBagConstraints();
		gbc_tfHour.insets = new Insets(0, 0, 5, 5);
		gbc_tfHour.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfHour.gridx = 5;
		gbc_tfHour.gridy = 12;
		add(tfHour, gbc_tfHour);
		tfHour.setColumns(10);
		
		btnCreateTask = new JButton("Criar tarefa");
		btnCreateTask.addActionListener(this);
		GridBagConstraints gbc_btnCreateTask = new GridBagConstraints();
		gbc_btnCreateTask.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateTask.gridx = 1;
		gbc_btnCreateTask.gridy = 14;
		add(btnCreateTask, gbc_btnCreateTask);
		
		btnSearchTask = new JButton("Buscar");
		btnSearchTask.addActionListener(this);
		GridBagConstraints gbc_btnSearchTask = new GridBagConstraints();
		gbc_btnSearchTask.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearchTask.gridx = 3;
		gbc_btnSearchTask.gridy = 14;
		add(btnSearchTask, gbc_btnSearchTask);
		
		btnUpdateTask = new JButton("Alterar");
		btnUpdateTask.addActionListener(this);
		GridBagConstraints gbc_btnUpdateTask = new GridBagConstraints();
		gbc_btnUpdateTask.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdateTask.gridx = 4;
		gbc_btnUpdateTask.gridy = 14;
		add(btnUpdateTask, gbc_btnUpdateTask);
		
		btnDeleteTask = new JButton("Excluir");
		btnDeleteTask.addActionListener(this);
		GridBagConstraints gbc_btnDeleteTask = new GridBagConstraints();
		gbc_btnDeleteTask.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteTask.gridx = 5;
		gbc_btnDeleteTask.gridy = 14;
		add(btnDeleteTask, gbc_btnDeleteTask);
		
		btnCreateReminder = new JButton("Criar/editar lembrete");
		btnCreateReminder.addActionListener(this);
		GridBagConstraints gbc_btnCreateReminder = new GridBagConstraints();
		gbc_btnCreateReminder.gridwidth = 2;
		gbc_btnCreateReminder.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateReminder.gridx = 3;
		gbc_btnCreateReminder.gridy = 16;
		add(btnCreateReminder, gbc_btnCreateReminder);
	}

	void actionKeepSelected() {
		selected = tbResponsible.getSelectedRow();
		//System.out.println(selected); //teste
	}
	void actionCreateTask() {
		Task newTask= new Task();
		newTask.setName(tfTitleTask.getText());
		newTask.setDescription(taDescription.getText());
		newTask.setCompleted(false);
		//newTask.setResponsible(); faltou checkbox
		TaskDAO taskDAO = InitialPage.getInstance().getDaoFactory().getTaskDAO();
		taskDAO.insert(newTask);
		
		//pegar id de insert e usar pra inserir os outros
	}
	
	void actionSearch() {
		
		TaskDAO taskDAO = InitialPage.getInstance().getDaoFactory().getTaskDAO();
		//taskDAO.getById(id, idFamily)
		Task newTask = new Task();
		
	}
	
	void actionUpdate() {
		Task newTask = new Task();
		newTask.setName(tfTitleTask.getText());
		newTask.setDescription(taDescription.getText());
		newTask.setCompleted(isTrue);
		//sobrou listas para ligacoes
		TaskDAO taskDAO = InitialPage.getInstance().getDaoFactory().getTaskDAO();
		taskDAO.edit(newTask);
	}
	
	void actionDelete() {
		Task newTask = new Task();
		newTask.setName(tfTitleTask.getText());
		newTask.setDescription(taDescription.getText());
		newTask.setCompleted(isTrue);
		//sobrou listas para ligacoes
		
		
		
		
		TaskDAO taskDAO = InitialPage.getInstance().getDaoFactory().getTaskDAO();
		taskDAO.remove(newTask);
		
	}
	
	void actionCreateReminder() {
		InitialPage.getInstance().createInternalFrame(new CreateReminder(), "Criar novo lembrete", 800, 600);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==btnCreateTask) {
			actionCreateTask();
		}else {
			if(arg0.getSource()==btnSearchTask) {
				actionSearch();
			}else {
				if(arg0.getSource()==btnUpdateTask) {
					actionUpdate();
				}else {
					if(arg0.getSource()==btnDeleteTask) {
						actionDelete();
					}else {
						if(arg0.getSource()==btnCreateReminder) {
							actionCreateReminder();
						}
					}
				}
			}
		}
	}
	

}
