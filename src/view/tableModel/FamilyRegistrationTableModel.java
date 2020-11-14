package view.tableModel;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Category;
import model.User;

public class FamilyRegistrationTableModel extends AbstractTableModel {

	private List<User> members;
	
	//nao lembro pra que serve
	//vetor de nomes de colunas
	private static final String names[] = {"Family"};

	public FamilyRegistrationTableModel() {
		this.members = new ArrayList<User>();
	}
	
	public FamilyRegistrationTableModel(List<User> members) {
		this.members = members;
	}
	
	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}
	
	public String getColumnName(int number) {
		return names[number];
	}
	
	public void removeMember(int position) {
		this.members.remove(position);
		return;
	}

	@Override
	public int getRowCount() {
		if (members != null) {
			return members.size();
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
		User member = members.get(rowIndex);
		return member.getName();
	}
	
	public User getMember(int rowIndex) {
		return members.get(rowIndex);
	}
	
	public void addMember(User member) {
		this.members.add(member);
		this.fireTableDataChanged();
	}

}