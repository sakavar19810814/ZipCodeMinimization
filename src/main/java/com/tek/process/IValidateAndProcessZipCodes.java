package com.tek.process;

import java.util.List;

import com.tek.data.ZipCodeRange;

/*
 * An interface to determine the minimum ranges.
 *  This interface can be used in future to extend the business functionality.
 */
public interface IValidateAndProcessZipCodes {
	
	/*
	 * This method evaluates the all given zip code ranges and returns the minimum required ranges 
	 * in terms of set.
	 */
	public List<ZipCodeRange> determineMinimumRanges(List<ZipCodeRange> zipCodeRanges);
	
}
