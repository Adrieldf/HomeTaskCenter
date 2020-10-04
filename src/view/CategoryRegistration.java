package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.GridBagConstraints;
import java.awt.List;
import java.awt.Insets;
import javax.swing.JSplitPane;

public class CategoryRegistration extends JPanel {
	public CategoryRegistration() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		Label label = new Label("Criar/editar categoria");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		JSplitPane splitPane = new JSplitPane();
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 2;
		add(splitPane, gbc_splitPane);
		
		List categories_list = new List();
		splitPane.setLeftComponent(categories_list);
	}

	
	
}
