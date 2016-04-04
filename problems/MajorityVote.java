package problems;

/**
 * The Boyer-Moore Vote Algorithm solves the majority vote problem in linear
 * time O(n) and O(1) space. The majority vote problem is to determine in any
 * given sequence of choices whether there is a choice with more occurrences
 * than all the others, and if so, to determine this choice. Mathematically,
 * given a finite sequence (length n) of numbers, the object is to find the
 * majority number defined as the number that appears more than n/2 times.
 * 
 * @author Ajinkya Patil
 */
public class MajorityVote {
	public static Integer findMajority(int[] arr) {
		// Phase 1: Find a candidate for majority element
		int major = arr[0];
		int count = 1;
		for (int i = 1; i < arr.length; i++) {
			if (major == arr[i]) {
				count++;
			} else {
				count--;
			}
			if (count < 1) {
				count = 1;
				major = arr[i];
			}
		}

		// Phase 2: Check whether the candidate is majority element or not
		count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (major == arr[i]) {
				count++;
			}
			if (count > arr.length / 2) {
				return new Integer(major);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] seq = new int[args.length];
		for (int i = 0; i < seq.length; i++) {
			seq[i] = Integer.parseInt(args[i]);
		}
		Integer major = findMajority(seq);
		System.out.println("Majority Vote: " + major);
	}
}
