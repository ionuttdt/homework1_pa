import java.io.*;
import java.util.*;

public class P2 {

    /*
	int[] v = vectorul cu elementele cu care are loc jocul intre cei doi
	int n = numarul de elemente din v
	int k = numarul de elemnte ce trebuie eliminate din v
	*/
	public static double getResult(Integer[] v, int n, int k) throws Error{
		// dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + v[i])
		double[][] dp = new double[n+1][n+1];

		//caz de baza pentru a nu calcula matricea cand elimin toate elementele
		if(n == k)
			return 0;
		//sortarea descrescatoare a elementelor din v
		Arrays.sort(v, Collections.reverseOrder()); 

		// pe prima coloana am priele i elemente cand elimin 0 numere
		dp[0][0] = v[0];
		for(int i = 1; i < n; i++) {
			if(i % 2 == 1)
				dp[i][0] = dp[i-1][0] - v[i];
			else
				dp[i][0] = dp[i-1][0] + v[i]; 
			dp[i][i] = v[0];
		}

		for(int j = 1; j < n ; j++) {
			for(int i = j+1; i < n; i++) {

				if( (i - j) % 2 == 1) 						//alege Tuzgu
					dp[i][j] = Math.max( dp[i-1][j] - v[i], dp[i-1][j-1] );
				else 										//alege Ritza
					dp[i][j] = Math.max( dp[i-1][j] + v[i], dp[i-1][j-1] );
			}
		}

		//daca ramane un numar impar de elemente, nu il elimin pe v[n-1]
		if( (n-k) % 2 == 1 )
			return dp[n-1][k];
		return dp[n-1][k-1];
	}

	public static void main(String[] args) throws Exception{

		//fisierul cu datele de intrare
		FileReader file = new FileReader("p2.in");

		//Buffer pentru scriere si citire
		BufferedReader br = new BufferedReader(file);
		BufferedWriter writer = new BufferedWriter(new FileWriter("p2.out", true));

		//n si k
		String n_k = br.readLine();
		String[] nk = n_k.split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);

		//elementele din vector
		String input = br.readLine();
		String[] vaux =  input.split(" ");
		Integer[] v = new Integer[n];
		for(int i = 0; i < n; i++)
			v[i] = Integer.parseInt(vaux[i]);

		//raspunsul optim
		double ans = getResult(v, n, k);
		writer.write(String.format("%.0f",ans));
		System.out.println(String.format("%.0f",ans));

		//inchiderea bufferelor
		br.close();
		writer.close();		

	}
}