/**
 * Student Name: Marcelo Gheiler
 * Filename: Node
 * Date: 4/16/16
 * TA Name: Shengbo Ge
 * Assignment:
 * Lab: MW 2-3:15pm
 * Lab Location: Gavett 244
 * I affirm that I have not given or received any unauthorized help on this assignment, and that this work is my own
 */
public class Node {
	int distance;
	int parent;
	boolean known;

	public Node() {
		distance = Integer.MAX_VALUE;
		parent = -1;
		known = false;
	}
}
