package view.listModel;

import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import model.Product;
import model.User;

public class ResponsableListModel implements ListModel{
	private ArrayList<User> list,list2;
    //private ArrayList<ListDataListener> listListeners;

    public ResponsableListModel() {
        list = new ArrayList<User>();
        list2 = new ArrayList<User>();
    }
    
    public void addList1(User p){
        list.add(p);
    }
    
    public void addList2(User p){
        list2.add(p);
    }
    
    public void removeList1(User p){
        list.remove(p);
    }
    
    public void removeList2(User p){
        list2.remove(p);
    }
    
    @Override
    public int getSize() {
        return list.size();
    }
    
    public int getSizeList2() {
        return list2.size();
    }

    @Override
    public Object getElementAt(int index) {
        return list.get(index);
    }

    public Object getElementAtList2(int index) {
        return list2.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
       //
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        //
    }
    
    public void list1ToList2() {
    	list2.clear();
    	for(User p : list) {
    		list2.add(p);
    	}
    	list.clear();
    }
    
    public void list2ToList1() {
    	list.clear();
    	for(User p : list2) {
    		list.add(p);
    	}
    	list2.clear();
    }
}
