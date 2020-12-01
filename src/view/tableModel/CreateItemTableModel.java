package view.tableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Product;

public class CreateItemTableModel extends AbstractTableModel{

	private List<Product> items;
	private static final String names[] = {"Item"};

	public CreateItemTableModel() {
		this.items = new ArrayList<Product>();
	}
	
	public CreateItemTableModel(List<Product> items) {
		this.items = items;
	}
	
	public List<Product> getItems() {
		return items;
	}

	public void setItems(List<Product> items) {
		this.items = items;
	}
	
	public String getColumnName(int number) {
		return names[number];
	}
	
	public void removeItem(int position) {
		this.items.remove(position);
		return;
	}

	@Override
	public int getRowCount() {
		if (items != null) {
			return items.size();
		} else {
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Product item = items.get(rowIndex);
		return item.getName();
	}
	
	public Product getItem(int rowIndex) {
		return items.get(rowIndex);
	}
	
	public void addItem(Product item) {
		this.items.add(item);
		this.fireTableDataChanged();
	}
}
