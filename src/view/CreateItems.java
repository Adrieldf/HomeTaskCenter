package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Product;

public class CreateItems extends JPanel {
	private JTextField tfName;
	private JTable tabCategory;
	public CreateItems() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 100, 100, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel("Criar item");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 10;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		add(lblTitle, gbc_lblTitle);
		
		JLabel lbName = new JLabel("Nome");
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
		
		JLabel lblCategorie = new JLabel("Categoria");
		lblCategorie.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblCategorie = new GridBagConstraints();
		gbc_lblCategorie.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategorie.gridx = 1;
		gbc_lblCategorie.gridy = 4;
		add(lblCategorie, gbc_lblCategorie);
		
		tabCategory = new JTable();
		GridBagConstraints gbc_tabCategory = new GridBagConstraints();
		gbc_tabCategory.gridwidth = 2;
		gbc_tabCategory.gridheight = 3;
		gbc_tabCategory.insets = new Insets(0, 0, 5, 5);
		gbc_tabCategory.fill = GridBagConstraints.BOTH;
		gbc_tabCategory.gridx = 3;
		gbc_tabCategory.gridy = 4;
		add(tabCategory, gbc_tabCategory);
		
		JButton btnCreateItem = new JButton("Criar item");
		GridBagConstraints gbc_btnCreateItem = new GridBagConstraints();
		gbc_btnCreateItem.gridwidth = 2;
		gbc_btnCreateItem.insets = new Insets(0, 0, 0, 5);
		gbc_btnCreateItem.gridx = 2;
		gbc_btnCreateItem.gridy = 8;
		add(btnCreateItem, gbc_btnCreateItem);
		
		JButton btnCancel = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridwidth = 3;
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 4;
		gbc_btnCancel.gridy = 8;
		add(btnCancel, gbc_btnCancel);
	}
	

	
	void actionCriateItem() {
		Product nItem = new Product();
		nItem.setName(tfName.getText());
		//Pegar categorias do combo box e passar para lista dentro de produto
		
		//mandar para db product
	}
	
	
	void actionCancel() {
		//troca de panel para 
		//this.getParent()dispose
		JInternalFrame jif = (JInternalFrame) this.getParent();
		jif.dispose();
	}
	

}
