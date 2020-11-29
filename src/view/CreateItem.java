package view;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class CreateItem extends JFrame implements ActionListener{

	private JTextField tfName;
	private JCheckBox chckbxCategory;//substituir
	private JLabel lblTitle, lbName, lblCategorie;
	private JButton btnCreateItem;
	private GridBagLayout gridBagLayout;
	private GridBagConstraints gbc_chckbxCategory,gbc_btnCreateItem;
	
	
	private GridLayout gridExterno;
	private JList listAllCategories,listCategories;
	private JButton btnAdd,btnRemove;
	private JPanel panelSwitchList;
	
	private SwitchList switchList;
	
	private GridLayout gl = new GridLayout(1,2);
	private JPanel p1,p2;
	
	//http://dev.cs.ovgu.de/java/forms/docs/tutorial/quickstart.html
	public CreateItem() {
		
		
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
