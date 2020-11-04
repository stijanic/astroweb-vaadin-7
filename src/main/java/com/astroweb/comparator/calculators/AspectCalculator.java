package com.astroweb.comparator.calculators;

public class AspectCalculator {
	public final static int NONE = -1;
	public final static int CONJUNCTION = 0;
	public final static int SEXTILE = 60;
	public final static int SQUARE = 90;
	public final static int TRINE = 120;
	public final static int OPPOSITION = 180;
	
	//Conjunction 0� orb �10�
	public static int isConjunction(double firstLongitude, double secondLongitude) {
		double difference = 180 - Math.abs(180 - Math.abs(firstLongitude - secondLongitude));
		return (difference <= CONJUNCTION + 10) ? 1 : 0;
	}
	
	//Sextil 60� orb �5�
	public static int isSextile(double firstLongitude, double secondLongitude) {
		double difference = 180 - Math.abs(180 - Math.abs(firstLongitude - secondLongitude));
		return (SEXTILE - 5 <= difference && difference <= SEXTILE + 5) ? 1 : 0;
	}

	//Quadrant 90� orb �8�
	public static int isSquare(double firstLongitude, double secondLongitude) {
		double difference = 180 - Math.abs(180 - Math.abs(firstLongitude - secondLongitude));
		return (SQUARE - 8 <= difference && difference <= SQUARE + 8) ? 1 : 0;
	}
	
	//Trine 120� orb �7�	
	public static int isTrine(double firstLongitude, double secondLongitude) {
		double difference = 180 - Math.abs(180 - Math.abs(firstLongitude - secondLongitude));
		return (TRINE - 7 <= difference && difference <= TRINE + 7) ? 1 : 0;
	}
	
	//Opposition 180� orb �8�	
	public static int isOpposition(double firstLongitude, double secondLongitude) {
		double difference = 180 - Math.abs(180 - Math.abs(firstLongitude - secondLongitude));
		return (OPPOSITION - 8 <= difference) ? 1 : 0;
	}
}