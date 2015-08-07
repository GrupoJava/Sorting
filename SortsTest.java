import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
public class SortsTest {

	@Test
	public void test() {
		Sorts Prueba = new Sorts(2);
		
		ArrayList<Comparacion> v = new ArrayList<Comparacion>();
		Comparacion a = new Comparacion(2);
		Prueba.agregar(2);
		Prueba.agregar(1);
		Prueba.agregar(10);
		Prueba.agregar(9);
		Prueba.SelectionSort();
		
		for (int i = 0; i<4; i++){
			System.out.println(Prueba.obtener(i));
		}
		
	}

}
