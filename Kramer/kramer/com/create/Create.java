package com.create;

import javax.swing.JOptionPane;

public class Create {

	/**
	 * Сообщение 
	 * 
	 */
	public static final String MESSAGE_ERRORE="Введите корректное значение";
	
	
	/**
	 * матрица без последней колонки
	 * 
	 */
	private int[][] array;
	
	
	/**
	 * последний столбец матрицы
	 * 
	 */
	private int[] lastColumn;
	
	/**
	 * массив c определителями, значения которых делятся на основной определитель
	 * 
	 */
	private int[] resaltColumn;
	
	/**
	 * 
	 * Это основной определитель матрицы.
	 * На него будут делиться определители с подставленной последней колонкой матрицы
	 * 
	 */
	private int determinantMain;
	
	/**
	 * полная матрица
	 */
	private int[][] allMatrix;
	
	
	/**
	 * Конструктор матрицы.
	 * 
	 * <p>x.lenght = 6 || 12 || 20 
	 * 
	 * <p>6 -  матрица 3х2
	 * <p>12 - матрица 4х3
	 * <p>20 - матрица 5х4
	 * 
	 * @param Массив с фиксированной длиной, после чего он раскладывается на массив с одинаковой
	 * шириной и высотой,
	 * и массив с решениями(последняя колонка).
	 * 
	 */
	public Create(int...x) {

		if(x.length==6){
		int[][] ar= {{x[0],x[1]},{x[2],x[3]}};
	    int[] result={x[4],x[5]};
	          array=ar;
	     this.lastColumn=result;
	     resultTwo();
   }else if(x.length==12){
	   
	   
	   int[][] ar= {{x[0],x[1],x[2]},{x[3],x[4],x[5]},{x[6],x[7],x[8]}};
	   int[] result={x[9],x[10],x[11]};
	          array=ar;
	     this.lastColumn=result;
	     resultThree();
	     
	     
   }else if(x.length==20){
	   
   
	   int[][] ar= {{x[0],x[1],x[2],x[3]}
	              ,{x[4],x[5],x[6],x[7]}
	              ,{x[8],x[9],x[10],x[11]},
	              {x[12],x[13],x[14],x[15]}};
	   int[] result={x[16],x[17],x[18],x[19]};
		      array=ar;
		      
		   int[][] allM={{x[0],x[1],x[2],x[3],x[16]}
                        ,{x[4],x[5],x[6],x[7],x[17]}
                        ,{x[8],x[9],x[10],x[11],x[18]}
                        ,{x[12],x[13],x[14],x[15],x[19]}};
		      allMatrix=allM;
           
	     this.lastColumn=result;
	     resultFour();
   }else{
	  JOptionPane.showMessageDialog(null, MESSAGE_ERRORE); 
	  
	  System.exit(0);
   }
		
	}



	private void resultTwo(){
		Calculation calculation= new Calculation();
		determinantMain=calculation.determinantTwo(array);
		resaltColumn=calculation.raplace(array, lastColumn, ()-> {
			int i=calculation.determinantTwo(array);
			return i; }	);
		for(int i =0;i<resaltColumn.length;i++){
			
			System.out.println("x"+(i+1)+" = "+resaltColumn[i]+"/"+determinantMain);
		}

	}
	
	
	private void resultThree(){
		Calculation calculation= new Calculation();
		determinantMain=calculation.determinantTree(array);
		resaltColumn=calculation.raplace(array, lastColumn, ()-> {
				int i=calculation.determinantTree(array);
				return i; }	);
		for(int i =0;i<resaltColumn.length;i++){
			
			System.out.println("x"+(i+1)+" = "+resaltColumn[i]+"/"+determinantMain);
		}
	}
	
	private void resultFour(){
		Calculation calculation= new Calculation();
		
		//  основной определитель для всей матрицы
	determinantMain=calculation.determinantFour(array);
			
		
		// определитель с подставлением колонки с ответами
		resaltColumn=calculation.raplace(array, lastColumn, ()-> {

			int i=calculation.determinantFour(array);;
				return i; });
		
		for(int i =0;i<resaltColumn.length;i++){

			System.out.println("x"+(i+1)+" = "+resaltColumn[i]+"/"+determinantMain);
		}
	}
	


     public int[] getResult(){
    	 return resaltColumn;
     }

     public int[][] getMatrix(){
    	 return allMatrix;
    		 }
     
     public int getdeterminantMain(){
    	 return determinantMain;
     }
     
	}



