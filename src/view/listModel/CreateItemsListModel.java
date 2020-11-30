package view.listModel;

import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class CreateItemsListModel implements ListModel{

	private ArrayList list;
    private ArrayList<ListDataListener> listListeners;

    public CreateItemsListModel() {
        list = new ArrayList();
        listListeners = new ArrayList();
    }
    
    public void addElement(Object element){
        list.add(element);
    }
    
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Object getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        list.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        list.remove(l);
    }
	    

}
