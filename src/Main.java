import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String graph1 = "graph1.txt";
		String graph2 = "graph2.txt";
		String graph3 = "graph3.txt";
		String graph4 = "graph4.txt";
		String graph5 = "graph5.txt";
		String graph6 = "graph6.txt";

		Graph g1 = readGraphFromFile(graph1);
		System.out.println("Graph 1");
		g1.show();
		g1.findMinDistance(5, 1);
		System.out.println();
		System.out.println("---------------");
		System.out.println();


		Graph g2 = readGraphFromFile(graph2);
		System.out.println("Graph 2");
		g2.show();
		g2.findMinDistance(5, 1);
		System.out.println();
		System.out.println("---------------");
		System.out.println();

		Graph g3 = readGraphFromFile(graph3);
		System.out.println("Graph 3");
		g3.show();
		g3.findMinDistance(3, 1);
		System.out.println();
		System.out.println("---------------");
		System.out.println();

		Graph g4 = readGraphFromFile(graph4);
		System.out.println("Graph 4");
		g4.show();
		g4.findMinDistance(11, 6);
		System.out.println();
		System.out.println("---------------");
		System.out.println();

		Graph g5 = readGraphFromFile(graph5);
		System.out.println("Graph 5");
		g5.show();
		g5.findMinDistance(0, 5);
		System.out.println();
		System.out.println("---------------");
		System.out.println();

		Graph g6 = readGraphFromFile(graph6);
		System.out.println("Graph 6");
		g6.show();
		g6.findMinDistance(9, 5);
		System.out.println();
		System.out.println("---------------");
		System.out.println();
	}

	public static Graph readGraphFromFile(String input) {
		Scanner scanner = new Scanner(System.in);

		try {
			scanner = new Scanner(new File(input));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		int numberOfNodes = Integer.parseInt(scanner.nextLine());
		String directed = scanner.nextLine();
		boolean isDirected = directed.equals("D");

		Graph g = new Graph(numberOfNodes, isDirected);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			Scanner rowScanner = new Scanner(line);

			int p1 = Integer.parseInt(rowScanner.next());
			int p2 = Integer.parseInt(rowScanner.next());

			g.insert(new Edge(p1, p2));

		}


		return g;


	}
}
