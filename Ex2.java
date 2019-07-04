import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Collections;

class Ex2 {
	private static ArrayList<Integer> numbers;

	private void quickSort(int p, int q) {
		if (p >= q) return;

		int i = less(p,q);
		int j = equals(i,q);
		quickSort(p,i-1);
		quickSort(j+1,q);
	}

	private int less(int p, int q) {
		int r = randomInt(p,q);
		Collections.swap(numbers,r,q);//swaps the random number with the last integer

		int i = p;
		int element = numbers.get(q);

		for (int j = q;j > i;) {
			if (numbers.get(i) < element) {
				++i;
			} else {
				Collections.swap(numbers,i,--j);
			}
		}

		return i;
	}

	private int equals(int p, int q) {
		int i = p;
		int element = numbers.get(q);

		for (int j = p; j < q;) {
			if (numbers.get(j) == element) {
				Collections.swap(numbers,i++,j++);
			} else {
				++j;
			}
		}
		Collections.swap(numbers,i,q);

		return i;
	}

	private int randomInt(int p, int q) {
		return p + (int) ((q-p+1)*Math.random());//returns an integer in the range [p,q]
	}

	public static void main(String[] args) throws IOException {
		File file = null;
		try {
			file = new File(args[0]);
		} catch (Exception e) {
			System.err.println("No file found!");
			return;
		}
		
		Ex2 ex = new Ex2();
		numbers = (ArrayList<Integer>) Utilities.convertFileSequenceToList(file);

		ex.quickSort(0,numbers.size()-1);

		System.out.println("Sorting list of numbers:\n" + numbers);
	}
}