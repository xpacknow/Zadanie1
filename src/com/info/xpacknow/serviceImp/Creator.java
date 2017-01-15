package com.info.xpacknow.serviceImp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import com.info.xpacknow.service.CreatorInterface;

public class Creator implements CreatorInterface {

	public Integer[] createRandomArray(int arraySize) {

		Set<Integer> randomArray = new LinkedHashSet<Integer>();
		Random generator = new Random();

		for (int i = 0; i < arraySize + 1; i++) {

			randomArray.add(1 + generator.nextInt(arraySize));

			if (randomArray.size() < i) {
				i--;
			}
		}

		Integer[] randomArrayResult = randomArray.toArray(new Integer[randomArray.size()]);

		return randomArrayResult;
	}

	public Integer[] shufflingTable(Integer[] randomArray) {

		int sizeArray = randomArray.length;

		Integer[] table = new Integer[sizeArray];

		for (int i = 0, j = 0; i < sizeArray && j < sizeArray; i++, j += 2) {

			if (j % 2 == 0) {
				table[j] = randomArray[i];

			}

		}

		for (int i = ((sizeArray) / 2), j = 1; i < sizeArray && j < sizeArray; i++, j += 2) {

			table[j] = randomArray[i];

		}
		return table;

	}

	public void displayTable(Integer[] array) {

		for (Integer arrayResult : array) {

			System.out.print(arrayResult + " ");

		}

		System.out.println("\n");
	}

	public void fileRecord(Integer[] shufflingArray, Integer[] randomArray) {

		File file = new File("Plik_Wynikowy.txt");
		;
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			PrintWriter saveFile = new PrintWriter("Plik_Wynikowy.txt");
			saveFile.println("Nr. kolumny / bez sortowania / z sortowaniem");

			for (int i = 0; i < shufflingArray.length; i++) {

				saveFile.println((i + 1) + " / " + randomArray[i] + " / " + shufflingArray[i]);

			}
			saveFile.close();
			System.out.println("Plik zapisany (SPRAWDZ WYNIKI W PLIKU UMIESZCZONYM W PROJEKCIE)");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
