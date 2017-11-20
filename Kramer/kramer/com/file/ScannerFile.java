package com.file;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.create.Create;

/**
 * Данный класс считывает значение из файла и формирует одномерный массив для 
 * класса Create.java
 * 
 * Затем он получает из этого же класса рузультат и записывает в этот же файл.
 * 
 * @author oleg
 *
 */
public class ScannerFile{

	private Create create;
	
	private int[] allMatrix;
	
	private String path;
	
	private String split;
	

	
	
	
	/**
	 * 
	 * 
	 * @param path полный путь к файлу
	 */
	public ScannerFile(String path,String split) {
	this.path=path;
	this.split=split;

	}
	
	public int[] getMatrix(){
		return allMatrix;
	}
	
	
	
	/**
	 * Класс BufferedReader считывает текст из символьного потока ввода, буферизируя прочитанные символы. 
	 * Использование буфера призвано увеличить производительность чтения данных из потока.
	 * Метод     redLine() по строчно сканирует данный из файла
	 * затем парсит это значение записывая цифры в массив  пропуская запятые.
	 * После  записывается в массив типа Integer и отпрвляется в конструктор класса com.create.Create.java
	 * 
	 */
	public  void read(){

          try(BufferedReader bf= new BufferedReader(new FileReader(path))){

        	    
	  	    	String    count;// созданна для получения символов из файла

		        String[] array = null;//массив, который будет хранить разложеные данные
	  	    	
            try{
            
		      
			while((count=bf.readLine())!=null){ // получение данных
            
			count=count.trim(); // убираем пробелы по краям
			
			count = count.replaceAll( " ","");// убираем пробелы в нутри
			
			if(count != null && count.trim().isEmpty()) continue; //проверяем  наличие пустых строк

				
		    	array=count.split(Pattern.quote(split));  //обавляем значение в массив

			 }
			
		    	allMatrix= new int[array.length]; // инициализируем массив для коструктора класса Create(int...x);
			
		    	
		    		
		     for(int i=0;i<allMatrix.length;i++) 
		    	 allMatrix[i]=Integer.parseInt(array[i]); //  добаляем значение в int-отвый массив из array[]
		    
		    		create  = new Create(allMatrix);     // помещаем массив в конструктор
		    	 
		    	}catch (Exception e) {
		    		
		    		
		    		/*
		    		 * если данные записанны не коректно(разные разделители,буквенные значения),
		    		 * то всплывает окно с ошибкой
		    		 */
		    		JOptionPane.showMessageDialog(null,
		                    new String[] {"Проверьте текстовый файл ,возможно у вас такие ошибки:",
		                                  " - буквенное значение.",
		                                  " - неправильный разделитель."},
		                    new java.lang.NumberFormatException().toString()
		                                  ,
		                                  JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
		    	System.exit(1);  //и выход с ошибкой
					
				}

	    	}catch (IOException e) {
	    		JOptionPane.showMessageDialog(null,
                    "Файл не найден!",
              new IOException().toString()
                            ,
                            JOptionPane.ERROR_MESSAGE);e.printStackTrace();
                            System.exit(1);
                            }
}
	
	    
	
	
	/**
	 * Забирает полную матрицу и корни уравнения
	 *  из класса com.create.Create.java, и записывает его в файл 
	 *  байтовым потоком.
	 * 
	 */
	 public  void write(){
	    	 
	    	 String matrix="";
	         String result="";
	         
	    	 try(FileOutputStream fos= new FileOutputStream(path);) {
	    		 
	    		 
	  		   for(int i=0;i<create.getMatrix().length;i++){
	  			   
	    			   matrix+="\r\n";

	    			   result+="x"+(i+1)+":="+create.getResult()[i]+"/"+create.getdeterminantMain()+"\r\n";
	    			   
	    			   for(int j=0;j<create.getMatrix()[i].length;j++){
	    				   
	    				   matrix+=create.getMatrix()[i][j]+" ";
	    			   }
	    			   
	    		   }
	    		   
              String res="\n"+
            		  "==========================="+"\r\n"+
            		  "      Метод Крамера        "+"\r\n"+
            		  "==========================="+"\r\n"+
            		  "matrix:"+"\r\n"+matrix+"\r\n"+ 
            		  "\r\n"+
            		  "result:"+"\r\n"+"\r\n"+result+"\r\n";

	              byte[] b1=res.getBytes();
	                fos.write(b1, 0, b1.length);
               
                  
	           }
	           catch(IOException ex){
	                
	               System.out.println(ex.getMessage());
	           } 
	     }

}
