package com.astroweb.comparator.view;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.astroweb.comparator.model.Celestial;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class SearchView extends VerticalLayout implements View {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2204886349236928837L;

	@Override
	public void enter(ViewChangeEvent event) {
		setMargin(true);
		addComponent(new Label("Test"));

	    // Testing Resources.properties
		Locale locale = new Locale("sr", "RS");
		String BASE_PACKAGE="com.astroweb.i18n.Resources";
		ResourceBundle resources = ResourceBundle.getBundle(BASE_PACKAGE, locale);
		Label aries = new Label(resources.getString("Ari"));
	    addComponent(aries);
	    
        // Get Celestials from database thanks to Hibernate
        
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

        Session session = sessionFactory.openSession();

        Query query = session.createQuery("from Celestial where id = :id order by id");
        query.setParameter("id", 5);

        List<?> list = query.list();
        Celestial celestial = (Celestial)list.get(0);

        query = session.createQuery("from Celestial");
        list = query.list();
        for (int i = 0; i < list.size(); i++) {
        	celestial = (Celestial)list.get(i);
        	addComponent(new Label(resources.getString(celestial.getName()) + " " + celestial.getDescription()));
        }
       
        sessionFactory.close();
	}
}
