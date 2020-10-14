package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.UserController;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;

public class UserEdit extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	
	public UserEdit() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 0, 0, 100, 100, 100, 30, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel("Criar/editar usu\u00E1rio");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 7;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		add(lblTitle, gbc_lblTitle);
		
		JLabel lblName = new JLabel("Nome");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 2;
		add(lblName, gbc_lblName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Senha");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 4;
		add(lblPassword, gbc_lblPassword);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 4;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton btnCreateUser = new JButton("Criar usu\u00E1rio");
		btnCreateUser.setForeground(Color.BLACK);
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnCreateUser = new GridBagConstraints();
		gbc_btnCreateUser.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateUser.gridx = 3;
		gbc_btnCreateUser.gridy = 6;
		add(btnCreateUser, gbc_btnCreateUser);
		
		JButton btnSearch = new JButton("Buscar");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.anchor = GridBagConstraints.EAST;
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 4;
		gbc_btnSearch.gridy = 6;
		add(btnSearch, gbc_btnSearch);
		
		JButton btnUpdate = new JButton("Alterar");
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdate.gridx = 5;
		gbc_btnUpdate.gridy = 6;
		add(btnUpdate, gbc_btnUpdate);
		
	}
	
	

//	private JFrame frame;
//	private JTextField txtName;
//	private JTextField txtPassword;
//	
//	UserController controller = new UserController();
//	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserEdit window = new UserEdit();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	public UserEdit() {
//		initialize();
//	}
//
//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(new BorderLayout(0, 0));
//		
//		JPanel pnlCenter = new JPanel();
//		frame.getContentPane().add(pnlCenter, BorderLayout.CENTER);
//		pnlCenter.setLayout(new FormLayout(new ColumnSpec[] {
//				ColumnSpec.decode("109dlu"),
//				ColumnSpec.decode("60dlu"),
//				ColumnSpec.decode("123dlu:grow"),},
//			new RowSpec[] {
//				RowSpec.decode("fill:default:grow"),
//				FormSpecs.MIN_ROWSPEC,
//				FormSpecs.LINE_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.LINE_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				RowSpec.decode("fill:min:grow"),}));
//		
//		JLabel lblName = new JLabel("Nome ");
//		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
//		pnlCenter.add(lblName, "2, 2, fill, fill");
//		
//		txtName = new JTextField();
//		pnlCenter.add(txtName, "3, 2, default, center");
//		txtName.setColumns(10);
//		
//		JLabel lblPassword = new JLabel("Senha ");
//		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
//		pnlCenter.add(lblPassword, "2, 4, right, default");
//		
//		txtPassword = new JTextField();
//		pnlCenter.add(txtPassword, "3, 4, fill, default");
//		txtPassword.setColumns(10);
//		
//		JLabel lblId = new JLabel("Id ");
//		lblId.setHorizontalAlignment(SwingConstants.TRAILING);
//		pnlCenter.add(lblId, "2, 6");
//		
//		JLabel lblIdValue = new JLabel("0000");
//		pnlCenter.add(lblIdValue, "3, 6");
//		
//		JPanel pnlSouth = new JPanel();
//		frame.getContentPane().add(pnlSouth, BorderLayout.SOUTH);
//		pnlSouth.setLayout(new BorderLayout(0, 0));
//		
//		JButton btnCancel = new JButton("Cancelar");
//		btnCancel.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				//voltar para a tela anterior
//			}
//		});
//		pnlSouth.add(btnCancel, BorderLayout.WEST);
//		
//		JButton btnConfirm = new JButton("Confimar");
//		btnConfirm.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				controller.CreateOrUpdateUser(Integer.parseInt(lblIdValue.getText()) , txtName.getText(), txtPassword.getText());
//			}
//		});
//		pnlSouth.add(btnConfirm, BorderLayout.EAST);
//	}

}
