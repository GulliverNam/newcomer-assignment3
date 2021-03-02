package com.skcc.stock.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class XmlItem {
	private int cd;
	private String name;
	private int nv;
	private int cv;
	private double cr;
	private int rf;
	private int mks;
	private int aa;
	
	public XmlItem(int cd, String name, int nv, int cv, double cr, int rf, int mks, int aa) {
		super();
		this.cd = cd;
		this.name = name;
		this.nv = nv;
		this.cv = cv;
		this.cr = cr;
		this.rf = rf;
		this.mks = mks;
		this.aa = aa;
	}
	public int getCode() {
		return cd;
	}
	public void setCode(int code) {
		this.cd = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNv() {
		return nv;
	}
	public void setNv(int nv) {
		this.nv = nv;
	}
	public int getCv() {
		return cv;
	}
	public void setCv(int cv) {
		this.cv = cv;
	}
	public double getCr() {
		return cr;
	}
	public void setCr(double cr) {
		this.cr = cr;
	}
	public int getRf() {
		return rf;
	}
	public void setRf(int rf) {
		this.rf = rf;
	}
	public int getMks() {
		return mks;
	}
	public void setMks(int mks) {
		this.mks = mks;
	}
	public int getAa() {
		return aa;
	}
	public void setAa(int aa) {
		this.aa = aa;
	}
	
}
