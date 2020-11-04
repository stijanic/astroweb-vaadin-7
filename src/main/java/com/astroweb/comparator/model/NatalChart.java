package com.astroweb.comparator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NATAL_CHART")
public class NatalChart {
	@Id
	private int id;
	private double  sun;
	private double  moon;
	private double  mercure;
	private double  venus;
	private double  mars;
	private double  jupiter;
	private double  saturn;
	private double  uranus;
	private double  neptune;
	private double  pluto;
	@Column(name="FIRST_HOUSE")
	private double  firstHouse;
	@Column(name="SECOND_HOUSE")
	private double  secondHouse;
	@Column(name="THIRD_HOUSE")	
	private double  thirdHouse;
	@Column(name="FOURTH_HOUSE")		
	private double  fourthHouse;
	@Column(name="FIFTH_HOUSE")		
	private double  fifthHouse;
	@Column(name="SIXTH_HOUSE")	
	private double  sixthHouse;
	@Column(name="SEVENTH_HOUSE")	
	private double  seventhHouse;
	@Column(name="EIGHTH_HOUSE")	
	private double  eighthHouse;
	@Column(name="NINTH_HOUSE")	
	private double  ninthHouse;
	@Column(name="TENTH_HOUSE")	
	private double  tenthHouse;
	@Column(name="ELEVENTH_HOUSE")	
	private double  eleventhHouse;
	@Column(name="TWELFTH_HOUSE")	
	private double  twelfthHouse;
	
	public double getSun() {
		return sun;
	}
	public void setSun(double sun) {
		this.sun = sun;
	}
	public double getMoon() {
		return moon;
	}
	public void setMoon(double moon) {
		this.moon = moon;
	}
	public double getMercure() {
		return mercure;
	}
	public void setMercure(double mercure) {
		this.mercure = mercure;
	}
	public double getVenus() {
		return venus;
	}
	public void setVenus(double venus) {
		this.venus = venus;
	}
	public double getMars() {
		return mars;
	}
	public void setMars(double mars) {
		this.mars = mars;
	}
	public double getJupiter() {
		return jupiter;
	}
	public void setJupiter(double jupiter) {
		this.jupiter = jupiter;
	}
	public double getSaturn() {
		return saturn;
	}
	public void setSaturn(double saturn) {
		this.saturn = saturn;
	}
	public double getUranus() {
		return uranus;
	}
	public void setUranus(double uranus) {
		this.uranus = uranus;
	}
	public double getNeptune() {
		return neptune;
	}
	public void setNeptune(double neptune) {
		this.neptune = neptune;
	}
	public double getPluto() {
		return pluto;
	}
	public void setPluto(double pluto) {
		this.pluto = pluto;
	}
	public double getFirstHouse() {
		return firstHouse;
	}
	public void setFirstHouse(double firstHouse) {
		this.firstHouse = firstHouse;
	}
	public double getSecondHouse() {
		return secondHouse;
	}
	public void setSecondHouse(double secondHouse) {
		this.secondHouse = secondHouse;
	}
	public double getThirdHouse() {
		return thirdHouse;
	}
	public void setThirdHouse(double thirdHouse) {
		this.thirdHouse = thirdHouse;
	}
	public double getFourthHouse() {
		return fourthHouse;
	}
	public void setFourthHouse(double fourthHouse) {
		this.fourthHouse = fourthHouse;
	}
	public double getFifthHouse() {
		return fifthHouse;
	}
	public void setFifthHouse(double fifthHouse) {
		this.fifthHouse = fifthHouse;
	}
	public double getSixthHouse() {
		return sixthHouse;
	}
	public void setSixthHouse(double sixthHouse) {
		this.sixthHouse = sixthHouse;
	}
	public double getSeventhHouse() {
		return seventhHouse;
	}
	public void setSeventhHouse(double seventhHouse) {
		this.seventhHouse = seventhHouse;
	}
	public double getEighthHouse() {
		return eighthHouse;
	}
	public void setEighthHouse(double eighthHouse) {
		this.eighthHouse = eighthHouse;
	}
	public double getNinthHouse() {
		return ninthHouse;
	}
	public void setNinthHouse(double ninthHouse) {
		this.ninthHouse = ninthHouse;
	}
	public double getTenthHouse() {
		return tenthHouse;
	}
	public void setTenthHouse(double tenthHouse) {
		this.tenthHouse = tenthHouse;
	}
	public double getEleventhHouse() {
		return eleventhHouse;
	}
	public void setEleventhHouse(double eleventhHouse) {
		this.eleventhHouse = eleventhHouse;
	}
	public double getTwelfthHouse() {
		return twelfthHouse;
	}
	public void setTwelfthHouse(double twelfthHouse) {
		this.twelfthHouse = twelfthHouse;
	}	
}
