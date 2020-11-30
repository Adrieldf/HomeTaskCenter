package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.ProductDAO;
import model.Product;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class CreateItems extends JPanel implements ActionListener{
	private JTextField tfName;
	private JLabel lblTitle, lbName, lblCategorie;
	private JButton btnCreateItem;
	private GridBagLayout gridBagLayout;
	private SwitchList switchList;
	private JButton btnNewButton;
//	private GridBagConstraints gbc_btnCreateItem;
	
	
//	private GridLayout gridExterno;
//	private JList listAllCategories,listCategories;
//	private JButton btnAdd,btnRemove;
//	private JPanel panelSwitchList;
	
//	
//	private GridLayout gl = new GridLayout(1,2);
//	private JPanel p1,p2;
//	private JTable table;
//	private JScrollPane scrollPane;
	
	public CreateItems() {
		
		
//		tem que fazer algo assim
//		this.fundo = new JPanel(new BorderLayout());
//		
//		this.listaSelecao = new SwitchList();
//		this.fundo.add(this.listaSelecao);
//		
//		this.getContentPane().add(this.fundo);	
//		
//		p1 = new JPanel();
//		switchList = new SwitchList();
//		p1.add(switchList);
//		

		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 50, 30, 100, 100, 100, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 30, 30, 30, 100, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
//		p2 = new JPanel(gridBagLayout);
//		
//		setLayout(gl);
//		this.add(p1);
//		this.add(p2);
		
		setLayout(gridBagLayout);
//	
//		lblTitle = new JLabel("teste");//mudei label
//		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
//		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
//		gbc_lblTitle.gridwidth = 4;
//		gbc_lblTitle.insets = new Insets(0, 0, 5, 0);
//		gbc_lblTitle.gridx = 1;
//		gbc_lblTitle.gridy = 0;
//		add(lblTitle, gbc_lblTitle);
		
		lbName = new JLabel("Nome");
		lbName.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lbName = new GridBagConstraints();
		gbc_lbName.insets = new Insets(0, 0, 5, 5);
		gbc_lbName.gridx = 1;
		gbc_lbName.gridy = 1;
		add(lbName, gbc_lbName);
		
		tfName = new JTextField();
		GridBagConstraints gbc_tfName = new GridBagConstraints();
		gbc_tfName.gridwidth = 3;
		gbc_tfName.insets = new Insets(0, 0, 5, 5);
		gbc_tfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfName.gridx = 3;
		gbc_tfName.gridy = 1;
		add(tfName, gbc_tfName);
		tfName.setColumns(10);
		
		lblCategorie = new JLabel("Categoria");
		lblCategorie.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblCategorie = new GridBagConstraints();
		gbc_lblCategorie.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategorie.gridx = 1;
		gbc_lblCategorie.gridy = 3;
		add(lblCategorie, gbc_lblCategorie);
		
		switchList = new SwitchList();
		GridBagConstraints gbc_switchList = new GridBagConstraints();
		gbc_switchList.gridheight = 4;
		gbc_switchList.gridwidth = 3;
		gbc_switchList.fill = GridBagConstraints.BOTH;
		gbc_switchList.insets = new Insets(0, 0, 5, 5);
		gbc_switchList.gridx = 3;
		gbc_switchList.gridy = 3;
		add(switchList, gbc_switchList);
		
		btnCreateItem = new JButton("Criar item");
		btnCreateItem.addActionListener(this);
		
		btnNewButton = new JButton("Criar item");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 8;
		add(btnNewButton, gbc_btnNewButton);
		
//		scrollPane = new JScrollPane();	
//		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
//		gbc_scrollPane.gridheight = 2;
//		gbc_scrollPane.gridwidth = 2;
//		gbc_scrollPane.fill = GridBagConstraints.BOTH;
//		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
//		gbc_scrollPane.gridx = 2;
//		gbc_scrollPane.gridy = 3;
//		add(scrollPane, gbc_scrollPane);
//		
//		table = new JTable();
//		scrollPane.setViewportView(table);
//		gbc_btnCreateItem = new GridBagConstraints();
//		gbc_btnCreateItem.gridx = 3;
//		gbc_btnCreateItem.gridy = 6;
//		add(btnCreateItem, gbc_btnCreateItem);
	}
	

	
	void actionCreateItem() {
		Product newProduct = new Product();
		newProduct.setName(tfName.getText());
		//switchList.getlist2()
		
		ProductDAO podDAO = InitialPage.getInstance().getDaoFactory().getProductDAO();
		podDAO.insert(newProduct);
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==btnCreateItem) {
			actionCreateItem();		
		}
	}
	
}
