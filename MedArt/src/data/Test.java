package data;

import java.util.ArrayList;

public class Test {
	public static void main (String[] args){
		ArrayList<InfoCardio>  data = new ArrayList<InfoCardio>();
		data = Util.readExcel("data.csv");
	}

}
