package Java;

import java.util.ArrayList;

public class JavaIntroduction {
	
	public static void main(String[] args) {
		//Para declarar un arreglo en este caso es de entero para un espacio en memoria de 5 valores
		String [] array= new String[5];
		//Asignando valores
		array[0]="zero";
		array[1]="one";
		array[2]="two";
		array[3]="three";
		array[4]="four";
		
		System.out.println("El arreglo array en la posición 0 tiene como valor: "+array[0]);
		
		//Otra manera de crear y asignar valores a un array
		int [] array2= {5,6,7,8,9,10};
		System.out.println("El arreglo array2 en la posición 3 tiene como valor: "+array2[3]);
		
		//loop 
		System.out.println("Imprimiendo valores del arreglo array: ");
		for(int i=0; i<array.length;i++) {
			System.out.println(array[i]);
		}
		System.out.println("Imprimiendo valores del arreglo array2: ");
		//otra manera con menos complicación
		for(int valor: array2) {
			System.out.println(valor);	
		}
		//Imprimir los valores pares del array2
		System.out.println("Imprimiendo valores pares del arreglo array2: ");
		for(int valor: array2) {
			if(valor%2==0) {
				System.out.println(valor);
				//break; se usa para salir del ciclo una vez que encuentre un valor par
			}
		}
		
		ArrayList<String> lista=new ArrayList<String>();
		lista.add("Ailyn");
		lista.add("Geider");
		lista.add("blablabla");
		lista.add(0, "Odalys");
		
		System.out.println("ArrayList "+lista);
		System.out.println("valor3Lista "+lista.get(3));
		
		for(String valor: lista) {
			System.out.println("valor= "+valor);
		}
		 
		String nombreCompleto="Ailyn del Pino Acosta";
		String[] arreglo=nombreCompleto.split(" ");
		System.out.println(arreglo[0]);		
				
		System.out.println("Imprimiendo el nombre completo en posición vertical de alante hacia atras");
		for(int i=0; i<nombreCompleto.length();i++) {
			System.out.println(nombreCompleto.charAt(i));
		}
		System.out.println("Imprimiendo el nombre completo en posición vertical de atras hacia delante");
		for(int i=nombreCompleto.length()-1; i>=0;i--) {
			System.out.println(nombreCompleto.charAt(i));
		}
		// llamando un metodo de la clase java2
		Java2 nombre= new Java2();
		nombre.Nombre();
		/*para poder llamar un metodo dentro de la misma clase pero fuera del 
		  main este tiene que ser estatico o por el contrario se debe crear un
		  objeto de la clase para llamarlo*/
		metodoExtra();
		JavaIntroduction obj= new JavaIntroduction();
		obj.metodoExtra2();
	}
	
	public static void metodoExtra() {
		System.out.println("Fuera del main");
	}
	public  void metodoExtra2() {
		System.out.println("Fuera del main!!!!!!!!!!");
	}
}
