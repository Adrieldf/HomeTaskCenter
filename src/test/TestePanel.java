package test;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;


public class TestePanel extends JPanel {
	private JTextField textField;

	public TestePanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTeste = new JLabel("Teste");
		GridBagConstraints gbc_lblTeste = new GridBagConstraints();
		gbc_lblTeste.insets = new Insets(0, 0, 0, 5);
		gbc_lblTeste.anchor = GridBagConstraints.EAST;
		gbc_lblTeste.gridx = 0;
		gbc_lblTeste.gridy = 0;
		add(lblTeste, gbc_lblTeste);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);}
	
}
