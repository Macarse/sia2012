package edificios;

import java.util.Random;

public class LevelGenerator {

	static int[][] m;
	static int [] numbers;
	static int dim = 8;
	

	public static void main(String[] args) {

		m = new int[dim][dim];
		Random rand = new Random();
		int count = dim * 5;
		numbers = new int[dim];
		int i, j;
		for( i = 0 ; i < dim ; i ++){
			numbers[i] = i+1;
		}
		while(count-- != 0){
			int a = rand.nextInt(dim);
			int b = rand.nextInt(dim);
			j = numbers[a];
			numbers[a] = numbers[b];
			numbers[b] = j;
		}
		for( i = 0 ; i < dim ; i ++){
			System.out.println(numbers[i]);
		}
		for (i = 0; i < dim; i++) {
			for (j = 0; j < dim; j++) {
				m[i][j] = 0;
			}
		}
		fillSpace(0, 0);
		for (i = 0; i < dim; i++) {
			String pr = "";
			for (j = 0; j < dim; j++) {
				pr += m[i][j] + ",";
			}
			System.out.println(pr);
		}
		System.out.println("FILE");
		System.out.println("-------------");
		System.out.println(dim);
		String pr = "";
		for (i = 0; i < dim; i++) {

			int h = checkHeight(0, i, 1, 0);
			pr += h;
			if (i != dim - 1) {
				pr += ",";
			}
		}
		System.out.println(pr);
		pr = "";
		for (i = 0; i < dim; i++) {

			int h = checkHeight(dim-1, i, -1, 0);
			pr += h;
			if (i != dim - 1) {
				pr += ",";
			}
		}
		System.out.println(pr);
		pr = "";
		for (i = 0; i < dim; i++) {

			int h = checkHeight(i, 0, 0, 1);
			pr += h;
			if (i != dim - 1) {
				pr += ",";
			}
		}
		System.out.println(pr);
		pr = "";
		for (i = 0; i < dim; i++) {

			int h = checkHeight(i, dim -1, 0, -1);
			pr += h;
			if (i != dim - 1) {
				pr += ",";
			}
		}
		System.out.println(pr);
	}

	public static int fillSpace(int r, int c) {
		if (c == dim) {

			return fillSpace(r + 1, 0);
		}
		if (r == dim) {
			return 1;
		}
		int k;
		for (k = 0; k < dim; k++) {
			if (isValid(r, c, numbers[k])) {
				m[r][c] = numbers[k];
				if (fillSpace(r, c + 1) == 1)
					return 1;
				m[r][c] = 0;
			}
		}
		return 0;
	}

	public static boolean isValid(int r, int c, int k) {
		int i;
		for (i = 0; i < r; i++) {
			if (m[i][c] == k)
				return false;
		}
		for (i = 0; i < c; i++) {
			if (m[r][i] == k) {
				return false;
			}
		}
		return true;
	}

	public static int checkHeight(int r, int c, int dr, int dc) {
		int currHeight = -1;
		int i, ret = 0;
		for (i = 0; i < dim; i++) {
			int num = m[r + dr * i][c + dc * i];
			if (num > currHeight) {
				ret++;
				currHeight = num;
			}
		}
		return ret;
	}

}
