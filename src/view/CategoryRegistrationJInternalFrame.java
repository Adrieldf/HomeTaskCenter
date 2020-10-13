package view;

import javax.swing.JInternalFrame;

public class CategoryRegistrationJInternalFrame extends JInternalFrame{
	
	public CategoryRegistrationJInternalFrame() {
		this.getContentPane().add(new CategoryRegistration());
		this.setTitle("categoria");
		this.setSize(400,500);
		
		//setar visivel depois
	}

	
}
