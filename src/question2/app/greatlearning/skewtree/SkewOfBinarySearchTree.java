package question2.app.greatlearning.skewtree;

import java.util.LinkedList;
import java.util.Queue;
import question2.app.greatlearning.main.*;

public class SkewOfBinarySearchTree {

	static Queue<BSTNode> qInOrder;

	public BSTNode rightSkewConversion(BSTNode root) {
		/*
		 * ******************Algorithm*********************
		 * 
		 * 1. Store the inorder traversal of bst in a queue. This will store the binary
		 * search tree in sorted order. 2. Traverse the queue and insert the node as the
		 * right child of the parent node.
		 */

		/*
		 * 1. Store the inorder traversal of bst in a queue. This will store the binary
		 * search tree in sorted order.
		 */
		qInOrder = new LinkedList<BSTNode>();
		inOrder(root);

		/*
		 * 2. Traverse the queue and insert the node as the right child of the parent
		 * node.
		 */

		BSTNode rightSkewTreeRoot = null;
		BSTNode temp = null; //temp is an iterator used to form the right skewed tree 

		while (!qInOrder.isEmpty()) {
			if (rightSkewTreeRoot == null) {
				rightSkewTreeRoot = qInOrder.poll();
				temp = rightSkewTreeRoot;
				temp.right = null;
			}

			else {
				temp.right = qInOrder.poll();
				temp = temp.right;
			}

		}

		return rightSkewTreeRoot;
	}

	void inOrder(BSTNode node) {
		if (node == null)
			return;
		if (node.left == null && node.right == null) {
			qInOrder.add(node);
			return;
		}

		inOrder(node.left);

		qInOrder.add(node);

		inOrder(node.right);
	}
}
