package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.CategoryDAO;
import model.Category;
import model.Product;
import model.User;
import view.tableModel.CategoryTableModel;

public class CategoryRegistration extends JPanel implements ActionListener{
	
	private JTable table;
	private JTextField tfName;
	private JButton btnNewCategorie, btnDelete;
	private JLabel lbTitle, lbCategories, lbName;
	
	private Integer selected;
	private User user;
	
	private CategoryTableModel model;
	private CategoryDAO catDAO = InitialPage.getInstance().getDaoFactory().getCategoryDAO();
	
	public CategoryRegistration(User user) {
		this.user = user;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths  = new int[]{30, 100, 100, 40, 50, 0, 100, 100, 0, 0};
		gridBagLayout.rowHeights    = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights    = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lbTitle = new JLabel("Cadastro de Categorias");
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lbTitle = new GridBagConstraints();
		gbc_lbTitle.gridwidth = 7;
		gbc_lbTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lbTitle.gridx = 1;
		gbc_lbTitle.gridy = 1;
		add(lbTitle, gbc_lbTitle);
		
		lbCategories = new JLabel("Categorias");
		lbCategories.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lbCategories = new GridBagConstraints();
		gbc_lbCategories.gridwidth = 2;
		gbc_lbCategories.insets = new Insets(0, 0, 5, 5);
		gbc_lbCategories.gridx = 1;
		gbc_lbCategories.gridy = 3;
		add(lbCategories, gbc_lbCategories);
		
		lbName = new JLabel("Nome");
		lbName.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lbName = new GridBagConstraints();
		gbc_lbName.insets = new Insets(0, 0, 5, 5);
		gbc_lbName.gridx = 4;
		gbc_lbName.gridy = 3;
		add(lbName, gbc_lbName);
		
		tfName = new JTextField();
		GridBagConstraints gbc_tfName = new GridBagConstraints();
		gbc_tfName.gridwidth = 2;
		gbc_tfName.insets = new Insets(0, 0, 5, 5);
		gbc_tfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfName.gridx = 6;
		gbc_tfName.gridy = 3;
		add(tfName, gbc_tfName);
		tfName.setColumns(10);
		
		btnNewCategorie = new JButton("Criar categoria");
		btnNewCategorie.addActionListener(this);
		
		model = new CategoryTableModel();
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				actionKeepSelected();
			}
		});
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 2;
		gbc_table.gridheight = 3;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 4;
		add(table, gbc_table);
		GridBagConstraints gbc_btnNewCategorie = new GridBagConstraints();
		gbc_btnNewCategorie.gridwidth = 2;
		gbc_btnNewCategorie.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewCategorie.gridx = 6;
		gbc_btnNewCategorie.gridy = 5;
		add(btnNewCategorie, gbc_btnNewCategorie);
		
		btnDelete = new JButton("Excluir");
		btnDelete.addActionListener(this);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridwidth = 2;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 1;
		gbc_btnDelete.gridy = 8;
		add(btnDelete, gbc_btnDelete);
		
		popula();
	}
	
	void popula() {
		for(Category c : catDAO.getAll(user.getIdFamily())) {
			model.addCategory(c);
		}
		model.fireTableDataChanged();
	}
	
	void actionKeepSelected() {
		selected = table.getSelectedRow();
		System.out.println(selected);
	}

	void actionNewCategorie(){
		Category newCategory = new Category();
		newCategory.setName(tfName.getText());
		newCategory.setIdFamily(user.getIdFamily());
		catDAO.insert(newCategory);
		newCategory.setId(catDAO.getMaxId());
		model.addCategory(newCategory);
		model.fireTableDataChanged();
	}
	
	void actionDelete(){
		Category killCategory = model.getCategory(selected);
		catDAO.remove(killCategory);
		model.removeCategory(selected);
		model.fireTableDataChanged();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==btnNewCategorie) {
			actionNewCategorie();
		}else {
			if(arg0.getSource()==btnDelete) {
				actionDelete();
			}
		}
	}
}
