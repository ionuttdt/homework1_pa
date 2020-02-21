import java.io.*;
import java.util.*;

public class P3 {

	public static int getResult(int[] v, int n) {
		
		int tuzgu = 0, ritza = 0;
		int left = 0, right = n-1;
		int[] difR = new int[n];
		int[] difL = new int[n];

		for(int i = 0; i < n - 1; i++) {
			difR[i+1] = v[i+1] - v[i];
			difL[i] = -difR[i+1];
		}

		for(int i = 0; i < n; i++) {
			if(i % 2 == 0) {
				if(right == 0) {
					tuzgu += v[right];
					break;
				}
				if(left == n-1) {
					tuzgu += v[left];
					break;
				}
				if(difR[left + 1] == difL[right -1]) {
					if(v[left] > v[right]) {
						tuzgu += v[left];
						left++;
					}
					else {
						tuzgu += v[right];
						right--;
					}
				}
				else if(difR[left + 1] > difL[right -1]) {
					tuzgu += v[right];
					right--;
				}
				else {
					
					tuzgu += v[left];
					left++;
				}
			}
			else {
				if(right == 0) {
					ritza += v[right];
					break;
				}
				if(left == n-1) {
					ritza += v[left];
					break;
				}
				if(difR[left + 1] == difL[right -1]) {
					if(v[left] > v[right]) {
						ritza += v[left];
						left++;
					}
					else {
						ritza += v[right];
						right--;
					}
				}
				else if(difR[left + 1] > difL[right -1]) {
					ritza += v[right];
					right--;
				}
				else {
					
					ritza += v[left];
					left++;
				}
			}
		}

		return tuzgu - ritza;
	}

	public static void main(String[] args) throws Exception {
//		long startTime = System.currentTimeMillis();
		//fisierul cu datele de intrare
		FileReader file = new FileReader("p3.in");

		//Buffer pentru scriere si citire
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