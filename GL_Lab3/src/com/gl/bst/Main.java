package com.gl.bst;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		Node root = new Node(40);

		root.left = new Node(20);
		root.right = new Node(60);

		root.left.left = new Node(10);

		root.left.right = new Node(30);

		root.right.left = new Node(50);

		root.right.right = new Node(70);

		// GL problem statement, Sum = 130 Pair is (60,70)
		int sum = 130;

		// using simple set
		Set<Integer> set = new HashSet<>();

		if (!findPair(root, sum, set)) {
			System.out.println("Nodes are not found.");
		}
	}

	public static boolean findPair(Node root, int sum, Set<Integer> set) {

		if (root == null) {
			return false;
		}

		if (findPair(root.left, sum, set)) {
			return true;
		}

		if (set.contains(sum - root.data)) {
			System.out.println("Pair found (" + (sum - root.data) + ", " + root.data + ")");
			return true;
		} else {
			set.add(root.data);
		}

		return findPair(root.right, sum, set);
	}

}