package com.info.xpacknow.domain;



import org.junit.Assert;
import org.junit.Test;

import com.info.xpacknow.service.CreatorInterface;
import com.info.xpacknow.serviceImp.Creator;

public class ExampleMainTest {

	private CreatorInterface creator;

	@org.junit.Before

	public void setup() {

		creator = new Creator();

	}

	@Test
	public void testExampleMain() {

		// Ustaw
		 Integer[] createRandomArray = creator.createRandomArray(10000);

		// Wykonaj
		Integer[] shufflingTable = creator.shufflingTable(createRandomArray);

		int length = createRandomArray.length;
		Integer[] tab = new Integer[length];

		for (int i = 0, j = 0; i < length && j < length; i++, j += 2) {

			if (j % 2 == 0) {
				tab[j] = createRandomArray[i];

			}
			
			

		}

		for (int i = ((length) / 2), j = 1; i < length && j < length; i++, j += 2) {

			tab[j] = createRandomArray[i];

		}

		// Porównaj
		Assert.assertArrayEquals(shufflingTable, tab);

	}

}
