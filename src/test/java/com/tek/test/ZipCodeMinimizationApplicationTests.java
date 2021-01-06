package com.tek.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.tek.data.ZipCodeRange;
import com.tek.process.IValidateAndProcessZipCodes;
import com.tek.process.ValidateAndProcessZipCodes;

//@SpringBootTest
class ZipCodeMinimizationApplicationTests {
	
	private IValidateAndProcessZipCodes validateAndProcessZipCodes = new ValidateAndProcessZipCodes();

	@Test
	void testWithNoCoInicidenceOfLowerAndUpperBound() {
		System.out.println("testWithNoCoInicidenceOfLowerAndUpperBound : ");
		List<ZipCodeRange> zipCodeRanges = new ArrayList<>();
		ZipCodeRange zipCodeRange = new ZipCodeRange(94133,94133);
		zipCodeRanges.add(zipCodeRange);
		zipCodeRange = new ZipCodeRange(94200,94299);
		zipCodeRanges.add(zipCodeRange);
		zipCodeRange = new ZipCodeRange(94600,94699);
		zipCodeRanges.add(zipCodeRange);
		String input = zipCodeRanges.toString();
		System.out.println("INPUTE : "+input);
		
		String expected = zipCodeRanges.toString();
		System.out.println("EXPECTED : "+expected);
		
		String actual = validateAndProcessZipCodes.determineMinimumRanges(zipCodeRanges).toString();
		System.out.println("ACTUAL : "+ actual);
		assertEquals(expected, actual);
		System.out.println("------------------------------------------------------------------------------------");
	}
	
	@Test
	void testWithCoIncidenceWithBothLowerAndUpperBoundOption1() {
		System.out.println("testWithCoIncidenceWithBothLowerAndUpperBoundOption1 : ");
		List<ZipCodeRange> zipCodeRanges = new ArrayList<>();
		ZipCodeRange zipCodeRange = new ZipCodeRange(94133,94133);
		zipCodeRanges.add(zipCodeRange);
		zipCodeRange = new ZipCodeRange(96000,95000);
		zipCodeRanges.add(zipCodeRange);
		zipCodeRange = new ZipCodeRange(95500,95900);
		zipCodeRanges.add(zipCodeRange);
		zipCodeRange = new ZipCodeRange(94600,94699);
		zipCodeRanges.add(zipCodeRange);
		String input = zipCodeRanges.toString();
		System.out.println("INPUTE : "+input);
		
		List<ZipCodeRange> expectedZipCodeRanges = new ArrayList<>();
		ZipCodeRange expectedZipCodeRange = new ZipCodeRange(94133,94133);
		expectedZipCodeRanges.add(expectedZipCodeRange);
		expectedZipCodeRange = new ZipCodeRange(94600,94699);
		expectedZipCodeRanges.add(expectedZipCodeRange);
		expectedZipCodeRange = new ZipCodeRange(95000,96000);
		expectedZipCodeRanges.add(expectedZipCodeRange);
		
		String expected = expectedZipCodeRanges.toString();
		System.out.println("EXPECTED : "+expected);
		
		String actual = validateAndProcessZipCodes.determineMinimumRanges(zipCodeRanges).toString();
		System.out.println("ACTUAL : "+ actual);
		
		assertEquals(expected, actual);
		System.out.println("------------------------------------------------------------------------------------");
	}
	
	@Test
	void testWithCoIncidenceWithBothLowerAndUpperBoundOption2() {
		System.out.println("testWithCoIncidenceWithBothLowerAndUpperBoundOption2 : ");
		List<ZipCodeRange> zipCodeRanges = new ArrayList<>();
		ZipCodeRange zipCodeRange = new ZipCodeRange(94133,94133);
		zipCodeRanges.add(zipCodeRange);
		zipCodeRange = new ZipCodeRange(94200,94299);
		zipCodeRanges.add(zipCodeRange);
		zipCodeRange = new ZipCodeRange(94226,94399);
		zipCodeRanges.add(zipCodeRange);
		String input = zipCodeRanges.toString();
		System.out.println("INPUTE : "+input);
		
		List<ZipCodeRange> expectedZipCodeRanges = new ArrayList<>();
		ZipCodeRange expectedZipCodeRange = new ZipCodeRange(94133,94133);
		expectedZipCodeRanges.add(expectedZipCodeRange);
		expectedZipCodeRange = new ZipCodeRange(94200,94399);
		expectedZipCodeRanges.add(expectedZipCodeRange);

		String expected = expectedZipCodeRanges.toString();
		System.out.println("EXPECTED : "+expected);
		
		String actual = validateAndProcessZipCodes.determineMinimumRanges(zipCodeRanges).toString();
		System.out.println("ACTUAL : "+ actual);
		
		assertEquals(expected, actual);
		System.out.println("------------------------------------------------------------------------------------");
	}
	
	@Test
	void testWithCoIncidenceWithBothLowerAndUpperBoundOption3() {
		System.out.println("testWithCoIncidenceWithBothLowerAndUpperBoundOption3 : ");
		List<ZipCodeRange> zipCodeRanges = new ArrayList<>();
		ZipCodeRange zipCodeRange = new ZipCodeRange(94133,94133);
		zipCodeRanges.add(zipCodeRange);
		zipCodeRange = new ZipCodeRange(94200,94299);
		zipCodeRanges.add(zipCodeRange);
		zipCodeRange = new ZipCodeRange(94100,94399);
		zipCodeRanges.add(zipCodeRange);
		String input = zipCodeRanges.toString();
		System.out.println("INPUTE : "+input);
		
		List<ZipCodeRange> expectedZipCodeRanges = new ArrayList<>();
		ZipCodeRange expectedZipCodeRange = new ZipCodeRange(94100,94399);
		expectedZipCodeRanges.add(expectedZipCodeRange);

		String expected = expectedZipCodeRanges.toString();
		System.out.println("EXPECTED : "+expected);
		
		String actual = validateAndProcessZipCodes.determineMinimumRanges(zipCodeRanges).toString();
		System.out.println("ACTUAL : "+ actual);
		
		assertEquals(expected, actual);
		System.out.println("------------------------------------------------------------------------------------");
	}

}
