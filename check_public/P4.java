import java.io.*;
import java.util.*;

public class P1 {

	/*
	int n = numarul de elemente din v
	int k = diferenta dintre scorul lui Tuzgu si Ritzei
	int v = valoarea maxima a elementelor din v
	*/
	public static int getResult(int n, int k, int v) {
		return 0;
	}	

	public static void main(String[] args) throws Exception {

		int n, k, v;

		//fisierul cu datele de intrare
		FileReader file = new FileReader("p4.in");

		//Buffer pentru scriere si citire
		BufferedReader br = new BufferedReader(file);
		BufferedWriter writer = new BufferedWriter(new FileWriter("p4.out", true));

		String input = br.readLine();
		String[] vaux =  input.split(" ");

		n = Integer.parseInt(vaux[0]);
		k = Integer.parseInt(vaux[1]);
		v = Integer.parseInt(vaux[2]);

		//raspunsul optim
		int ans = getResult(n, k, v);
		writer.write(String.valueOf(ans));

		//inchiderea bufferelor
		br.close();
		writer.close();
	}

}