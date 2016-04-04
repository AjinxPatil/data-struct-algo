package problems;

/**
 * <code>BinNumGenerator</code> generates sequence of binary numbers.
 * 
 * @author Ajinkya Patil
 */
public class BinNumGenerator {
	/**
	 * Generates sequence of <code>n</code> binary numbers starting from 0. Time
	 * complexity is O(n).
	 * 
	 * @param n
	 *          the number of binary numbers to generate
	 * @return array of binary numbers
	 */
	public static StringBuffer[] generate(int n) {
		StringBuffer[] bins = new StringBuffer[n];
		StringBuffer ZERO = new StringBuffer("0");
		StringBuffer ONE = new StringBuffer("1");
		if (n == 1) {
			bins[0] = ZERO;
			return bins;
		}
		bins[0] = ZERO;
		bins[1] = ONE;
		if (n == 2) {
			return bins;
		}
		int sel = 1;
		int gen = 2;
		boolean isZero = true;
		while (gen < n) {
			if (isZero) {
				bins[gen] = new StringBuffer().append(bins[sel]).append(ZERO);
				isZero = false;
			} else {
				bins[gen] = new StringBuffer().append(bins[sel++]).append(ONE);
				isZero = true;
			}
			gen++;
		}
		return bins;
	}

	public static void main(String[] args) {
		StringBuffer[] result = generate(Integer.parseInt(args[0]));
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i].toString());
		}
	}
}
