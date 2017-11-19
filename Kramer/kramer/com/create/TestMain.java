package com.create;

import com.XML.XMLSetting;
import com.file.ScannerFile;

/**
 * класс для демонстрации приложения.
 * В качестве примера дается матрица 5х4.
 * Значения берутся двумя способами:
 * 
 * <p>-На прямую, через конструктор.Затем выводится на консоль ответ.
 * 
 * <p>- Через файл, куда введены значения через разделитель. Затем файл перезаписывается.
 * 
 * <p> Сначало записываем все значения кроме последнего столбца,
 *  последний столбец записывается после квадратной матрицы по порядку - сверху вниз.
 *  
 *  
 *  
 * @author oleg
 *
 */
public class TestMain {


	public static void main(String[] args) {

/*    		                         
  5,8,0,7,36,7,6,5,7,34,67,8,3,6,7,8,4,3,4,6 
  
  
 * matrix:
 * 
 * 5  8  0  7  4
 * 36 7  6  5  3
 * 7  34 67 8  4
 * 3  6  7  8  6
 * 
 * 
 * answer:
 * 
 * x1 = 134/-88244
 * x2 = 22814/-88244
 * x3 = -7714/-88244
 * x4 = -76594/-88244
 * 
 * 
 * */
/*
*/

  /*new Create(5,8,0,7,36,7,6,5,7,34,67,8,3,6,7,8, 4,3,4,6);//последняя колонка
*/
XMLSetting xmLsetting=new XMLSetting();
ScannerFile readAndWrite= new ScannerFile(xmLsetting.getPath(),xmLsetting.getSplit());
readAndWrite.read();
readAndWrite.write();

	   
}
	



  
    

   
   

 }