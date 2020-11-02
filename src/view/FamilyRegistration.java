package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FamilyRegistration extends JPanel {
	private JTable tabFamily;
	private JTextField tfName;
	public FamilyRegistration() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 100, 100, 30, 30, 30, 100, 100, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 30, 30, 30, 30, 0, 30, 30, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lbTitle = new JLabel("Criar/editar fam\u00EDlia");
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lbTitle = new GridBagConstraints();
		gbc_lbTitle.gridwidth = 9;
		gbc_lbTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lbTitle.gridx = 0;
		gbc_lbTitle.gridy = 0;
		add(lbTitle, gbc_lbTitle);
		
		JLabel lbFamily = new JLabel("Fam\u00EDlia");
		lbFamily.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lbFamily = new GridBagConstraints();
		gbc_lbFamily.gridwidth = 2;
		gbc_lbFamily.insets = new Insets(0, 0, 5, 5);
		gbc_lbFamily.gridx = 1;
		gbc_lbFamily.gridy = 2;
		add(lbFamily, gbc_lbFamily);
		
		JLabel lblName = new JLabel("Nome");
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
		GridBagConstraints gbc_tabFamily = new GridBagConstraints();
		gbc_tabFamily.gridheight = 3;
		gbc_tabFamily.gridwidth = 2;
		gbc_tabFamily.insets = new Insets(0, 0, 5, 5);
		gbc_tabFamily.fill = GridBagConstraints.BOTH;
		gbc_tabFamily.gridx = 1;
		gbc_tabFamily.gridy = 3;
		add(tabFamily, gbc_tabFamily);
		
		JLabel lblAdmin = new JLabel("Administrador");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblAdmin = new GridBagConstraints();
		gbc_lblAdmin.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdmin.gridx = 4;
		gbc_lblAdmin.gridy = 4;
		add(lblAdmin, gbc_lblAdmin);
		
		JCheckBox chckbxAdmin = new JCheckBox("");
		GridBagConstraints gbc_chckbxAdmin = new GridBagConstraints();
		gbc_chckbxAdmin.anchor = GridBagConstraints.WEST;
		gbc_chckbxAdmin.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAdmin.gridx = 6;
		gbc_chckbxAdmin.gridy = 4;
		add(chckbxAdmin, gbc_chckbxAdmin);
		
		JButton btnInsert = new JButton("Inserir");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionInsert();
			}
		});
		GridBagConstraints gbc_btnInsert = new GridBagConstraints();
		gbc_btnInsert.gridwidth = 2;
		gbc_btnInsert.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsert.gridx = 6;
		gbc_btnInsert.gridy = 6;
		add(btnInsert, gbc_btnInsert);
		
		JButton btnDelete = new JButton("Excluir\r\n");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionDelete();
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridwidth = 2;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 1;
		gbc_btnDelete.gridy = 7;
		add(btnDelete, gbc_btnDelete);
	}
	
	void actionInsert() {
		
	}
	
	void actionDelete() {
		//Pegar categorias do combo box e passar para lista dentro de produto
		
		//mandar para db product
	}

}
