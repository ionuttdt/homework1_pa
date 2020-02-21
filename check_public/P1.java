import java.io.*;
import java.util.*;

public class P1 {

	public static int getResult(int[] v, int n) {

		//sortarea elementelor folosind functia din java
		Arrays.sort(v);
		int tuzgu = 0, ritza = 0;
		int i = 0;

		//cazul in care tuzgu alege n/2 + 1 numere
		if(n % 2 == 1) {
			i++;
			tuzgu += v[0];
		}

		//elimin pe rand cate doua numere 
		for(; i < n ; i = i + 2) {
			ritza += v[i];
			tuzgu += v[i+1];
		}

		return tuzgu - ritza;
	}

	public static void main(String[] args) throws Exception {
//		long startTime = System.currentTimeMillis();
		//fisierul cu datele de intrare
		FileReader file = new FileReader("p1.in");

		//Buffer pentru scriere si citire
		BufferedReader br = new BufferedReader(file);
		BufferedWriter writer = new BufferedWriter(new FileWriter("p1.out", true));

		//numarul de elemente din vector
		int n = Integer.parseInt(br.readLine());

		//elementele din vector
		String input = br.readLine();
		String[] vaux =  input.split(" ");
		int[] v = new int[n];
		for(int i = 0; i < n; i++)
			v[i] = Integer.parseInt(vaux[i]);

		//raspunsul optim
		int ans = getResult(v, n);
		writer.write(String.valueOf(ans));

		//inchiderea bufferelor
		br.close();
		writer.close();
//			long stopTime = System.currentTimeMillis();
//      	long elapsedTime = stopTime - startTime;
//      	System.out.println(elapsedTime);

	}

}