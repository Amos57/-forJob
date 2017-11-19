package com.create;

import javax.swing.JOptionPane;

/**
 * Данный класс находит определитель матрицы по минорам:
 * определитель вычисляется от маленьких матриц к большим.
 * 
 * @author oleg
 *
 */
public class Calculation {

	/**
	 * Поиск определителя для матрицы 3х2
	 * 
	 * @param ar - матрица
	 * @return определитель
	 */
	public int determinantTwo(int [][] ar){
		
		
		int[][] d = new int[2][2];

		for(int i1=2, i2=0; i2<2; i2++, i1--){
			for(int j1=2, j2=0; j2<2; j2++, j1--){
				d[i2][j2]=ar[ar.length-i1][ar.length-j1];
			}
		}
		
		int result=d[0][0]*d[1][1]-d[0][1]*d[1][0];
		
		 if(result==0){ JOptionPane.showMessageDialog(null, "Определитель равен нулю, решений нет!");
		 System.exit(0);}
		return result;
	}
	
	
	/**
	 * Поиск определителя для матрицы 4х3
	 * 
	 * @param ar - матрица
	 * @return определитель
	 */
	public int determinantTree(int [][] ar){
		

		int[][] d = new int[2][2];
		int result=0;
		
		for(int i1=2, i2=0; i2<2; i2++, i1--){
			for(int j1=2, j2=0; j2<2; j2++, j1--){
				d[i2][j2]=ar[ar.length-i1][ar.length-j1];
			}
		}
		
		result+=ar[0][0]*determinantTwo(d);
		
		
		for(int i1=2, i2=0; i2<2; i2++, i1--){
			for(int j1=3, j2=0; j2<2; j2++, j1--){
				if(j1==2) j1-=1;
				d[i2][j2]=ar[ar.length-i1][ar.length-j1];
			}
		}
		
		
		result-=(ar[0][1]*determinantTwo(d));


		
		for(int i1=2, i2=0; i2<2; i2++, i1--){
			for(int j1=3, j2=0; j2<2; j2++, j1--){
				d[i2][j2]=ar[ar.length-i1][ar.length-j1];
			}
		}
		
		
		result+=(ar[0][2]*determinantTwo(d));
 if(result==0){ 
	 JOptionPane.showMessageDialog(null, "Определитель равен нулю, решений нет!");
 System.exit(0);}

 return result;
		
		

	}
	
	/**
	 * Поиск определителя для матрицы 5х4
	 * 
	 * @param ar - матрица
	 * @return определитель
	 */
	public int determinantFour(int [][] ar){
		int[][] d = new int[3][3];
		
		int result=0;


		
		for(int i1=3, i2=0; i2<3; i2++, i1--){
			for(int j1=3, j2=0; j2<3; j2++, j1--){
				d[i2][j2]=ar[ar.length-i1][ar.length-j1];
			}
		}
		
			result=ar[0][0]*determinantTree(d);

		
		for(int i1=3, i2=0; i2<3; i2++, i1--){
			for(int j1=4, j2=0; j2<3; j2++, j1--){
				if(j1==3) j1--;
				d[i2][j2]=ar[ar.length-i1][ar.length-j1];
			}
		}

		result-=ar[0][1]*determinantTree(d);


		
		for(int i1=3, i2=0; i2<3; i2++, i1--){
			for(int j1=4, j2=0; j2<3; j2++, j1--){
				if(j1==2) j1--;
				d[i2][j2]=ar[ar.length-i1][ar.length-j1];
			}
		}
		
		result+=ar[0][2]*determinantTree(d);

		
		for(int i1=3, i2=0; i2<3; i2++, i1--){
			for(int j1=4, j2=0; j2<3; j2++, j1--){
				d[i2][j2]=ar[ar.length-i1][ar.length-j1];
			}
		}
		
		result-=ar[0][3]*determinantTree(d);

	
		 if(result==0){ 
	       JOptionPane.showMessageDialog(null, "Определитель равен нулю, решений нет!");
		   System.exit(0);
		 }
		return result;
	}
	
	/**
	 * Этот метод поочерёдно меняет столбцы подставляет в каждый столбец матрицы колонку,
	 * которая располажена после равно
	 * 
	 * @param ar  матрица
	 * @param res массив последнего столбца(после равно)
	 * @param determinat определитель каждого уравнения с подставленным решением
	 * @return массив из корней уравнения в виде дроби
	 */
	public int[] raplace(int[][] ar,int[] res,Determinant determinat){
		
	    int[] d= new int[ar.length]; //массив для хранения определителей уравнения
	    
	    
	    
		int[] temp=new int[ar.length]; //Хранение заменяемого столбца матрицы
		
		for(int i=0;i<res.length;i++){
			
			for(int j=0;j<res.length;j++){
				
			temp[j]=ar[j][i];
			
			ar[j][i]=res[j];  //замена колонки 

		   }

			
			/*
	        * Получение списка определитей данного уравнения ,
			* которые делятся каждый на главный определитель
	        */
			d[i]=determinat.determinant();//
			
			for(int k=0;k<res.length;k++){
				ar[k][i]=temp[k]; // возвращение столбца на ее место

			}

		}

		return d;
	}

}
