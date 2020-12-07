package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

//import br.com.fgti.pub.util.SwingUtil;

public abstract class LookupCallback<E> extends JDialog {

	public LookupCallback(String name) {
		this(null, name, 800, 600);
	}
	
	public LookupCallback(JFrame frame, String name) {
		this(frame, name, 800, 600);
	}
	
	public LookupCallback(String name, int width, int height) {
		this(null, name, width, height);
	}
	
	public LookupCallback(JFrame frame, String name, int width, int height) {
		super(frame, name , true);
		addPanel();
		setSize(width,height);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//		SwingUtil.centralize(this);
		
		this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "escape");
		this.getRootPane().getActionMap().put("escape", new AbstractAction(){
	         @Override
	         public void actionPerformed(ActionEvent e){
	        	 LookupCallback.this.dispose();
	         }
	    });
		
		setVisible(true);
	}
	
	protected abstract void addPanel();
	public abstract void callback(E e);
}
