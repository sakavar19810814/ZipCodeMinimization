package com.tek.data;
/*
 * This pojo class is used to holds the the zip code ranges during processing.
 */
public class ZipCodeRange {
	
	private int lowerBound;
	private int upperBound;
	
	/**
	 * constructor to instantiate an object with lower bound and upper bound.
	 * It also validates the the zip code order, if lower bound is more than upper bound.
	 * @param lowerBound
	 * @param upperBound
	 */
	public ZipCodeRange(int lowerBound, int upperBound) {
		if(lowerBound > upperBound) {
			//interchanging the lower and upper bound codes.
			this.lowerBound = upperBound;
			this.upperBound = lowerBound;
		} else {
			this.lowerBound = lowerBound;
			this.upperBound = upperBound;
		}
	}
	/**
	 * accessor for lowerBound.
	 * @return the lowerBound
	 */
	public int getLowerBound() {
		return lowerBound;
	}
	/**
	 * mutator for lowerBound.
	 * @param lowerBound the lowerBound to set
	 */
	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}
	/**
	 * accessor for upperBound.
	 * @return the upperBound
	 */
	public int getUpperBound() {
		return upperBound;
	}
	/**
	 * mutator for upperBound.
	 * @param upperBound the upperBound to set
	 */
	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}
	@Override
	public String toString() {
		return "["+lowerBound + ", " + upperBound + "]";
	}
	
	
	
}
