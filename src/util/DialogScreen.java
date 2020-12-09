package util;

import view.InitialPage;
import view.LoginPage;

public class DialogScreen {
	
	private static boolean CHECK;
	
	public static boolean check() {
		CHECK = false;
		new LookupCallback<Boolean>(InitialPage.getInstance(), "Home Task Center", 380, 350) {
			private static final long serialVersionUID = 1L;

			@Override
			public void addPanel() {
				add(new LoginPage(InitialPage.getInstance().getUser(), this));
				
			}

			@Override
			public void callback(Boolean e) {
				if (e) {
					CHECK = true;
				}
				dispose();
			}
		};
		return CHECK;
	}
	

}
