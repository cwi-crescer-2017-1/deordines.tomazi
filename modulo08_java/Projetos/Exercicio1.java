import java.io.BufferedReader;
import java.io.InputStreamReader;

class Exercicio1 {
  public static void main(String[] args) { 
		try (final InputStreamReader inputStreamReader = new InputStreamReader(System.in)) {
		try (final BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
				int numero = Integer.parseInt(bufferedReader.readLine());
				if (numero % 2 == 0) {
						System.out.println("Par");
				}
				else {
						System.out.println("Impar");
				}

		} catch (Exception e) {
			//...
		}
	} catch (Exception e) {
		//...
	}
  }
}