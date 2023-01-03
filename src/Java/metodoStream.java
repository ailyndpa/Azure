package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class metodoStream {
	// @Test
	public void streamFilter() {
		ArrayList<String> nombre = new ArrayList<String>();
		nombre.add("Ailyn");
		nombre.add("Geider");
		nombre.add("Odalys");
		nombre.add("Antero");
		nombre.add("Andy");
		long cant = nombre.stream().filter(predicado -> predicado.startsWith("A")).count();
		System.out.println("CANTIDAD DE NOMBRES QUE EMPIEZAN CON A: " + cant);

		long cont = Stream.of("Claudia", "Alejandro", "Laika", "mama", "papa", "meme", "mimi").filter(predicado -> {
			predicado.startsWith("A");
			return true;
		}).count();
		System.out.println("CANTIDAD DE NOMBRES QUE EMPIEZAN CON A en el segundo stream: " + cont);

		nombre.stream().filter(predicado -> predicado.length() > 4).limit(20)
				.forEach(predicado -> System.out.println(predicado));
	}

	// @Test
	public void streamMap() {
		// imprimir en mayuscula los nombres que tienen a como ultima letra

		Stream.of("Claudia", "Alejandro", "Laika", "mama", "papa", "meme", "mimi")
				.filter(predicado -> predicado.endsWith("a")).map(predicado -> predicado.toUpperCase())
				.forEach(predicado -> System.out.println(predicado));

	}

	//@Test
	public void streamSorted() {
		// imprimir en mayuscula ordenardos los nombres que tienen a como primera letra

		String[] arreglo = { "Claudia", "alejandro", "aa" };
		List<String> list = Arrays.asList(arreglo);

		list.stream().filter(predicate -> predicate.startsWith("a")).sorted().map(predicate -> predicate.toUpperCase())
				.forEach(predicate -> System.out.println(predicate));
	}
	
	//@Test
	public void streamConcat() {
		// imprimir en mayuscula ordenardos los nombres que tienen a como primera letra

		String[] arreglo = { "Claudia", "Alejandro", "AA" };
		List<String> list = Arrays.asList(arreglo);
		
		var stream1=list.stream();
		var stream2= Stream.of("Ailyn", "Laura", "Maria", "Dignora", "Esmeregilda");
		Stream <String> concat=Stream.concat(stream1,stream2);
		//concat.sorted().forEach(predicate-> System.out.println(predicate));
		boolean contiene=concat.anyMatch(predicate->predicate.equalsIgnoreCase("maria"));
		Assert.assertTrue(contiene);
		
	}
	
	//@Test
	public void streamColletion() {
		//devuelve una nueva lista
		List<String> list=Stream.of("A", "B", "C", "D").filter(predicado -> predicado.equalsIgnoreCase("A")).collect(Collectors.toList());
		System.out.println(list.get(0));
	}
	
	//@Test
	public void streamdistinct() {
		//devuelve los elementos del stream sin repetirse
		List<Integer> values= Arrays.asList(1,2,5,8,2,1,9,10,8);
		values.stream().distinct().forEach(predicate->System.out.println(predicate));
	}
	
	public void stream() {
		//devuelve el cuarto elemento del stream luego de haberlo ordenado sin repeticiones
		List<Integer> values= Arrays.asList(1,2,5,8,2,1,9,10,8);
		List<Integer>newList=values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(newList.get(3));
	}
	
	
}
