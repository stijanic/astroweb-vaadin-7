package com.astroweb.comparator.view;

import java.util.Locale;
import java.util.ResourceBundle;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;

public class StartView extends VerticalLayout implements View {	

	/**
	 * 
	 */
	private static final long serialVersionUID = -9086060656406834892L;

	public StartView() {
		setMargin(true);
		setSizeFull();

		Locale locale = new Locale("sr");
		String BASE_PACKAGE="com.astroweb.comparator.i18n.Resources";
		ResourceBundle resourceBundle = ResourceBundle.getBundle(BASE_PACKAGE, locale);

		Button button = new Button(resourceBundle.getString("StartWelcome"), new Button.ClickListener() {		
			/**
			 * 
			 */
			private static final long serialVersionUID = 1570680039469218751L;

			@Override
			public void buttonClick(ClickEvent event) {
				AstroWebUI.navigator.navigateTo(AstroWebUI.NATAL_CHART_VIEW);
			}
		});
		
		addComponent(button);
		setComponentAlignment(button, Alignment.MIDDLE_CENTER);
		
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		//Notification.show("Welcome to Astro Web");
	}
}
