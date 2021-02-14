package improveMySkills;

public class Driver4 {
	public static void main(String[] args) {
		int[] ar = { 2, 8, 30, 6, 10, -30, -10, -200 };

		// int maxT = maxTrip(ar);
		// System.out.println(maxT);

		Node1 n1 = new Node1(1);
		Node1 n2 = new Node1(2);
		Node1 n3 = new Node1(3);
		Node1 n4 = new Node1(4);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n2;

		if (checkCycle(n1))
			System.out.println("there's a cycle");

		else
			System.out.println("there's no cycle");

	}

	private static boolean checkCycle(Node1 head) {

		// 1 - > 2 -> 3 -> 4
		// ^
		// | - - - - |

		Node1 tmp = new Node1();
		Node1 cur = head;
		Node1 tmp2;
		while (cur != null) {

			if (cur.next == tmp)
				return true;
			tmp2 = cur;
			cur = cur.next;
			tmp2.next = tmp;

			// head = cur;

		}

		return false;
	}

	private static int maxTrip(int[] ar) {

		if (ar.length == 3) {
			return ar[0] * ar[1] * ar[2];
		}

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int maxProduct = ar[0] * ar[1] * ar[2];
		for (int i = 0; i < ar.length; i++) {
			if (i > 3) {
				if (ar[i] > 0 && min < ar[i]) {
					maxProduct = Math.max(maxProduct, (maxProduct / min) * ar[i]);
				} else {
					maxProduct = Math.max(maxProduct, max * min * ar[i]);
				}

			}
			if (ar[i] > max)
				max = ar[i];
			if (min > ar[i])
				min = ar[i];

		}
		return maxProduct;

	}

}

class Node1 {
	int val;
	Node1 next;

	public Node1() {

	}

	public Node1(int val) {
		this.val = val;
	}
}
