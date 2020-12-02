package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.CategoryDAO;
import dao.FamilyDAO;
import dao.UserDAO;
import model.Category;
import model.Family;
import model.User;
import view.tableModel.CategoryTableModel;
import view.tableModel.FamilyRegistrationTableModel;

public class FamilyRegistration extends JPanel implements ActionListener {
	private JTable tabFamily;
	private JTextField tfName;
	private JButton btnSave, btnDelete;
	private JLabel lbTitle, lbFamily, lblName, lblAdmin;
	private JCheckBox chckbxAdmin;
	private Integer selected;
	private boolean isTrue = false;
	private User user;
	
	public FamilyRegistration(User user) {
		this.user = user;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 100, 100, 30, 30, 30, 100, 100, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lbTitle = new JLabel("Cadastro de Família");
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lbTitle = new GridBagConstraints();
		gbc_lbTitle.gridwidth = 9;
		gbc_lbTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lbTitle.gridx = 0;
		gbc_lbTitle.gridy = 1;
		add(lbTitle, gbc_lbTitle);
		
		lbFamily = new JLabel("Fam\u00EDlia");
		lbFamily.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lbFamily = new GridBagConstraints();
		gbc_lbFamily.gridwidth = 2;
		gbc_lbFamily.insets = new Insets(0, 0, 5, 5);
		gbc_lbFamily.gridx = 1;
		gbc_lbFamily.gridy = 3;
		add(lbFamily, gbc_lbFamily);
		
		lblName = new JLabel("Nome");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 4;
		gbc_lblName.gridy = 3;
		add(lblName, gbc_lblName);
		
		tfName = new JTextField();
		tfName.setEnabled(false);
		tfName.setEditable(false);
		GridBagConstraints gbc_tfName = new GridBagConstraints();
		gbc_tfName.gridwidth = 2;
		gbc_tfName.insets = new Insets(0, 0, 5, 5);
		gbc_tfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfName.gridx = 6;
		gbc_tfName.gridy = 3;
		add(tfName, gbc_tfName);
		tfName.setColumns(10);
		
		tabFamily = new JTable(new FamilyRegistrationTableModel());
		tabFamily.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ListSelectionModel selectionModel = tabFamily.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				actionKeepSelected();
			}
		});
		
		GridBagConstraints gbc_tabFamily = new GridBagConstraints();
		gbc_tabFamily.gridheight = 9;
		gbc_tabFamily.gridwidth = 2;
		gbc_tabFamily.insets = new Insets(0, 0, 5, 5);
		gbc_tabFamily.fill = GridBagConstraints.BOTH;
		gbc_tabFamily.gridx = 1;
		gbc_tabFamily.gridy = 4;
		add(tabFamily, gbc_tabFamily);
		
		lblAdmin = new JLabel("Administrador");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblAdmin = new GridBagConstraints();
		gbc_lblAdmin.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdmin.gridx = 4;
		gbc_lblAdmin.gridy = 5;
		add(lblAdmin, gbc_lblAdmin);
		
		chckbxAdmin = new JCheckBox("");
		chckbxAdmin.addItemListener(new ItemListener() {    
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				isTrue = !isTrue;
			}    
        });   
		GridBagConstraints gbc_chckbxAdmin = new GridBagConstraints();
		gbc_chckbxAdmin.anchor = GridBagConstraints.WEST;
		gbc_chckbxAdmin.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAdmin.gridx = 6;
		gbc_chckbxAdmin.gridy = 5;
		add(chckbxAdmin, gbc_chckbxAdmin);
		
		btnSave = new JButton("Salvar");
		btnSave.addActionListener(this);
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 6;
		gbc_btnSave.gridy = 7;
		add(btnSave, gbc_btnSave);
		
		btnDelete = new JButton("Excluir\r\n");
		btnDelete.addActionListener(this);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 7;
		gbc_btnDelete.gridy = 7;
		add(btnDelete, gbc_btnDelete);
	}
	
	void actionKeepSelected() {
		selected = tabFamily.getSelectedRow();
		//System.out.println(selected); //teste
	}
	
	void actionInsert() {
		UserDAO userDAO = InitialPage.getInstance().getDaoFactory().getUserDAO();
		Family newFamily = new Family();
		//PELO NOME?????????????
		User newUser = userDAO.getByName(tfName.getText());
		//talvez pesquisar o usuario pelo nome no banco
		
		//verifica se é admin
		if(isTrue) {
			//menmbro é admin
			newUser.setAdmin(true);
		}
		//insere a familia na tabela
		FamilyRegistrationTableModel model = (FamilyRegistrationTableModel) tabFamily.getModel();
		for(User fam :newFamily.getMermber()) {
			model.addMember(fam);
		}
		//insere a familia no banco
		FamilyDAO famDAO = InitialPage.getInstance().getDaoFactory().getFamilyDAO();
		newFamily.addMember(newUser);
		famDAO.insert(newFamily);
		model.fireTableDataChanged();
	}
	
	void actionDelete() {
		FamilyRegistrationTableModel model = (FamilyRegistrationTableModel) tabFamily.getModel();
		Family killFamily = (Family)model.getValueAt(selected, 0);
		FamilyDAO famDAO = InitialPage.getInstance().getDaoFactory().getFamilyDAO();
		famDAO.remove(killFamily);
		model.removeMember(selected);
		model.fireTableDataChanged();
	}
	
	void actionSearchUser() {
		User newUser=null;
		//buscar usuario do banco
		if(newUser!=null) {
			JOptionPane.showMessageDialog(null, "Usuario encontrado com sucesso!", "Pode ser inserido na família",
			JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Usuario não encontrado", "Pesquise novamente",
			JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==btnSave) {
			actionInsert();
		}else {
			if(arg0.getSource()==btnDelete) {
				actionDelete();
			}
		}
	}
	
}
