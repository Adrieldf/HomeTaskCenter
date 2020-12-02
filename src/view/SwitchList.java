package view;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.listModel.CreateItemsListModel;
import view.tableModel.CategoryTableModel;

public class SwitchList extends JPanel{
	
	private JList list1, list2;
	private JButton bPuttOne, bPuttAll, bRemoveOne, bRemoveAll;
	private JScrollPane slist1, slist2;
	
	public SwitchList() {
		
		super(new GridLayout(1,3));
		list1 = new JList(new CreateItemsListModel());
		slist1 = new JScrollPane(list1);
		this.add(slist1);
		
		JPanel botoes = new JPanel(new GridLayout(4,1));
		bPuttOne = new JButton(">");
		botoes.add(bPuttOne);
		bPuttAll = new JButton(">>");
		botoes.add(bPuttAll);
		bRemoveOne = new JButton("<");
		botoes.add(bRemoveOne);
		bRemoveAll = new JButton("<<");
		botoes.add(bRemoveAll);
		this.add(botoes);
		
		list2 = new JList(new CreateItemsListModel());
		slist2 = new JScrollPane(list2);
		this.add(slist2);
		
	}

	public JList getlist1() {
		return list1;
	}

	public void setlist1(JList list1) {
		this.list1 = list1;
	}

	public JList getlist2() {
		return list2;
	}

	public void setlist2(JList list2) {
		this.list2 = list2;
	}

	public JButton getbPuttOne() {
		return bPuttOne;
	}

	public void setbPuttOne(JButton bPuttOne) {
		this.bPuttOne = bPuttOne;
	}

	public JButton getbPuttAll() {
		return bPuttAll;
	}

	public void setbPuttAll(JButton bPuttAll) {
		this.bPuttAll = bPuttAll;
	}

	public JButton getbRemoveOne() {
		return bRemoveOne;
	}

	public void setbRemoveOne(JButton bRemoveOne) {
		this.bRemoveOne = bRemoveOne;
	}

	public JButton getbRemoveAll() {
		return bRemoveAll;
	}

	public void setbRemoveAll(JButton bRemoveAll) {
		this.bRemoveAll = bRemoveAll;
	}
	
	public List getArray(JList jList) {
		List list = new ArrayList(jList.getModel().getSize());
		for (int i = 0; i < jList.getModel().getSize(); i++) {
		    list.add(jList.getModel().getElementAt(i));
		}
		return list;
	}
	

}
