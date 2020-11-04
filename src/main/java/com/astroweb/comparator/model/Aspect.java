package com.astroweb.comparator.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
@Table(name="ASPECT")
public class Aspect {
	
	@Id
	@Column(name="ID", unique=true, nullable=false, insertable=false, updatable=false)
	private int id;
	
	@Column(name="RELATION_TYPE", unique=true, nullable=false, insertable=false, updatable=false)
	private char relationType;
	
	@Column(name="CELESTIAL_ID_FIRST", unique=true, nullable=false, insertable=false, updatable=false)
	private int celestialIDFirst;
	
	@Column(name="CELESTIAL_ID_SECOND", unique=true, nullable=false, insertable=false, updatable=false)
	private int celestialIDSecond;
	
	@Column(name="CONJUNCTION", unique=true, nullable=false, insertable=false, updatable=false)
	private double conjunction;
	
	@Column(name="SEXTILE", unique=true, nullable=false, insertable=false, updatable=false)
	private double sextile;
	
	@Column(name="SQUARE", unique=true, nullable=false, insertable=false, updatable=false)
	private double square;
	
	@Column(name="TRINE", unique=true, nullable=false, insertable=false, updatable=false)
	private double trine;
	
	@Column(name="OPPOSITION", unique=true, nullable=false, insertable=false, updatable=false)
	private double opposition;
	
	@Column(name="UPDATE_TIME", unique=true, nullable=false, insertable=false, updatable=false)
	//@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;
	
	//SELECT CELESTIAL_ID_FIRST, CELESTIAL_ID_SECOND, CONJUNCTION, SEXTILE, SQUARE, TRINE, OPPOSITION FROM ASPECT WHERE RELATION_TYPE = '1';
	//SELECT CELESTIAL_ID_FIRST, CELESTIAL_ID_SECOND, CONJUNCTION, SEXTILE, SQUARE, TRINE, OPPOSITION FROM ASPECT WHERE RELATION_TYPE = '2';
	//SELECT CELESTIAL_ID_FIRST, CELESTIAL_ID_SECOND, CONJUNCTION, SEXTILE, SQUARE, TRINE, OPPOSITION FROM ASPECT WHERE RELATION_TYPE = '3';
	//SELECT CELESTIAL_ID_FIRST, CELESTIAL_ID_SECOND, CONJUNCTION, SEXTILE, SQUARE, TRINE, OPPOSITION FROM ASPECT WHERE RELATION_TYPE = '4';

	//1. HQL Query
	//
	//- you are using hibernate that means you have done mapping to Student table and Student class.
	// you just need to change following line.
	//
	//List<student> stlist=HibernateUtil.getSession().createQuery("from student").list();
	//
	//and you will get all records from Student table.
	//
	//2. SQL Query
	//
	//- you can do by providing SQL query
	//
	//     List<Object> stlist=HibernateUtil.getSession().createSQLQuery("select * from student").list();
	//
	//you will get all records as Object so you need to manually cast to Student.
	

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public char getRelationType() {
		return relationType;
	}
	
	public void setRelationType(char relationType) {
		this.relationType = relationType;
	}
	
	public int getCelestialIDFirst() {
		return celestialIDFirst;
	}
	
	public void setCelestialIDFirst(int celestialIDFirst) {
		this.celestialIDFirst = celestialIDFirst;
	}
	
	public int getCelestialIDSecond() {
		return celestialIDSecond;
	}
	
	public void setCelestialIDSecond(int celestialIDSecond) {
		this.celestialIDSecond = celestialIDSecond;
	}
	
	public double getConjunction() {
		return conjunction;
	}
	
	public void setConjunction(double conjunction) {
		this.conjunction = conjunction;
	}
	
	public double getSextile() {
		return sextile;
	}
	
	public void setSextile(double sextile) {
		this.sextile = sextile;
	}
	
	public double getSquare() {
		return square;
	}
	
	public void setSquare(double square) {
		this.square = square;
	}
	
	public double getTrine() {
		return trine;
	}
	
	public void setTrine(double trine) {
		this.trine = trine;
	}
	
	public double getOpposition() {
		return opposition;
	}
	
	public void setOpposition(double opposition) {
		this.opposition = opposition;
	}
}
