import java.io.*;
import java.util.*;

public class P3 {

	/*
	int[] v = vectorul cu elementele cu care are loc jocul intre cei doi
	int n = numarul de elemente din v
	*/
	public static double getResult(int[] v, int n) {
		// calculez diferenta maxima pentru un vector care contine elementele
		// de la i la j (dp[i][j])
		double[][] dp = new double[n][n];

		for(int i = 0; i < n-1; i++) {

			dp[i][i+1] = v[i+1] - v[i];
			if(dp[i][i+1] < 0)					//Tuzgu alege mereu elementul mai mare
				dp[i][i+1] = -dp[i][i+1];
			dp[i][i] = v[i];
		}
		dp[n-1][n-1] = v[n-1];

		//algoritmul aplicat pentru a calcula diferenta maxima
		//(detalii despre implementare in README)
		for(int i = 2; i <= k; i++) {
			for(int j = 0, k = i; k < n; j++, k++) {
				dp[j][k] = Math.max(dp[j][j] - dp[j+1][k], dp[k][k] - dp[j][k-1]);
			}
		}
		//diferenta maxima
		return dp[0][n-1];
	}

	public static void main(String[] args) throws Exception {

		//fisierul cu datele de intrare
		FileReader file = new FileReader("p3.in");

		//buffer pentru scriere si citire
		BufferedReader br = new BufferedReader(file);
		BufferedWriter writer = new BufferedWriter(new FileWriter("p3.out", true));

		//numarul de elemente din vector
		int n = Integer.parseInt(br.readLine());

		//elementele din vector
		String input = br.readLine();
		String[] vaux =  input.split(" ");
		int[] v = new int[n];
		for(int i = 0; i < n; i++)
			v[i] = Integer.parseInt(vaux[i]);

		//raspunsul optim
		double ans = getResult(v, n);
		writer.write(String.format("%.0f",ans));
		System.out.println(ans);

		//inchiderea bufferelor
		br.close();
		writer.close();

	}

}