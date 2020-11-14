package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.ProductDAO;
import model.Product;

public class CreateItems extends JPanel {
	private JTextField tfName;
	private JCheckBox chckbxCategory;
	private JLabel lblTitle, lbName, lblCategorie;
	private JButton btnCreateItem;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints gbc_chckbxCategory,gbc_btnCreateItem;
	
	
	private GridLayout gridExterno;
	private JList listAllCategories,listCategories;
	private JButton btnAdd,btnRemove;
	private JPanel panelSwitchList;
	
	public CreateItems() {
		
		
		
		
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 30, 30, 100, 100, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblTitle = new JLabel("Criar item");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 5;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 0;
		add(lblTitle, gbc_lblTitle);
		
		lbName = new JLabel("Nome");
		lbName.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lbName = new GridBagConstraints();
		gbc_lbName.insets = new Insets(0, 0, 5, 5);
		gbc_lbName.gridx = 1;
		gbc_lbName.gridy = 2;
		add(lbName, gbc_lbName);
		
		tfName = new JTextField();
		GridBagConstraints gbc_tfName = new GridBagConstraints();
		gbc_tfName.gridwidth = 2;
		gbc_tfName.insets = new Insets(0, 0, 5, 5);
		gbc_tfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfName.gridx = 3;
		gbc_tfName.gridy = 2;
		add(tfName, gbc_tfName);
		tfName.setColumns(10);
		
		lblCategorie = new JLabel("Categoria");
		lblCategorie.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblCategorie = new GridBagConstraints();
		gbc_lblCategorie.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategorie.gridx = 1;
		gbc_lblCategorie.gridy = 4;
		add(lblCategorie, gbc_lblCategorie);
		
		//substituir
		chckbxCategory = new JCheckBox("");
		/*
		chckbxCategory.addItemListener(new ItemListener() {    
        public void itemStateChanged(ItemEvent e) {                 
           label.setText("C++ Checkbox: "     
           + (e.getStateChange()==1?"checked":"unchecked"));    
        	}    
     	});*/
		gbc_chckbxCategory = new GridBagConstraints();
		gbc_chckbxCategory.gridwidth = 2;
		gbc_chckbxCategory.gridheight = 3;
		gbc_chckbxCategory.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxCategory.fill = GridBagConstraints.BOTH;
		gbc_chckbxCategory.gridx = 3;
		gbc_chckbxCategory.gridy = 4;
		add(chckbxCategory, gbc_chckbxCategory);
		
		btnCreateItem = new JButton("Criar item");
		btnCreateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCreateItem();
			}
		});
		gbc_btnCreateItem = new GridBagConstraints();
		gbc_btnCreateItem.gridwidth = 2;
		gbc_btnCreateItem.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateItem.gridx = 3;
		gbc_btnCreateItem.gridy = 8;
		add(btnCreateItem, gbc_btnCreateItem);
	}
	

	
	void actionCreateItem() {
		Product newProduct = new Product();
		newProduct.setName(tfName.getText());
		
		//Pegar categorias do combo box e passar para lista dentro de produto
		//get selected index ******************************
		//https://www.javatpoint.com/java-jcheckbox
		//tem troca no model pra alterar aqui LIST
		ProductDAO podDAO = InitialPage.getInstance().getDaoFactory().getProductDAO();
		podDAO.insert(newProduct);
	}
	
}
