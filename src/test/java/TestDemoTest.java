import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class TestDemoTest {

	// Instance variable for the class we're testing.

	private TestDemo testDemo;

	// Setup method that is run before each test. Initializes the class we're
	// testing.

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	// Checks the 'addPositive' method. It uses parameters
	// provided by the method 'argumentsForAddPositive'.

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {

		// If no exception is expected, it verifies that the 'addPositive' method
		// returns the correct sum.
		// If an exception is expected, it verifies that the 'addPositive' method throws
		// an IllegalArgumentException.

		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
	}

	// Provides the parameters for the
	// 'assertThatTwoPositiveNumbersAreAddedCorrectly' method.

	static Stream<Arguments> argumentsForAddPositive() {

		// Each line provides a set of parameters for one invocation of the test.
		// The last parameter (a boolean) indicates whether an exception is expected.

		return Stream.of(
				arguments(2, 4, 6, false), // 2 + 4 = 6
				arguments(10, 5, 15, false), // 10 + 5 = 15
				arguments(100, 200, 300, false), // 100 + 200 = 300
				arguments(-1, 1, 0, true), // Negative number should throw exception
				arguments(1, -1, 0, true), // Negative number should throw exception
				arguments(0, 1, 1, true), // 0 + 1 = 1
				arguments(1, 0, 1, true), // 1 + 0 = 1
				arguments(0, -1, -1, true) // Negative number should throw exception
		);

	}

	// This test verifies that the 'randomNumberSquared' method works correctly when
	// 'getRandomInt' returns 5.

	@Test
	void assertThatNumberSquaredIsCorrect() {

		// Creates a spy of the testDemo object. This is a special test double that can
		// be used to stub specific methods,
		// while the unstubbed ones keep their original behavior.

		TestDemo mockDemo = spy(testDemo);

		// Stub the getRandomInt method to always return 5 when called.

		doReturn(5).when(mockDemo).getRandomInt();

		// Call randomNumberSquared on the spied object. Because getRandomInt is stubbed
		// to return 5, this should return 5*5=25.

		int fiveSquared = mockDemo.randomNumberSquared();

		// Assert that the result of randomNumberSquared is indeed 25.

		assertThat(fiveSquared).isEqualTo(25);
	}
}
