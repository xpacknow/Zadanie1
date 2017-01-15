package com.info.xpacknow.service;


public interface CreatorInterface {

	public Integer[]  createRandomArray(int tableSize);

	public Integer[] shufflingTable(Integer[]  randomTable);

	public void displayTable(Integer[] shufflingTable);

	public void fileRecord(Integer[] shufflingTable, Integer[] createRandomArray);
}
