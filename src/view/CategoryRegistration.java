package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CategoryRegistration extends JPanel {
	private JTable table;
	private JTextField name;
	public CategoryRegistration() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 100, 100, 0, 50, 0, 100, 100, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		Label title = new Label("Criar/editar categoria");
		title.setFont(new Font("Dialog", Font.BOLD, 17));
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.gridwidth = 7;
		gbc_title.insets = new Insets(0, 0, 5, 5);
		gbc_title.gridx = 1;
		gbc_title.gridy = 0;
		add(title, gbc_title);
		
		JLabel lbCategories = new JLabel("Categorias");
		lbCategories.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lbCategories = new GridBagConstraints();
		gbc_lbCategories.gridwidth = 2;
		gbc_lbCategories.insets = new Insets(0, 0, 5, 5);
		gbc_lbCategories.gridx = 1;
		gbc_lbCategories.gridy = 2;
		add(lbCategories, gbc_lbCategories);
		
		JLabel lbName = new JLabel("Nome");
		lbName.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lbName = new GridBagConstraints();
		gbc_lbName.insets = new Insets(0, 0, 5, 5);
		gbc_lbName.gridx = 4;
		gbc_lbName.gridy = 2;
		add(lbName, gbc_lbName);
		
		name = new JTextField();
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.gridwidth = 2;
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_name.gridx = 6;
		gbc_name.gridy = 2;
		add(name, gbc_name);
		name.setColumns(10);
		
		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 2;
		gbc_table.gridheight = 3;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 4;
		add(table, gbc_table);
		
		JButton btnNewCategorie = new JButton("Criar categoria");
		btnNewCategorie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewCategorie = new GridBagConstraints();
		gbc_btnNewCategorie.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewCategorie.gridx = 6;
		gbc_btnNewCategorie.gridy = 4;
		add(btnNewCategorie, gbc_btnNewCategorie);
		
		JButton btnBack = new JButton("Voltar");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.EAST;
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 7;
		gbc_btnBack.gridy = 4;
		add(btnBack, gbc_btnBack);
		
		JButton btnDelete = new JButton("Excluir");
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridwidth = 2;
		gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete.gridx = 1;
		gbc_btnDelete.gridy = 8;
		add(btnDelete, gbc_btnDelete);
	}

	
	
}
