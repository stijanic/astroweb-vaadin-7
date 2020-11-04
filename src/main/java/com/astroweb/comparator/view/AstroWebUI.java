package com.astroweb.comparator.view;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

/**
 *
 */
@Theme("astrowebtheme")
@Widgetset("com.astroweb.comparator.AstroWebAppWidgetset")
public class AstroWebUI extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8333681812648541893L;
	protected static final String START_VIEW = "StartView";
	protected static final String REGISTER_VIEW = "RegisterView";
	protected static final String LOGIN_VIEW = "LoginView";
	protected static final String NATAL_CHART_VIEW = "NatalChartView";
	protected static final String SEARCH_VIEW = "SearchView";

	// Create a navigator to control views
	protected static Navigator navigator;
	
	public AstroWebUI() {
	}
	
	@Override
    protected void init(VaadinRequest vaadinRequest) {
		// Create and register views
		navigator = new Navigator(this, this);
		navigator.addView(START_VIEW, new StartView());
		navigator.addView(REGISTER_VIEW, new RegisterView());
		navigator.addView(LOGIN_VIEW, new LoginView());
		navigator.addView(NATAL_CHART_VIEW, new NatalChartView());
		navigator.addView(SEARCH_VIEW, new SearchView());
		navigator.navigateTo(START_VIEW);
    }

    @WebServlet(urlPatterns = "/*", name = "AstroWebUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = AstroWebUI.class, productionMode = false)
    public static class AstroWebUIServlet extends VaadinServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = 6498171779531775112L;
    }
}
