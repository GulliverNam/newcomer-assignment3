package com.skcc.stock.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class XmlItem {
	@XmlAttribute(name = "cd")
	private int cd;
	@XmlAttribute(name = "nm")
	private String nm;
	@XmlAttribute(name = "nv")
	private int nv;
	@XmlAttribute(name = "cv")
	private int cv;
	@XmlAttribute(name = "cr")
	private double cr;
	@XmlAttribute(name = "rf")
	private int rf;
	@XmlAttribute(name = "mks")
	private int mks;
	@XmlAttribute(name = "aa")
	private int aa;
	public XmlItem() {
	}
	public XmlItem(int cd, String nm, int nv, int cv, double cr, int rf, int mks, int aa) {
		super();
		this.cd = cd;
		this.nm = nm;
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
	public void setCode(int cd) {
		this.cd = cd;
	}
	public String getName() {
		return nm;
	}
	public void setName(String name) {
		this.nm = name;
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
	@Override
	public String toString() {
		return "XmlItem [cd=" + cd + ", name=" + nm + ", nv=" + nv + ", cv=" + cv + ", cr=" + cr + ", rf=" + rf
				+ ", mks=" + mks + ", aa=" + aa + "]";
	}
}
