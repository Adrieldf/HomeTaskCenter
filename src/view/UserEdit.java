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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.FamilyDAO;
import dao.UserDAO;
import model.Family;
import model.User;

public class UserEdit extends JPanel implements ActionListener {
	private JTextField tfName;
	private JTextField tfPassword;
	private JLabel lblTitle, lblName, lblPassword;
	private JButton btnCreateUser, btnSearch, btnUpdate;
	private JLabel lblMail;

	private JTextField tfMail;
	private JLabel lblFamily;
	private JTextField tfFamily;

	private User user;
	private Family fam;
	private boolean flagNew = false;
	
	private UserDAO userDB   = InitialPage.getInstance().getDaoFactory().getUserDAO();
	private FamilyDAO famDAO = InitialPage.getInstance().getDaoFactory().getFamilyDAO();
	
	public UserEdit(User user) {
		
		if(user==null) {
			this.user = new User();
			fam = new Family();
			flagNew = true;
		}else {
			this.user = user;
			fam = famDAO.getById(user.getIdFamily());
		}
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths  = new int[]{40, 30, 30, 100, 100, 100, 30, 0};
		gridBagLayout.rowHeights    = new int[]{30, 30, 30, 30, 20, 30, 20, 30, 20, 30, 20, 30, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights    = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 3;
		add(lblName, gbc_lblName);
		
		tfName = new JTextField();
		GridBagConstraints gbc_tfName = new GridBagConstraints();
		gbc_tfName.gridwidth = 3;
		gbc_tfName.insets = new Insets(0, 0, 5, 5);
		gbc_tfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfName.gridx = 3;
		gbc_tfName.gridy = 3;
		add(tfName, gbc_tfName);
		tfName.setColumns(10);
		
		lblMail = new JLabel("E-mail");
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblMail = new GridBagConstraints();
		gbc_lblMail.anchor = GridBagConstraints.WEST;
		gbc_lblMail.insets = new Insets(0, 0, 5, 5);
		gbc_lblMail.gridx = 1;
		gbc_lblMail.gridy = 5;
		add(lblMail, gbc_lblMail);
		
		tfMail = new JTextField();
		GridBagConstraints gbc_tfMail = new GridBagConstraints();
		gbc_tfMail.gridwidth = 3;
		gbc_tfMail.insets = new Insets(0, 0, 5, 5);
		gbc_tfMail.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMail.gridx = 3;
		gbc_tfMail.gridy = 5;
		add(tfMail, gbc_tfMail);
		tfMail.setColumns(10);
		
		lblPassword = new JLabel("Senha");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 7;
		add(lblPassword, gbc_lblPassword);
		
		tfPassword = new JTextField();
		GridBagConstraints gbc_tfPassword = new GridBagConstraints();
		gbc_tfPassword.gridwidth = 3;
		gbc_tfPassword.insets = new Insets(0, 0, 5, 5);
		gbc_tfPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPassword.gridx = 3;
		gbc_tfPassword.gridy = 7;
		add(tfPassword, gbc_tfPassword);
		tfPassword.setColumns(10);
		
		btnCreateUser = new JButton("Criar usu\u00E1rio");
		btnCreateUser.setForeground(Color.BLACK);
		btnCreateUser.addActionListener(this);
		
		lblFamily = new JLabel("Nome da família");
		lblFamily.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblFamily = new GridBagConstraints();
		gbc_lblFamily.anchor = GridBagConstraints.WEST;
		gbc_lblFamily.insets = new Insets(0, 0, 5, 5);
		gbc_lblFamily.gridx = 1;
		gbc_lblFamily.gridy = 9;
		add(lblFamily, gbc_lblFamily);
		
		tfFamily = new JTextField();
		GridBagConstraints gbc_tfFamily = new GridBagConstraints();
		gbc_tfFamily.gridwidth = 3;
		gbc_tfFamily.insets = new Insets(0, 0, 5, 5);
		gbc_tfFamily.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFamily.gridx = 3;
		gbc_tfFamily.gridy = 9;
		add(tfFamily, gbc_tfFamily);
		tfFamily.setColumns(10);
		GridBagConstraints gbc_btnCreateUser = new GridBagConstraints();
		gbc_btnCreateUser.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateUser.gridx = 3;
		gbc_btnCreateUser.gridy = 11;
		add(btnCreateUser, gbc_btnCreateUser);
		
		btnSearch = new JButton("Buscar");
		btnSearch.addActionListener(this);
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.anchor = GridBagConstraints.EAST;
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 4;
		gbc_btnSearch.gridy = 11;
		add(btnSearch, gbc_btnSearch);
		
		btnUpdate = new JButton("Alterar");
		btnUpdate.addActionListener(this);
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdate.gridx = 5;
		gbc_btnUpdate.gridy = 11;
		add(btnUpdate, gbc_btnUpdate);
		
	}
	
	
	void actionCreateUser() {
		User newUser = new User();
		newUser.setName(tfName.getText());
		newUser.setPassword(tfPassword.getText());
		newUser.setEmail(tfMail.getText());
		fam.addMember(newUser);
		if(flagNew) {
			fam.setName(tfFamily.getText());
			famDAO.insert(fam);
			newUser.setIdFamily(famDAO.getMaxId());
		}else {
			newUser.setIdFamily(fam.getId());
		}
		userDB.insert(newUser);
		newUser.setId(userDB.getMaxId());
		JOptionPane.showMessageDialog(null, "Usuário criado com sucesso!", "Sucesso",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	void actionSearch() {
		User user1 = userDB.getByName(tfName.getText());
		tfName.setText(user1.getName());
		tfPassword.setText(user1.getPassword());
		tfMail.setText(user1.getEmail());
		tfFamily.setText(famDAO.getById(user1.getIdFamily()).getName());
	}

	void actionUpdate() {
		User newUser = new User();
		newUser.setName(tfName.getText());
		newUser.setPassword(tfPassword.getText());
		newUser.setEmail(tfMail.getText());
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
