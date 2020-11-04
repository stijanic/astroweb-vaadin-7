package com.astroweb.comparator.view;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification.Type;

import org.geonames.Style;
import org.geonames.Toponym;
import org.geonames.ToponymSearchCriteria;
import org.geonames.ToponymSearchResult;
import org.geonames.WebService;

import swisseph.SwissephException;

import com.astroweb.comparator.calculators.CompatibilityCalculator;
import com.astroweb.comparator.calculators.NatalChartCalculator;


public class NatalChartView extends VerticalLayout implements View {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6550232434038308127L;

	@Override
	public void enter(ViewChangeEvent event) {	
		setMargin(true);
		
		final Locale locale = new Locale("sr");
		String BASE_PACKAGE="com.astroweb.comparator.i18n.Resources";
		final ResourceBundle resources = ResourceBundle.getBundle(BASE_PACKAGE, locale);

		//Place Layout
		VerticalLayout verticalLayoutLocation = new VerticalLayout(); 
		verticalLayoutLocation.addComponent(new Label(resources.getString("InputLocation")));
		final TextField textField = new TextField();	
		verticalLayoutLocation.addComponent(textField);
		
		//Date Layout
		VerticalLayout verticalLayoutDate = new VerticalLayout();
	    verticalLayoutDate.addComponent(new Label(resources.getString("InputDate")));    
	    final DateField dateField = new DateField();
	    dateField.setResolution(Resolution.MINUTE);
	    dateField.setLocale(locale);
	    dateField.setImmediate(true);
	    verticalLayoutDate.addComponent(dateField);

	    //Calculate Layout
	    VerticalLayout verticalLayoutCalculate = new VerticalLayout();
	    verticalLayoutCalculate.addComponent(new Label(""));
		Button button = new Button(resources.getString("Calculate"));
		verticalLayoutCalculate.addComponent(button);

		// Horizontal Layout
		HorizontalLayout horizontalLayout = new HorizontalLayout();
	    horizontalLayout.addComponent(verticalLayoutLocation);
	    horizontalLayout.addComponent(verticalLayoutDate);
	    horizontalLayout.addComponent(verticalLayoutCalculate);
	    
	    horizontalLayout.setSpacing(true);
	    horizontalLayout.setComponentAlignment(verticalLayoutDate, Alignment.MIDDLE_LEFT);
	    horizontalLayout.setComponentAlignment(verticalLayoutLocation, Alignment.MIDDLE_CENTER);
	    horizontalLayout.setComponentAlignment(verticalLayoutCalculate, Alignment.MIDDLE_RIGHT);
	    
	    addComponent(horizontalLayout);
	    setComponentAlignment(horizontalLayout, Alignment.MIDDLE_CENTER);

		// Create tables
        HorizontalLayout horizontalLayoutResult = new HorizontalLayout();

        // Table Planets
        final Table tablePlanets = new Table();
        tablePlanets.setVisible(false);
        tablePlanets.setWidth(100, Sizeable.Unit.PERCENTAGE);
        tablePlanets.setHeight(100, Sizeable.Unit.PERCENTAGE);
        tablePlanets.setPageLength(10);
        horizontalLayoutResult.addComponent(tablePlanets);
        horizontalLayoutResult.setComponentAlignment(tablePlanets, Alignment.MIDDLE_RIGHT);
        horizontalLayoutResult.setComponentAlignment(tablePlanets, Alignment.TOP_LEFT);
        
        // Table Houses
        final Table tableHouses = new Table();
        tableHouses.setVisible(false);
        tableHouses.setWidth(100, Sizeable.Unit.PERCENTAGE);
        tableHouses.setHeight(100, Sizeable.Unit.PERCENTAGE);
        tableHouses.setPageLength(12);
        horizontalLayoutResult.addComponent(tableHouses);
        horizontalLayoutResult.setComponentAlignment(tableHouses, Alignment.MIDDLE_LEFT);
        horizontalLayoutResult.setComponentAlignment(tablePlanets, Alignment.TOP_RIGHT);
        
        addComponent(horizontalLayoutResult);
        horizontalLayoutResult.setSpacing(true);
        horizontalLayoutResult.setMargin(true);
        horizontalLayoutResult.setWidth(85, Sizeable.Unit.PERCENTAGE);
        setComponentAlignment(horizontalLayoutResult, Alignment.MIDDLE_CENTER);
	    
        // Calculate
	    button.addClickListener(new ClickListener() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 6689533527564498069L;

			@Override
			public void buttonClick(ClickEvent event) {
				
    			if (textField.getValue().equals("") || dateField.getValue() == null) {
    				Notification.show(resources.getString("ERROR"), resources.getString("CheckInputs"), Type.TRAY_NOTIFICATION);
    				return;
    			}
    			
	    		try {
	    			
	    			ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
	    			searchCriteria.setQ(textField.getValue());		

	    			WebService.setUserName("stijanic");
	    			WebService.setDefaultStyle(Style.FULL);
	    			ToponymSearchResult searchResult = WebService.search(searchCriteria);
	    			
	    			List<Toponym> toponyms = searchResult.getToponyms();
	    			
	    			Toponym toponym;
	    			if (toponyms.size() > 0) {
	    				toponym = toponyms.get(0);

		    			Date birthDate = (Date) dateField.getValue(); 
		    			
		    			String timeZoneId = "";
		    			if (toponym.getTimezone() != null) {
			    			double longitude = toponym.getLongitude();
			    			double latitude = toponym.getLatitude();
			    			
		    				timeZoneId = toponym.getTimezone().getTimezoneId();
				        	
		    				TimeZone timeZoneBirth = TimeZone.getTimeZone(timeZoneId);

		    				// Locale Calendar displayed in local language
		    				Calendar calendarLocale = new GregorianCalendar(locale);
				        	calendarLocale.setTime(birthDate);

		    				// Birth Calendar related to the birth place
				        	Calendar calendarBirth = new GregorianCalendar(timeZoneBirth);
				        	calendarBirth.set(calendarLocale.get(Calendar.YEAR),
				        				  	  calendarLocale.get(Calendar.MONTH),
				        				  	  calendarLocale.get(Calendar.DAY_OF_MONTH),
				        				  	  calendarLocale.get(Calendar.HOUR_OF_DAY),
				        				  	  calendarLocale.get(Calendar.MINUTE),
				        				  	  calendarLocale.get(Calendar.SECOND));

				        	// This Calendar is inaccurate and shouldn't be used 
				        	calendarLocale = null;
				        	
			    			// Calculate Natal Chart
			                NatalChartCalculator natalChartCalculator = new NatalChartCalculator(calendarBirth.getTime(), latitude, longitude);
			                
			                // Display result planets
			                tablePlanets.removeAllItems();
			                tablePlanets.setVisible(true);
			                tablePlanets.setImmediate(true);

			                tablePlanets.addContainerProperty(resources.getString("Planet"), String.class, null);
			                tablePlanets.addContainerProperty(resources.getString("Sign"), String.class, null);
			                tablePlanets.addContainerProperty("", Double.class, null);
			                for (int i = 0; i < natalChartCalculator.getPlanetsLongitudes().length; i++) {
			                	tablePlanets.addItem(new Object[]{resources.getString(natalChartCalculator.getPlanetName(i)),
			                									  resources.getString(natalChartCalculator.getAstrologicalSignName(natalChartCalculator.getPlanetsLongitudes()[i])),
			                						  			  natalChartCalculator.getPlanetsLongitudes()[i]}, i);
			                }

			                // Display result houses
			                tableHouses.removeAllItems();
			                tableHouses.setVisible(true);
			                tableHouses.setImmediate(true);

			                tableHouses.addContainerProperty(resources.getString("House"), Integer.class, null);
			                tableHouses.addContainerProperty(resources.getString("Sign"), String.class, null);
			                tableHouses.addContainerProperty("", Double.class, null);

			                for (int i = 1; i < natalChartCalculator.getHousesLongitudes().length; i++) {
			                	tableHouses.addItem(new Object[]{i,
			                									 resources.getString(natalChartCalculator.getAstrologicalSignName(natalChartCalculator.getHousesLongitudes()[i])),
			                									 natalChartCalculator.getHousesLongitudes()[i]}, i);
			                }

			                // Checking compatibility with himself/herself - relation friendship
			                CompatibilityCalculator compatibilityCalculator = new CompatibilityCalculator();
			                double result = compatibilityCalculator.calculateAspects(natalChartCalculator, natalChartCalculator, '1');
			                
			                Notification.show("Compatibility Friendship", Double.toString(result), Type.TRAY_NOTIFICATION);
			                
				            //Notification.show(timeZoneId, toponym.getCountryName() + " " + toponym.getCountryCode() + "\n" + calendarBirth.getTime() + "\n" + longitude + "° " + latitude + "°" + "\n" + toponym.getName(), Type.TRAY_NOTIFICATION);			            
		    			}
	    			} else {
	    				Notification.show(resources.getString("ERROR"), resources.getString("CheckInputs"), Type.TRAY_NOTIFICATION);
	    			}
	            } catch (SwissephException swissephe) {
	            	// Something went wrong, user has to be notified.
	            	Notification.show(resources.getString("ERROR"), resources.getString("CheckInputs"), Type.TRAY_NOTIFICATION);
	            	swissephe.printStackTrace();
	            } catch (Exception e) {
	            	// Something went wrong, user has to be notified.
	            	Notification.show(resources.getString("ERROR"), resources.getString("CheckInputs"), Type.TRAY_NOTIFICATION);
	            	e.printStackTrace();
	            }
	        }
	    });
	}
}
