package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.FamilyDAO;
import dao.MessageDAO;
import dao.OccurrenceDAO;
import dao.ProductDAO;
import dao.ReminderDAO;
import dao.TaskDAO;
import model.Occurrence;
import model.Product;
import model.Reminder;
import model.Task;
import model.Message;
import javax.swing.JCheckBox;
import model.User;
import view.listModel.ProductListModel;
import view.listModel.ResponsableListModel;
import view.listModel.SwitchListProduct;
import view.listModel.SwitchListResponsable;
import view.tableModel.CategoryTableModel;

public class CreateTask extends JPanel implements ActionListener {
	private JTextField tfTitleTask;
	private JTextField tfDate;
	private JTextField tfHour;
//	private JTable tbResponsible;
	private JButton btnCreateTask, btnSearchTask, btnUpdateTask, btnDeleteTask, btnEditReminder;
	private JLabel lblTitle, lblTitleTask, lblDescription, lblResponsible, lblDate, lblHour;
	private JTextArea taDescription;
	private Integer selected;
	private boolean isTrue = false;
	private SwitchListProduct switchListItems;
	private SwitchListResponsable switchListResponsible;
	private JCheckBox chckbxIsConcluded;
	private User user;
	private JLabel lblItems;
	private Task task;
	private Occurrence occurrence;
	private Message message;
	private Reminder reminder;
	private boolean flagNew = false;
	
	private TaskDAO taskDAO = InitialPage.getInstance().getDaoFactory().getTaskDAO();
	private OccurrenceDAO occuDAO = InitialPage.getInstance().getDaoFactory().getOcurrenceDAO();
	private ReminderDAO remDAO = InitialPage.getInstance().getDaoFactory().getReminderDAO();
	private MessageDAO mesDAO = InitialPage.getInstance().getDaoFactory().getMessageDAO();
	
	private ProductListModel modelProduct1, modelProduct2;
	private ResponsableListModel modelResponsable1,modelResponsable2;
	
	public CreateTask(User user, Task taskR) {
		this.user = user;
		if(taskR==null) {
			task = new Task();
			occurrence= new Occurrence();
			message = new Message();
			reminder = new Reminder();
			flagNew = true;
		} else {
			task = taskR;
			occurrence = task.getOccurrences().get(0);
		}
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths  = new int[]{30, 30, 30, 100, 100, 100, 30, 0};
		gridBagLayout.rowHeights    = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0, 30, 30, 30, 30, 30, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights    = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblTitle = new JLabel("Cadastro de Tarefas");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 7;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		add(lblTitle, gbc_lblTitle);
		
		chckbxIsConcluded = new JCheckBox("Concluída");
		chckbxIsConcluded.addItemListener(new ItemListener() {    
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				isTrue = !isTrue;
			}    
        }); 
		chckbxIsConcluded.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_chckbxIsConcluded = new GridBagConstraints();
		gbc_chckbxIsConcluded.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxIsConcluded.gridx = 5;
		gbc_chckbxIsConcluded.gridy = 1;
		add(chckbxIsConcluded, gbc_chckbxIsConcluded);
		
		lblTitleTask = new JLabel("Título");
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
		
		lblDescription = new JLabel("Descrição");
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
		
		lblItems = new JLabel("Itens");
		lblItems.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblItems = new GridBagConstraints();
		gbc_lblItems.anchor = GridBagConstraints.WEST;
		gbc_lblItems.insets = new Insets(0, 0, 5, 5);
		gbc_lblItems.gridx = 1;
		gbc_lblItems.gridy = 9;
		add(lblItems, gbc_lblItems);
		
		modelProduct1 = new ProductListModel();
		modelProduct2 = new ProductListModel();
		
		switchListItems = new SwitchListProduct();
		modelProduct1 = (ProductListModel) switchListItems.getlist1().getModel();
		modelProduct2 = (ProductListModel) switchListItems.getlist2().getModel();
		GridBagConstraints gbc_switchListItems = new GridBagConstraints();
		gbc_switchListItems.gridheight = 4;
		gbc_switchListItems.gridwidth = 3;
		gbc_switchListItems.fill = GridBagConstraints.BOTH;
		gbc_switchListItems.insets = new Insets(0, 0, 5, 5);
		gbc_switchListItems.gridx = 3;
		gbc_switchListItems.gridy = 8;
		add(switchListItems, gbc_switchListItems);
		
		lblResponsible = new JLabel("Responsável (s)");
		lblResponsible.setFont(new Font("Tahoma", Font.BOLD, 11));	
		GridBagConstraints gbc_lblResponsible = new GridBagConstraints();
		gbc_lblResponsible.anchor = GridBagConstraints.WEST;
		gbc_lblResponsible.gridheight = 2;
		gbc_lblResponsible.insets = new Insets(0, 0, 5, 5);
		gbc_lblResponsible.gridx = 1;
		gbc_lblResponsible.gridy = 13;
		add(lblResponsible, gbc_lblResponsible);
		
		modelResponsable1 = new ResponsableListModel();
		modelResponsable2 = new ResponsableListModel();
		switchListResponsible = new SwitchListResponsable();
		modelResponsable1 = (ResponsableListModel) switchListResponsible.getlist1().getModel();
		modelResponsable2 = (ResponsableListModel) switchListResponsible.getlist2().getModel();
		GridBagConstraints gbc_switchListResponsible = new GridBagConstraints();
		gbc_switchListResponsible.gridheight = 4;
		gbc_switchListResponsible.gridwidth = 3;
		gbc_switchListResponsible.fill = GridBagConstraints.BOTH;
		gbc_switchListResponsible.insets = new Insets(0, 0, 5, 5);
		gbc_switchListResponsible.gridx = 3;
		gbc_switchListResponsible.gridy = 13;
		add(switchListResponsible, gbc_switchListResponsible);
		
//		tbResponsible = new JTable();
//		tbResponsible.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		
//		ListSelectionModel selectionModel = tbResponsible.getSelectionModel();
//		selectionModel.addListSelectionListener(new ListSelectionListener() {
//			public void valueChanged(ListSelectionEvent e) {
//				actionKeepSelected();
//			}
//		});
//		GridBagConstraints gbc_tbResponsible = new GridBagConstraints();
//		gbc_tbResponsible.gridheight = 3;
//		gbc_tbResponsible.gridwidth = 3;
//		gbc_tbResponsible.insets = new Insets(0, 0, 5, 5);
//		gbc_tbResponsible.fill = GridBagConstraints.BOTH;
//		gbc_tbResponsible.gridx = 3;
//		gbc_tbResponsible.gridy = 8;
//		add(tbResponsible, gbc_tbResponsible);
		
		lblDate = new JLabel("Data");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 1;
		gbc_lblDate.gridy = 18;
		add(lblDate, gbc_lblDate);
		
		tfDate = new JTextField();
		GridBagConstraints gbc_tfDate = new GridBagConstraints();
		gbc_tfDate.insets = new Insets(0, 0, 5, 5);
		gbc_tfDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDate.gridx = 3;
		gbc_tfDate.gridy = 18;
		add(tfDate, gbc_tfDate);
		tfDate.setColumns(10);
		
		lblHour = new JLabel("Hora");
		lblHour.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblHour = new GridBagConstraints();
		gbc_lblHour.insets = new Insets(0, 0, 5, 5);
		gbc_lblHour.gridx = 4;
		gbc_lblHour.gridy = 18;
		add(lblHour, gbc_lblHour);
		
		tfHour = new JTextField();
		GridBagConstraints gbc_tfHour = new GridBagConstraints();
		gbc_tfHour.insets = new Insets(0, 0, 5, 5);
		gbc_tfHour.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfHour.gridx = 5;
		gbc_tfHour.gridy = 18;
		add(tfHour, gbc_tfHour);
		tfHour.setColumns(10);
		
		btnCreateTask = new JButton("Criar tarefa");
		btnCreateTask.addActionListener(this);
		GridBagConstraints gbc_btnCreateTask = new GridBagConstraints();
		gbc_btnCreateTask.anchor = GridBagConstraints.WEST;
		gbc_btnCreateTask.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateTask.gridx = 1;
		gbc_btnCreateTask.gridy = 20;
		add(btnCreateTask, gbc_btnCreateTask);
		
		btnSearchTask = new JButton("Buscar");
		btnSearchTask.addActionListener(this);
		GridBagConstraints gbc_btnSearchTask = new GridBagConstraints();
		gbc_btnSearchTask.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearchTask.gridx = 3;
		gbc_btnSearchTask.gridy = 20;
		add(btnSearchTask, gbc_btnSearchTask);
		
		btnUpdateTask = new JButton("Alterar");
		btnUpdateTask.addActionListener(this);
		GridBagConstraints gbc_btnUpdateTask = new GridBagConstraints();
		gbc_btnUpdateTask.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdateTask.gridx = 4;
		gbc_btnUpdateTask.gridy = 20;
		add(btnUpdateTask, gbc_btnUpdateTask);
		
		btnDeleteTask = new JButton("Excluir");
		btnDeleteTask.addActionListener(this);
		GridBagConstraints gbc_btnDeleteTask = new GridBagConstraints();
		gbc_btnDeleteTask.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteTask.gridx = 5;
		gbc_btnDeleteTask.gridy = 20;
		add(btnDeleteTask, gbc_btnDeleteTask);
		
		btnEditReminder = new JButton("Editar lembrete");
		btnEditReminder.addActionListener(this);
		GridBagConstraints gbc_btnEditReminder = new GridBagConstraints();
		gbc_btnEditReminder.gridwidth = 7;
		gbc_btnEditReminder.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditReminder.gridx = 0;
		gbc_btnEditReminder.gridy = 22;
		add(btnEditReminder, gbc_btnEditReminder);
		
//		populaItems();
//		populaUsers();
		populaTela();
	}
	
	void populaTela() {
		tfTitleTask.setText(task.getName());
		taDescription.setText(task.getDescription());
		//ta dando nullpointer ainda
		ProductDAO podDAO = InitialPage.getInstance().getDaoFactory().getProductDAO();
		FamilyDAO famDAO = InitialPage.getInstance().getDaoFactory().getFamilyDAO();
		System.out.println(podDAO.getAll(user.getIdFamily()));
		populaItems(podDAO.getAll(user.getId()));
		//populaUsers(famDAO.getById(user.getIdFamily()).getMermber());
		if(!flagNew) {
			String a = Integer.toString(occurrence.getDate());
			tfDate.setText(a);
			//tfDate.setText(Integer.toString(occurrence.getDate()));
			tfHour.setText(Integer.toString(occurrence.getHour()));
		}

	}
	
	void populaItems() {
		//List<Product> l = new ArrayList<Product>();
		for(Product p : task.getProducts()) {
			modelProduct1.addList1(p);
			//l.add(p);
		}
		//switchListItems.setlist1(l);
	}
	
	void populaItems(List<Product> products) {
		System.out.println("aqui os produtos : " + products);
		for(Product p : products) {
			modelProduct1.addList1(p);
		}
	}
	
	void populaUsers() {
		for(User s : task.getResponsible()) {
			modelResponsable1.addList1(s);
		}
	}
	
	void populaUsers(List<User> responsables) {
		for(User s : responsables) {
			modelResponsable1.addList1(s);
		}
	}

//	void actionKeepSelected() {
//		selected = tbResponsible.getSelectedRow();
//		System.out.println(selected); //teste
//	}
	
	void actionCreateTask() {
		Task newTask = task;
		newTask.setName(tfTitleTask.getText());
		newTask.setDescription(taDescription.getText());
		newTask.setIdUser(user.getId());
		newTask.setIdFamily(user.getIdFamily());
		JList listResponsibles = switchListResponsible.getlist2();
		newTask.setResponsible(switchListResponsible.listToArray(listResponsibles));
		JList listItens = switchListItems.getlist2();
		newTask.setProducts(switchListItems.listToArray(listItens));
		newTask.setCompleted(isTrue);
		taskDAO.insert(newTask);
		int idTask = taskDAO.getMaxId(user.getId());
		newTask.setId(idTask);
		task=newTask;
		
		Occurrence newOccurrence = new Occurrence();
		newOccurrence.setDate(Integer.parseInt(tfDate.getText()));
		newOccurrence.setHour(Integer.parseInt(tfHour.getText()));
		newOccurrence.setIdTask(newTask.getId());
		newOccurrence.setIdFamily(user.getIdFamily());
		occuDAO.insert(newOccurrence);
		int idOccurrence = occuDAO.getMaxId(user.getIdFamily(), newTask.getId());
		newOccurrence.setId(idOccurrence);
		occurrence = newOccurrence;
		
		JOptionPane.showMessageDialog(null, "Tarefa Criada.", "Status da tarefa",
				JOptionPane.INFORMATION_MESSAGE);
		
		
	}
	
	void actionSearch() {
		Task newTask = task;
		task = taskDAO.getById(task.getId(), user.getIdFamily());
		tfTitleTask.setText(task.getName());
		taDescription.setText(task.getDescription());
		
		
		//ta faltando os lists
		populaItems(task.getProducts());
		populaUsers(task.getResponsible());
		
		List<Occurrence> l  = occuDAO.getAll(task.getId(), user.getId());
		int data = l.get(0).getDate();
		tfDate.setText(Integer.toString(data));
		int hour = l.get(0).getHour();
		tfHour.setText(Integer.toString(hour));
		
		
	}
	
	void actionUpdate() {
		Task newTask = new Task();
		newTask.setName(tfTitleTask.getText());
		newTask.setDescription(taDescription.getText());
		JList listResponsibles = switchListResponsible.getlist2();
		newTask.setResponsible(switchListResponsible.listToArray(listResponsibles));
		JList listItens = switchListItems.getlist2();
		newTask.setProducts(switchListItems.listToArray(listItens));
		newTask.setCompleted(isTrue);
		taskDAO.edit(newTask);
	}
	
	void actionDelete() {
		taskDAO.remove(task);
		for(Occurrence oc : task.getOccurrences()) {
			occuDAO.remove(oc);
		}
		
		for(Reminder re : remDAO.getAll(task.getId(), occurrence.getId(), user.getIdFamily())) {
			remDAO.remove(re);
			for(Message me : mesDAO.getAll(task.getId(), occurrence.getId(), re.getId(), user.getIdFamily())) {
				mesDAO.remove(me);;
			}
		}
	}
	
	void actionEditReminder() {
		InitialPage.getInstance().createInternalFrame(new EditReminder(user, task, message, reminder), "Home Task Center", 550, 350);
	}

	void actionSwitchListPullAllItems() {
		modelProduct2.clearList1();
    	for(int i=0;i<modelProduct1.getSize();i++) {
    		modelProduct2.addList1((Product) modelProduct1.getElementAt(i));
    	}
    	modelProduct1.clearList1();
	}
	
	void actionSwitchListPullOneItems() {
		int index = switchListItems.getlist1().getSelectedIndex();
		Product p = (Product) modelProduct1.getElementAt(index);
		modelProduct1.removeList1(p);
		modelProduct2.addList1(p);
	}
	
	void actionSwitchListRemoveAllItems() {
		modelProduct1.clearList1();
    	for(int i=0;i<modelProduct1.getSize();i++) {
    		modelProduct1.addList1((Product) modelProduct2.getElementAt(i));
    	}
    	modelProduct2.clearList1();
	}
	
	void actionSwitchListRemoveOneItems() {
		int index = switchListItems.getlist2().getSelectedIndex();
		Product p = (Product) modelProduct2.getElementAt(index);
		modelProduct2.removeList1(p);
		modelProduct1.addList1(p);
	}
	
	void actionSwitchListPullAllResponsables() {
		modelResponsable2.clearList1();
    	for(int i=0;i<modelProduct1.getSize();i++) {
    		modelResponsable2.addList1((User) modelResponsable1.getElementAt(i));
    	}
    	modelResponsable1.clearList1();
	}
	
	void actionSwitchListPullOneResponsables() {
		int index = switchListResponsible.getlist1().getSelectedIndex();
		User p = (User) modelResponsable1.getElementAt(index);
		modelResponsable1.removeList1(p);
		modelResponsable2.addList1(p);
	}
	
	void actionSwitchListRemoveAllResponsables() {
		modelResponsable1.clearList1();
    	for(int i=0;i<modelProduct2.getSize();i++) {
    		modelResponsable1.addList1((User) modelResponsable2.getElementAt(i));
    	}
    	modelResponsable2.clearList1();
	}
	
	void actionSwitchListRemoveOneResponsables() {
		int index = switchListResponsible.getlist2().getSelectedIndex();
		User p = (User) modelResponsable2.getElementAt(index);
		modelResponsable2.removeList1(p);
		modelResponsable1.addList1(p);
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
						if(arg0.getSource()==btnEditReminder) {
							actionEditReminder();
						} else {
							if(arg0.getSource()==switchListItems.getbPuttAll()) {
								actionSwitchListPullAllItems();
							} else {
								if(arg0.getSource()==switchListItems.getbPuttOne()) {
									actionSwitchListPullOneItems();
								} else {
									if(arg0.getSource()==switchListItems.getbRemoveAll()) {
										actionSwitchListRemoveAllItems();
									} else {
										if(arg0.getSource()==switchListItems.getbRemoveOne()) {
											actionSwitchListRemoveOneItems();
										} else {
											if(arg0.getSource()==switchListResponsible.getbPuttAll()) {
												actionSwitchListPullAllResponsables();
											} else {
												if(arg0.getSource()==switchListResponsible.getbPuttOne()) {
													actionSwitchListPullOneResponsables();
												} else {
													if(arg0.getSource()==switchListResponsible.getbRemoveAll()) {
														actionSwitchListRemoveAllResponsables();
													} else {
														if(arg0.getSource()==switchListResponsible.getbRemoveOne()) {
															actionSwitchListRemoveOneResponsables();
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Reminder getReminder() {
		return reminder;
	}

	public void setReminder(Reminder reminder) {
		this.reminder = reminder;
	}
}
