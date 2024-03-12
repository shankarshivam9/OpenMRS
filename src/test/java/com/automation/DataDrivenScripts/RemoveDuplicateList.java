package com.automation.DataDrivenScripts;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateList {

	public static void main(String[] args) {
		
		Integer[] arr = {1,2,3,5,2,6};
		Set<Integer> set  = new LinkedHashSet<Integer>();
		for(Integer duplicates : arr) {
			set.add(duplicates);
		}

		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next());
		}
	}

}
