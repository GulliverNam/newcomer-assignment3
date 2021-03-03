package com.skcc.stock.dto;


public class JsonItem {
	private int cd;
	private String nm;
	private int nv;
	private int cv;
	private double cr;
	private int rf;
	private int mks;
	private int aa;
	public JsonItem() {
	}
	public JsonItem(int cd, String nm, int nv, int cv, double cr, int rf, int mks, int aa) {
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
	public int getCd() {
		return cd;
	}
	public void setCd(int cd) {
		this.cd = cd;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
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
		return "JsonItem [cd=" + cd + ", nm=" + nm + ", nv=" + nv + ", cv=" + cv + ", cr=" + cr + ", rf=" + rf
				+ ", mks=" + mks + ", aa=" + aa + "]";
	}
	
}
