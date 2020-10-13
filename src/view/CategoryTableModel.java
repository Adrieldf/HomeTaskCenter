package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Category;

public class CategoryTableModel extends AbstractTableModel {

	private List<Category> categories;
	private static final String names[] = {"Category"};

	public CategoryTableModel() {
		this.categories = new ArrayList<Category>();
	}
	
	public CategoryTableModel(List<Category> categories) {
		this.categories = categories;
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public String getColumnName(int number) {
		return names[number];
	}

	@Override
	public int getRowCount() {
		if (categories != null) {
			return categories.size();
		} else {
			return 0;
		}
	}
	public void actionPerformed(ActionEvent e) {
		actionNewCategorie();
	}
});
	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Category category = categories.get(rowIndex);
		return category.getName();
	}
	
	public Category getCategory(int rowIndex) {
		return categories.get(rowIndex);
	}
	
	public void addCategory(Category category) {
		this.categories.add(category);
		this.fireTableDataChanged();
	}

}