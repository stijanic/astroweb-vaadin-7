package com.astroweb.comparator.calculators;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.vaadin.server.VaadinServlet;
import swisseph.SweConst;
import swisseph.SweDate;
import swisseph.SwissEph;
import swisseph.SwissephException;

public class NatalChartCalculator {

	private final static String UTC = "UTC"; // Swiss Ephemerides calculates based on Universal Time
	
	public final static int ARIES = 0;
	public final static int TAURUS = 1;
	public final static int GEMINI = 2;
	public final static int CANCER = 3;
	public final static int LEO = 4;
	public final static int VIRGO = 5;
	public final static int LIBRA = 6;
	public final static int SCORPIO = 7;
	public final static int SAGITTARIUS = 8;
	public final static int CAPRICORN = 9;
	public final static int AQUARIUS = 10;
	public final static int PISCES = 11;
			
    private SwissEph swissEphemeris;
	
	private String hys = "placidus"; // Always
	
	private double[] planets = new double[10];
	private double[] houses = new double[12];

	public NatalChartCalculator(Date birthDate, double latitude, double longitude) {
		//This seems to be working on Windows
        String ephemeridesPath = VaadinServlet.getCurrent().getServletContext().getRealPath("/WEB-INF/lib/ephemerides").replace(":", "\\:");
        // Initializing Swiss Ephemeris with a path pointing to the WEB-INF directory
    	swissEphemeris = new SwissEph(ephemeridesPath);

		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(UTC));
        calendar.setTime(birthDate);
        
		SweDate sweDate = new SweDate(calendar.get(Calendar.YEAR),
								 calendar.get(Calendar.MONTH) + 1,
								 calendar.get(Calendar.DAY_OF_MONTH),
								 calendar.get(Calendar.HOUR_OF_DAY) +
                				 calendar.get(Calendar.MINUTE) / 60. +
                				 calendar.get(Calendar.SECOND) / 3600. +
                				 calendar.get(Calendar.MILLISECOND) / 3600000.);

		// Sun, Moon & Planets
		for (int i = 0; i < 10; i++) {
			planets[i] = calculatePlanet(sweDate.getJulDay(), i, SweConst.SEFLG_SPEED);
		}

		// Houses
		houses = calculateHouses(sweDate, latitude, longitude, (int) hys.toUpperCase().charAt(0));
	}
	
    private double calculatePlanet(double julianDay, int planet, int iflag) {
    	// In this array, the values will be returned:
    	double[] result = new double[6];
    	StringBuffer error = new StringBuffer();

    	int rc = swissEphemeris.swe_calc_ut(julianDay, planet, iflag, result, error);

    	if (error.length() > 0) {
    		System.err.println(error.toString());
    	}
    	if (rc == SweConst.ERR) {
    		throw new SwissephException(julianDay, error.toString());
    	}    	
    	return result[0];
    }
    
    private double[] calculateHouses(SweDate sweDate, double latitude, double longitude, int hsy) {
        double[] cusp = new double[13];
        double[] ascmc = new double[10];
        int result= swissEphemeris.swe_houses(sweDate.getJulDay(), 0, latitude, longitude, hsy, cusp, ascmc);
        if(result == SweConst.ERR){
            throw new SwissephException(sweDate.getJulDay(),"Calculation was not possible due to nearness to the polar circle in Koch or Placidus house system or when requesting Gauquelin sectors. " +
                    "Calculation automatically switched to Porphyry house calculation method in this case");
        }
        return cusp;
    }
    
    public String getPlanetName(int planet) {       
        return swissEphemeris.swe_get_planet_name(planet);
    }

    public String getAstrologicalSignName(double longitude) {
    	switch ((int)longitude / 30) {
    	case ARIES:
    		return "Aries";
    	case TAURUS:
    		return "Taurus";
    	case GEMINI:
    		return "Gemini";
    	case CANCER: 
    		return "Cancer";
    	case LEO: 
    		return "Leo";
    	case VIRGO: 
    		return "Virgo";
    	case LIBRA: 
    		return "Libra";
    	case SCORPIO: 
    		return "Scorpio";
    	case SAGITTARIUS: 
    		return "Sagittarius";
    	case CAPRICORN: 
    		return "Capricorn";
    	case AQUARIUS: 
    		return "Aquarius";
    	case PISCES: 
    		return "Pisces";
    	default:
    		return "";
    	}
    }
    
	public double[] getPlanetsLongitudes() {
		return planets;
	}

	public double[] getHousesLongitudes() {
		return houses;
	}

	public double[] getCelestials() {
		double[] celestials = new double[planets.length + houses.length - 1];
		
		System.arraycopy(planets, 0, celestials, 0, planets.length);
		System.arraycopy(houses, 1, celestials, planets.length, houses.length - 1);
		
		return celestials;
	}
}
