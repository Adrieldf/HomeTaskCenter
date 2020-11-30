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
	private JButton btnInsert,btnDelete;
	private JLabel lbTitle,lbFamily,lblName,lblAdmin;
	private JCheckBox chckbxAdmin;
	private Integer selected;
	private boolean isTrue = false;
	public FamilyRegistration() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 100, 100, 30, 30, 30, 100, 100, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 30, 30, 30, 30, 0, 30, 30, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
//		lbTitle = new JLabel("Criar/editar fam\u00EDlia");
//		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
//		GridBagConstraints gbc_lbTitle = new GridBagConstraints();
//		gbc_lbTitle.gridwidth = 9;
//		gbc_lbTitle.insets = new Insets(0, 0, 5, 0);
//		gbc_lbTitle.gridx = 0;
//		gbc_lbTitle.gridy = 0;
//		add(lbTitle, gbc_lbTitle);
		
		lbFamily = new JLabel("Fam\u00EDlia");
		lbFamily.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lbFamily = new GridBagConstraints();
		gbc_lbFamily.gridwidth = 2;
		gbc_lbFamily.insets = new Insets(0, 0, 5, 5);
		gbc_lbFamily.gridx = 1;
		gbc_lbFamily.gridy = 2;
		add(lbFamily, gbc_lbFamily);
		
		lblName = new JLabel("Nome");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 4;
		gbc_lblName.gridy = 2;
		add(lblName, gbc_lblName);
		
		tfName = new JTextField();
		GridBagConstraints gbc_tfName = new GridBagConstraints();
		gbc_tfName.gridwidth = 2;
		gbc_tfName.insets = new Insets(0, 0, 5, 5);
		gbc_tfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfName.gridx = 6;
		gbc_tfName.gridy = 2;
		add(tfName, gbc_tfName);
		tfName.setColumns(10);
		
		tabFamily = new JTable();
		tabFamily.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ListSelectionModel selectionModel = tabFamily.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				actionKeepSelected();
			}
		});
		
		GridBagConstraints gbc_tabFamily = new GridBagConstraints();
		gbc_tabFamily.gridheight = 3;
		gbc_tabFamily.gridwidth = 2;
		gbc_tabFamily.insets = new Insets(0, 0, 5, 5);
		gbc_tabFamily.fill = GridBagConstraints.BOTH;
		gbc_tabFamily.gridx = 1;
		gbc_tabFamily.gridy = 3;
		add(tabFamily, gbc_tabFamily);
		
		lblAdmin = new JLabel("Administrador");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblAdmin = new GridBagConstraints();
		gbc_lblAdmin.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdmin.gridx = 4;
		gbc_lblAdmin.gridy = 4;
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
		gbc_chckbxAdmin.gridy = 4;
		add(chckbxAdmin, gbc_chckbxAdmin);
		
		btnInsert = new JButton("Inserir");
		btnInsert.addActionListener(this);
		GridBagConstraints gbc_btnInsert = new GridBagConstraints();
		gbc_btnInsert.gridwidth = 2;
		gbc_btnInsert.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsert.gridx = 6;
		gbc_btnInsert.gridy = 6;
		add(btnInsert, gbc_btnInsert);
		
		btnDelete = new JButton("Excluir\r\n");
		btnDelete.addActionListener(this);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridwidth = 2;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 1;
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
		User newUser = userDAO.getByName(tfName.getText());
		//verifica se é admin
		if(isTrue) {
			//menmbro é admin
			
		}
		FamilyRegistrationTableModel model = (FamilyRegistrationTableModel) tabFamily.getModel();
		model.addMember(newUser);
		FamilyDAO famDAO = InitialPage.getInstance().getDaoFactory().getFamilyDAO();
		newFamily.setMermber(model.getMembers());
		famDAO.insert(newFamily);
		model.fireTableDataChanged();
	}
	
	void actionDelete() {
		FamilyRegistrationTableModel model = (FamilyRegistrationTableModel) tabFamily.getModel();
		Family killCategory = (Family)model.getValueAt(selected, 0);
		FamilyDAO famDAO = InitialPage.getInstance().getDaoFactory().getFamilyDAO();
		famDAO.remove(killCategory);
		model.removeMember(selected);
		model.fireTableDataChanged();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==btnInsert) {
			actionInsert();
		}else {
			if(arg0.getSource()==btnDelete) {
				actionDelete();
			}
		}
	}
	
}
