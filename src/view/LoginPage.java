package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.UserDAO;
import model.User;
import security.Criptography;

public class LoginPage extends JPanel implements ActionListener {
	private JTextField tfName, tfPassword;
	private boolean valid;
	private JLabel lbTitle, lbName, lbPassword;
	private JButton btnLogin, btnCancel;

	private JButton btnUserEdit;

	private User user = null;

	
	public LoginPage(User user) {
		
		this.user = user;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 30, 30, 100, 100, 30, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lbTitle = new JLabel("Login");
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lbTitle = new GridBagConstraints();
		gbc_lbTitle.gridwidth = 7;
		gbc_lbTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lbTitle.gridx = 0;
		gbc_lbTitle.gridy = 1;
		add(lbTitle, gbc_lbTitle);

		lbName = new JLabel("Nome");
		lbName.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lbName = new GridBagConstraints();
		gbc_lbName.insets = new Insets(0, 0, 5, 5);
		gbc_lbName.gridx = 1;
		gbc_lbName.gridy = 3;
		add(lbName, gbc_lbName);

		tfName = new JTextField();
		GridBagConstraints gbc_tfName = new GridBagConstraints();
		gbc_tfName.gridwidth = 2;
		gbc_tfName.insets = new Insets(0, 0, 5, 5);
		gbc_tfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfName.gridx = 3;
		gbc_tfName.gridy = 3;
		add(tfName, gbc_tfName);
		tfName.setColumns(10);

		lbPassword = new JLabel("Senha");
		lbPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lbPassword = new GridBagConstraints();
		gbc_lbPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lbPassword.gridx = 1;
		gbc_lbPassword.gridy = 5;
		add(lbPassword, gbc_lbPassword);

		tfPassword = new JTextField();
		tfPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_tfPassword = new GridBagConstraints();
		gbc_tfPassword.gridwidth = 2;
		gbc_tfPassword.insets = new Insets(0, 0, 5, 5);
		gbc_tfPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPassword.gridx = 3;
		gbc_tfPassword.gridy = 5;
		add(tfPassword, gbc_tfPassword);
		tfPassword.setColumns(10);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(this);
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.gridwidth = 2;
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 2;
		gbc_btnLogin.gridy = 7;
		add(btnLogin, gbc_btnLogin);

		btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(this);
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.anchor = GridBagConstraints.EAST;
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 4;
		gbc_btnCancel.gridy = 7;
		add(btnCancel, gbc_btnCancel);
		
		btnUserEdit = new JButton("Criar usuário");
		GridBagConstraints gbc_btnUserEdit = new GridBagConstraints();
		gbc_btnUserEdit.gridwidth = 2;
		gbc_btnUserEdit.insets = new Insets(0, 0, 5, 5);
		gbc_btnUserEdit.gridx = 3;
		gbc_btnUserEdit.gridy = 9;
		add(btnUserEdit, gbc_btnUserEdit);
	}

	void actionLogin() {

		UserDAO userDAO = InitialPage.getInstance().getDaoFactory().getUserDAO();
		User user = userDAO.getByName(tfName.getText());
		if (user != null && user.getPassword().equals(Criptography.Encode(tfPassword.getText()).toString())) {
			JOptionPane.showMessageDialog(null, "Login realizado com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
			// definir a variavel do usuario que vai ser usada nas demais telas
			this.user = user;
			// fecha a tela de login
		} else {
			JOptionPane.showMessageDialog(null, "Dados informados não conferem, verifique e tente novamente.", "Erro",
					JOptionPane.INFORMATION_MESSAGE);
			// deixa a tela de login aberta para tentar de novo
		}

	}

	void actionCancel() {
		JInternalFrame jif = (JInternalFrame) this.getParent();
		jif.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == btnLogin) {
			actionLogin();
		} else {
			if (arg0.getSource() == btnCancel) {
				actionCancel();
			}
		}
	}

}
