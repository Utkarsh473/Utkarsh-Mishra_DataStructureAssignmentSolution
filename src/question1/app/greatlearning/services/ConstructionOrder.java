package question1.app.greatlearning.services;

import java.util.Stack;

public class ConstructionOrder {

	Stack<Integer> st = new Stack<>();

	void sortStack(int[] arr) {
		Stack<Integer> tempSt = new Stack<>();
		if (arr.length == 0) {
			return;
		}

		st.push(arr[0]);
		int i = 1;
		int el;
		while (i < arr.length) {
			el = (int) st.peek();
			if (arr[i] >= el)
				st.push(arr[i]);
			else {
				el = (int) st.peek();
				while (arr[i] < el && !st.isEmpty()) {
					tempSt.push(st.pop());
					if (st.isEmpty())
						break;
					else
						el = (int) st.peek();
				}
				st.push(arr[i]);

				while (!tempSt.isEmpty())
					st.push(tempSt.pop());
			}
			i++;
		}
	}

	public void printOrder(int[] floor) {
		/*
		 * 1.create stack of floor sizes in sorted order 2.Iterate through the array and
		 * mark the traversed elements as visited in the visited array 3. If the array
		 * element is equal to the elemnt present at the top of stack, keep popping
		 * until unvisited element is encountered
		 */

		// 1. Create stack of floor sizes in sorted order
		sortStack(floor);

		// 2.Iterate through the array and mark the traversed elements as visited in the
		// visited array
		boolean[] visited = new boolean[floor.length];
		for (int i = 0; i < floor.length; i++) {
			visited[floor[i] - 1] = true;
			/*
			 * 3. If the array element is equal to the elemnt present at the top of stack,
			 * keep popping until unvisited element is encountered
			 */
			System.out.println("Day: " + (i + 1));
			if (floor[i] != (int) st.peek())
				System.out.println();
			else {
				while (!st.isEmpty() && visited[(int) st.peek() - 1]) {
					int el = st.pop();
					System.out.print(el + " ");
				}
				System.out.println();
			}
		}
	}

}
