import java.util.Random;

public class TestDemo {

	// This method takes two integers as input, checks whether they are positive,
	// and then returns their sum. If either number isn't positive, it throws an
	// IllegalArgumentException.

	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
		} else if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		return a + b;
	}

	// This method generates a random integer, squares it, and then returns the
	// result.

	int randomNumberSquared() {
		int randomInt = getRandomInt();
		return randomInt * randomInt;
	}

	// This method generates a random integer between 1 and 10 using the Random
	// class.

	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}
