package test;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBox;
import java.awt.Insets;

public class WindowBuilderTest extends JPanel {
	public WindowBuilderTest() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JCheckBox chckbx1 = new JCheckBox("ChBox 1");
		GridBagConstraints gbc_chckbx1 = new GridBagConstraints();
		gbc_chckbx1.insets = new Insets(0, 0, 5, 5);
		gbc_chckbx1.gridx = 1;
		gbc_chckbx1.gridy = 2;
		add(chckbx1, gbc_chckbx1);
		
		JCheckBox chckbx2 = new JCheckBox("ChBox 1");
		GridBagConstraints gbc_chckbx2 = new GridBagConstraints();
		gbc_chckbx2.anchor = GridBagConstraints.NORTH;
		gbc_chckbx2.insets = new Insets(0, 0, 5, 5);
		gbc_chckbx2.gridx = 1;
		gbc_chckbx2.gridy = 3;
		add(chckbx2, gbc_chckbx2);
		
		JButton btnAlterar = new JButton("Alterar");
		GridBagConstraints gbc_btnAlterar = new GridBagConstraints();
		gbc_btnAlterar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAlterar.gridx = 1;
		gbc_btnAlterar.gridy = 7;
		add(btnAlterar, gbc_btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.gridx = 4;
		gbc_btnExcluir.gridy = 7;
		add(btnExcluir, gbc_btnExcluir);
	}

}
