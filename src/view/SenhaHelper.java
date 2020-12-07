package view;

public class SenhaHelper {
	
	private static boolean CHECK;
	
	public static boolean check() {
		CHECK = false;
		new LookupCallback<Boolean>(InitialPage.getInstance(), "Login", 380, 350) {
			private static final long serialVersionUID = 1L;

			@Override
			public void addPanel() {
				add(new LoginPage(null, this));
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
