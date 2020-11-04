package com.astroweb.comparator.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class LoginView extends VerticalLayout implements View {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1645926622154613955L;

	@Override
	public void enter(ViewChangeEvent event) {
		setMargin(true);

	}
}
