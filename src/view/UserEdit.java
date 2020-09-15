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

public class UserEdit {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtPassword;
	
	UserController controller = new UserController();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserEdit window = new UserEdit();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UserEdit() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlCenter = new JPanel();
		frame.getContentPane().add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("109dlu"),
				ColumnSpec.decode("60dlu"),
				ColumnSpec.decode("123dlu:grow"),},
			new RowSpec[] {
				RowSpec.decode("fill:default:grow"),
				FormSpecs.MIN_ROWSPEC,
				FormSpecs.LINE_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.LINE_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("fill:min:grow"),}));
		
		JLabel lblName = new JLabel("Nome ");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlCenter.add(lblName, "2, 2, fill, fill");
		
		txtName = new JTextField();
		pnlCenter.add(txtName, "3, 2, default, center");
		txtName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Senha ");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlCenter.add(lblPassword, "2, 4, right, default");
		
		txtPassword = new JTextField();
		pnlCenter.add(txtPassword, "3, 4, fill, default");
		txtPassword.setColumns(10);
		
		JLabel lblId = new JLabel("Id ");
		lblId.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlCenter.add(lblId, "2, 6");
		
		JLabel lblIdValue = new JLabel("0000");
		pnlCenter.add(lblIdValue, "3, 6");
		
		JPanel pnlSouth = new JPanel();
		frame.getContentPane().add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setLayout(new BorderLayout(0, 0));
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//voltar para a tela anterior
			}
		});
		pnlSouth.add(btnCancel, BorderLayout.WEST);
		
		JButton btnConfirm = new JButton("Confimar");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CreateOrUpdateUser(Integer.parseInt(lblIdValue.getText()) , txtName.getText(), txtPassword.getText());
			}
		});
		pnlSouth.add(btnConfirm, BorderLayout.EAST);
	}

}
