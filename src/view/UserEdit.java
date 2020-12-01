package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.UserDAO;
import model.User;

public class UserEdit extends JPanel implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblTitle,lblName,lblPassword;
	private JButton btnCreateUser,btnSearch,btnUpdate;
	private JLabel lblMail;
	private JTextField textField_2;
	public UserEdit() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 30, 30, 100, 100, 100, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblTitle = new JLabel("Cadastro de Usuários");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 7;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 1;
		add(lblTitle, gbc_lblTitle);
		
		lblName = new JLabel("Nome");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 3;
		add(lblName, gbc_lblName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 3;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblMail = new JLabel("E-mail");
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblMail = new GridBagConstraints();
		gbc_lblMail.insets = new Insets(0, 0, 5, 5);
		gbc_lblMail.gridx = 1;
		gbc_lblMail.gridy = 5;
		add(lblMail, gbc_lblMail);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 5;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		lblPassword = new JLabel("Senha");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 7;
		add(lblPassword, gbc_lblPassword);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 7;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		btnCreateUser = new JButton("Criar usu\u00E1rio");
		btnCreateUser.setForeground(Color.BLACK);
		btnCreateUser.addActionListener(this);
		GridBagConstraints gbc_btnCreateUser = new GridBagConstraints();
		gbc_btnCreateUser.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateUser.gridx = 3;
		gbc_btnCreateUser.gridy = 9;
		add(btnCreateUser, gbc_btnCreateUser);
		
		btnSearch = new JButton("Buscar");
		btnSearch.addActionListener(this);
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.anchor = GridBagConstraints.EAST;
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 4;
		gbc_btnSearch.gridy = 9;
		add(btnSearch, gbc_btnSearch);
		
		btnUpdate = new JButton("Alterar");
		btnUpdate.addActionListener(this);
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdate.gridx = 5;
		gbc_btnUpdate.gridy = 9;
		add(btnUpdate, gbc_btnUpdate);
		
	}
	
	
	void actionCreateUser() {
		User newUser = new User();
		newUser.setName(textField.getText());
		newUser.setPassword(textField_1.getText());
		UserDAO userDB = InitialPage.getInstance().getDaoFactory().getUserDAO();
		userDB.insert(newUser);
	}
	
	void actionSearch() {
		UserDAO userDB = InitialPage.getInstance().getDaoFactory().getUserDAO();
		User user1 = userDB.getByName(textField.getText());
		textField.setText(user1.getName());
		textField_1.setText(user1.getPassword());
	}

	void actionUpdate() {
		User newUser = new User();
		UserDAO userDB = InitialPage.getInstance().getDaoFactory().getUserDAO();
		newUser.setName(textField.getText());
		newUser.setPassword(textField_1.getText());
		userDB.edit(newUser);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==btnCreateUser) {
			actionCreateUser();
		} else {
			if(arg0.getSource()==btnSearch) {
				actionSearch();
			} else {
				if(arg0.getSource()==btnUpdate) {
					actionUpdate();
				}
			}
		}
	}
}
