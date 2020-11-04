package com.astroweb.comparator.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class RegisterView extends VerticalLayout implements View {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6163975014289100835L;

	@Override
	public void enter(ViewChangeEvent event) {
		setMargin(true);

	}
}
