package question2.app.greatlearning.main;

import question2.app.greatlearning.skewtree.*;

public class BSTRightSkewDriver {

	public static void main(String[] args) {
		// hardcoded inputs
		BSTNode root = new BSTNode(50);
		root.left = new BSTNode(30);
		root.right = new BSTNode(60);
		root.left.left = new BSTNode(10);
		root.right.left = new BSTNode(55);

		// Call method to convert tree to right skew
		SkewOfBinarySearchTree bstSkew = new SkewOfBinarySearchTree();

		BSTNode resultTreeRoot = bstSkew.rightSkewConversion(root);

		// print output

		BSTNode itr = resultTreeRoot;

		while (itr != null) {
			System.out.println(itr.data);
			itr = itr.right;
		}

	}

}
