package view.listModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import model.Product;

public class ProductListModel implements ListModel{

	private ArrayList<Product> list;
	//private ArrayList<Product> list2;
    //private ArrayList<ListDataListener> listListeners;

    public ProductListModel() {
        list = new ArrayList<Product>();
        //list2 = new ArrayList<Product>();
    }
    
    public ProductListModel(List l1) {
        list = (ArrayList<Product>) l1;
        //list2 = (ArrayList<Product>) l2;
    }
    
    public void addList1(Product p){
        list.add(p);
    }
    
//    public void addList2(Product p){
//        list2.add(p);
//    }
    
    public void removeList1(Product p){
        list.remove(p);
    }
    
    public void clearList1(){
        list.clear();
    }
    
//    public void removeList2(Product p){
//        list2.remove(p);
//    }
    
    @Override
    public int getSize() {
        return list.size();
    }
    
//    public int getSizeList2() {
//        return list2.size();
//    }

    @Override
    public Object getElementAt(int index) {
        return list.get(index);
    }

//    public Object getElementAtList2(int index) {
//        return list2.get(index);
//    }

    @Override
    public void addListDataListener(ListDataListener l) {
       //
    }
    @Override
    public void removeListDataListener(ListDataListener l) {
        //
    }
    

    
//    public void list2ToList1() {
//    	list.clear();
//    	for(Product p : list2) {
//    		list.add(p);
//    	}
//    	list2.clear();
//    }
}
