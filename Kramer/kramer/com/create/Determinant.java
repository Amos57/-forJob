package com.create;

/**
 *  интерфейс создан для поиска определителя во всех видах матрицы
 * 
 *@author oleg 
 */
@FunctionalInterface
public interface Determinant {

	/**
	 * 
	 * @return возвращает определитель с подставленным последним столбцом
	 */
	int determinant();
	
	
}
