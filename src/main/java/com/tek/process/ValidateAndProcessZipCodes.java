package com.tek.process;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.tek.data.ZipCodeRange;

/*
 *  This class is the implementation IValidateAndProcessZipCodes, where we have functionality.
 */
public class ValidateAndProcessZipCodes implements IValidateAndProcessZipCodes {

	/*
	 * This method evaluates the all given zip code ranges and returns the minimum required ranges 
	 * in terms of set.
	 */
	@Override
	public List<ZipCodeRange> determineMinimumRanges(List<ZipCodeRange> zipCodeRanges) {

		//Creating refined list, which is having final result.
		List<ZipCodeRange> zipCodeRangesRefined = new ArrayList<>();
		//Sorting the given list by lower bound and upper bound to make process easier.
		zipCodeRanges = zipCodeRanges.stream()
				.sorted(Comparator.comparing(ZipCodeRange::getLowerBound).thenComparing(ZipCodeRange::getUpperBound))
				.collect(Collectors.toList());
		//Adding null check and size verification on zipcode rages list. 
		if (null != zipCodeRanges && zipCodeRanges.size() > 0) {
			ZipCodeRange zipCodeRangeCurrent = zipCodeRanges.get(0);
			//Navigating sorted list of zip code ranges.
			for (ZipCodeRange zipCodeRange : zipCodeRanges) {
				//Checking adjacent zip code ranges i.e. current upper & current lower bound and current upper bound & next lower bound of zip code range. 
				if (zipCodeRangeCurrent.getUpperBound() >= zipCodeRange.getLowerBound()) {
					//Checking adjacent zip code ranges i.e. current upper & next upper and current lower & next lower bounds.
					if (zipCodeRangeCurrent.getLowerBound() != zipCodeRange.getLowerBound() && zipCodeRangeCurrent.getUpperBound() < zipCodeRange.getUpperBound()) {
						//Adjusting next upper bound to current
						zipCodeRangeCurrent.setUpperBound(zipCodeRange.getUpperBound());
					}
				}else {
					//Adding to adjusted zip code range to refined list.
					zipCodeRangesRefined.add(zipCodeRangeCurrent);
					//Moving forward in the list to proceed other zip code ranges by setting next to current.
					zipCodeRangeCurrent = zipCodeRange;
				}
			}
			//Adding last zip code range to Refined list.
			zipCodeRangesRefined.add(zipCodeRangeCurrent);
		}
		// processed list to be send for output.
		return zipCodeRangesRefined;
	}

}
