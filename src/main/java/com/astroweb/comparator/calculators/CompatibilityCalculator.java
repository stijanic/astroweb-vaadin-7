package com.astroweb.comparator.calculators;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.astroweb.comparator.model.Aspect;

public class CompatibilityCalculator {
	
	// We don't need to calculate all possible aspects but only these existing in the database
	public double calculateAspects(NatalChartCalculator firstNatalChartCalculator, NatalChartCalculator secondNatalChartCalculator, char relationType) {

		StandardServiceRegistry registry;

		Map<String,String> jdbcUrlSettings = new HashMap<>();
		String jdbcDbUrl = System.getenv("JDBC_DATABASE_URL");
		if (null != jdbcDbUrl) {
			jdbcUrlSettings.put("hibernate.connection.url", System.getenv("JDBC_DATABASE_URL"));
		}

		registry = new StandardServiceRegistryBuilder().
				configure("hibernate.cfg.xml").
				applySettings(jdbcUrlSettings).
				build();

		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
 
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        
        Query query = session.createQuery("from Aspect where relationType = :relationType");

        query.setParameter("relationType", relationType);

        List<?> list = query.list();
        
        //StringBuffer stringBuffer = new StringBuffer();
        //Aspect aspect;
        //for (int i = 0; i < list.size(); i++) {
        //	aspect = (Aspect)list.get(i);
        //	stringBuffer.append(aspect.getCelestialIDFirst() + " " + aspect.getCelestialIDSecond() + "\n");
        //}

        //System.out.println(stringBuffer);
        //System.out.println("List size: " + list.size());

        session.getTransaction().commit();
        session.close();
        //sessionFactory.close();        
               
        double resultFirst = 0;
        double resultSecond = 0;
        
		for (int i = 0; i < list.size(); i++) {

			resultFirst +=
				AspectCalculator.isConjunction(firstNatalChartCalculator.getCelestials()[((Aspect)list.get(i)).getCelestialIDFirst()],
											   secondNatalChartCalculator.getCelestials()[((Aspect)list.get(i)).getCelestialIDSecond()])
											   * ((Aspect)list.get(i)).getConjunction() +
											   
				AspectCalculator.isSextile(firstNatalChartCalculator.getCelestials()[((Aspect)list.get(i)).getCelestialIDFirst()],
						   				   secondNatalChartCalculator.getCelestials()[((Aspect)list.get(i)).getCelestialIDSecond()])
						   				   * ((Aspect)list.get(i)).getSextile() +
						   				   
				AspectCalculator.isSquare(firstNatalChartCalculator.getCelestials()[((Aspect)list.get(i)).getCelestialIDFirst()],
						   				  secondNatalChartCalculator.getCelestials()[((Aspect)list.get(i)).getCelestialIDSecond()])
						   				  * ((Aspect)list.get(i)).getSquare() +
						   				  
				AspectCalculator.isTrine(firstNatalChartCalculator.getCelestials()[((Aspect)list.get(i)).getCelestialIDFirst()],
										 secondNatalChartCalculator.getCelestials()[((Aspect)list.get(i)).getCelestialIDSecond()])
										 * ((Aspect)list.get(i)).getTrine() +
										 						   				  
				AspectCalculator.isOpposition(firstNatalChartCalculator.getCelestials()[((Aspect)list.get(i)).getCelestialIDFirst()],
						   					  secondNatalChartCalculator.getCelestials()[((Aspect)list.get(i)).getCelestialIDSecond()])
											  * ((Aspect)list.get(i)).getOpposition();
		}
		
		for (int i = 0; i < list.size(); i++) {
			resultSecond +=
					AspectCalculator.isConjunction(secondNatalChartCalculator.getCelestials()[((Aspect)list.get(i)).getCelestialIDFirst()],
												   firstNatalChartCalculator.getCelestials()[((Aspect)list.get(i)).getCelestialIDSecond()])
												   * ((Aspect)list.get(i)).getConjunction() +
												   
					AspectCalculator.isSextile(secondNatalChartCalculator.getCelestials()[((Aspect)list.get(i)).getCelestialIDFirst()],
											   firstNatalChartCalculator.getCelestials()[((Aspect)list.get(i)).getCelestialIDSecond()])
							   				   * ((Aspect)list.get(i)).getSextile() +
							   				   
					AspectCalculator.isSquare(secondNatalChartCalculator.getCelestials()[((Aspect)list.get(i)).getCelestialIDFirst()],
											  firstNatalChartCalculator.getCelestials()[((Aspect)list.get(i)).getCelestialIDSecond()])
							   				  * ((Aspect)list.get(i)).getSquare() +
							   				  
					AspectCalculator.isTrine(secondNatalChartCalculator.getCelestials()[((Aspect)list.get(i)).getCelestialIDFirst()],
										     firstNatalChartCalculator.getCelestials()[((Aspect)list.get(i)).getCelestialIDSecond()])
											 * ((Aspect)list.get(i)).getTrine() +
											 						   				  
					AspectCalculator.isOpposition(secondNatalChartCalculator.getCelestials()[((Aspect)list.get(i)).getCelestialIDFirst()],
												  firstNatalChartCalculator.getCelestials()[((Aspect)list.get(i)).getCelestialIDSecond()])
												  * ((Aspect)list.get(i)).getOpposition();
		}	
		
		return resultFirst + resultSecond;
	}
}
