package com.ABMdata.org;
import java.util.ArrayList;
import java.util.List;

//Solution for Question 1
public class Edifact {

	public static void main(String[] args) {
		String edifact = "UNA:+.? '"
				+ "UNB+UNOC:3+2021000969+4441963198+180525:1225+3VAL2MJV6EH9IX+KMSV7HMD+CUSDECU-IE++1++1'"
				+ "UNH+EDIFACT+CUSDEC:D:96B:UN:145050'" + "BGM+ZEM:::EX+09SEE7JPUV5HC06IC6+Z'" + "LOC+17+IT044100'"
				+ "LOC+18+SOL'" + "LOC+35+SE'" + "LOC+36+TZ'" + "LOC+116+SE003033'" + "DTM+9:20090527:102'"
				+ "DTM+268:20090626:102'" + "DTM+182:20090527:102'";

		List<String> resultList = new ArrayList<String>();
		String[] lines = edifact.split("\'");
		for (String line : lines) {

			if (line.contains("LOC")) {
				String[] output = line.split("\\+");
				resultList.add(output[1]);
				resultList.add(output[2]);
			}
		}
		for (String result : resultList) {
			System.out.print(result+" ");
		}
	}

}
