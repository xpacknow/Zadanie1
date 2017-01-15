package com.info.xpacknow.domain;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.commons.lang3.time.StopWatch;

import com.info.xpacknow.service.CreatorInterface;
import com.info.xpacknow.service.TimeMeasureInterface;
import com.info.xpacknow.serviceImp.Creator;
import com.info.xpacknow.serviceImp.TimeMeasure;

public class ExampleMain {

	public static void main(String[] args) throws FileNotFoundException {

		int tableSize;
		int number;

		StopWatch stopWatch = new StopWatch();
		TimeMeasureInterface timeMeasure = new TimeMeasure();
		Scanner scanner = new Scanner(System.in);

		do {

			System.out.println("Podaj ilość elementów w tablicy (liczbe parzystą)");
			tableSize = scanner.nextInt();

		} while ((tableSize % 2) != 0);

		do {
			System.out.println("Wybierz opcję : ");
			System.out.println("1 : Wykonanie obliczeń bez wyświetlania danych ");
			System.out.println(
					"2 : Wykonanie obliczeń z wyświetlaniem danych na konsoli (dla wielkosci tabeli powyzej 1000 wybierz nr 3.) ");
			System.out.println("3 : Wykonanie obliczeń z wyś. na konsoli i zapisem do pliku ");
			number = scanner.nextInt();

		} while ((0 >= number) || (4 <= number));

		timeMeasure.preTime();
		stopWatch.start();
		scanner.close();

		CreatorInterface creator = new Creator();

		Integer[] randomArray = creator.createRandomArray(tableSize);
		if (randomArray.length > 0) {
			Integer[] shufflingArray = creator.shufflingTable(randomArray);

			if (number >= 2) {
				System.out.println("Tablica losowa");
				creator.displayTable(randomArray);

				System.out.println("Tablica wynikowa");
				creator.displayTable(shufflingArray);
			}
			if (number >= 3) {
				creator.fileRecord(shufflingArray, randomArray);
			}

		}

		stopWatch.stop();

		timeMeasure.postTime();
		System.out.println("Czas wykonania obliczeń : " + stopWatch.getTime() + " ms");

	}
}
