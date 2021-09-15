package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

@SuppressWarnings("unused")
public class StudyTSCollections {

	public static void main(String[] args) {
		// Collection is not Thread-Safe -> Fail-fast -> (ConcurrentModificationException)
		// protected transient int modCount = 0;
		// ArrayList -> version
		var list = new ArrayList<>();
		list.add(42); // modCount++
		for(var iter = list.iterator() ; iter.hasNext();) {
			var elem = iter.next();
		}
		
		for (var elem : list) {
			list.add(1);
		}
		// 1. Collections.synchronizedMap
		var tsMap = Collections.synchronizedMap(new HashMap<Integer, String>());
		// 2. Thread-Safe Collection
			// I)  ConcurrentHashMap<>: Multi-core ready
			// II) CopyOnWriteArrayList<Integer>: Read-heavy
	}

}
