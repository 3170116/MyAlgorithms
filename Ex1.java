import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class Ex1 {
	private static ArrayList<Integer> numbers;

	private int findMostLeft(int x) {
		if (x < this.numbers.get(0) || x > this.numbers.get(numbers.size()-1)) return -1;
		int a = 0;
		int b = this.numbers.size();
		int left = -1;

		for (int i = 0; i != Math.round(Math.log(numbers.size())/Math.log(2)) + 1; ++i) {
			int place = (a+b)/2;
			int element = numbers.get(place);

			if (element == x) {
				left = place;
				b = place-1;
			} else if (left >= 0) {
				a = place+1;
			} else {
				if (x < element) {
					b = place-1;
				} else {
					a = place+1;
				}
			}
		}

		return left;
	}

	private int findMostRight(int x) {
		if (x < this.numbers.get(0) || x > this.numbers.get(numbers.size()-1)) return -1;
		int a = 0;
		int b = this.numbers.size();
		int right = -1;

		for (int i = 0; i != Math.round(Math.log(numbers.size())/Math.log(2)) + 1; ++i) {
			int place = (a+b)/2;
			int element = numbers.get(place);

			if (element == x) {
				right = place;
				a = place+1;
			} else if (right >= 0) {
				b = place-1;
			} else {
				if (x < element) {
					b = place-1;
				} else {
					a = place+1;
				}
			}
		}

		return right;
	}

	public static void main(String[] args) throws IOException {
		File file = null;
		try {
			file = new File(args[0]);
		} catch (Exception e) {
			System.err.println("No file found!");
			return;
		}
		
		Ex1 ex = new Ex1();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int x = sc.nextInt();
		System.out.println("");
		numbers = (ArrayList<Integer>) Utilities.convertFileSequenceToList(file);


		int left = ex.findMostLeft(x);
		int right = ex.findMostRight(x);

		System.out.println("The most left place of "+ x +" is "+ left);
		System.out.println("The most right place of "+ x +" is "+ right);
	}
}