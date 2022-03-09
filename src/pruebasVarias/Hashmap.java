package pruebasVarias;

import java.util.HashMap;
import java.util.Iterator;

public class Hashmap {

	static HashMap<Integer, CromoBaloncesto> hm = new HashMap<Integer, CromoBaloncesto>();

	public static void main(String[] args) {

		CromoBaloncesto c = new CromoBaloncesto(1, "Gasol", 13, 4566667);
		CromoBaloncesto c1 = new CromoBaloncesto(2, "Pau", 3, 456667);
		CromoBaloncesto c2 = new CromoBaloncesto(3, "Dfg", 12663, 45667);
		CromoBaloncesto c3 = new CromoBaloncesto(4, "Asdf", 45123, 467);

		hm.put(c.getId(), c);
		hm.put(c1.getId(), c1);
		hm.put(c2.getId(), c2);
		hm.put(c3.getId(), c3);

		Iterator it = hm.values().iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
