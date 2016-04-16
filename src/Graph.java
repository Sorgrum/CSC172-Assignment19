public class Graph {
    private int vertexCount, edgeCount;
    boolean directed;
    private boolean adj[][];
	private Node[] nodes;

    public Graph(int numVertices, boolean isDirected) {
        adj = new boolean[numVertices][numVertices];
        directed = isDirected;
        vertexCount = numVertices;
        edgeCount = 0;
    }

    public boolean isDirected() {
        return directed;
    }

    public int vertices() {
        return vertexCount;
    }

    public int edges() {
        return edgeCount;
    }

    public void show() {
        for (int s = 0; s < vertices(); s++) {
            System.out.print(s + ": ");
            AdjList A = getAdjList(s);
            for (int t = A.begin(); !A.end(); t = A.next()) // use of iterator
                System.out.print(t + " ");
            System.out.println();
        }
    }

    public void insert(Edge e) {

        if (directed) {
            if (!adj[e.v][e.w]) {
                adj[e.v][e.w] = true;
                edgeCount += 1;
            }
        } else {

            if (!adj[e.v][e.w] || !adj[e.w][e.v]) {
                adj[e.v][e.w] = true;
                adj[e.w][e.v] = true;
                edgeCount += 1;
            }
        }
    }

    public void delete(Edge e) {
        if (directed) {
            if (adj[e.v][e.w]) {
                adj[e.v][e.w] = false;
                edgeCount -= 1;
                vertexCount -= 2;
            }
        } else {
            if (adj[e.v][e.w] || adj[e.w][e.v]) {
                adj[e.v][e.w] = false;
                adj[e.w][e.v] = false;
                edgeCount -= 1;
                vertexCount -= 2;
            }
        }
    }

	public void findMinDistance(int s, int v) {
		unweighted(s);
		findPath(v);
	}

	public void findPath(int v) {
		if (nodes[v].parent == -1) {
			System.out.print(v + " ");
		} else {
			System.out.print(v + " < ");
			findPath(nodes[v].parent);
		}
	}

	public void unweighted (int s) {

		nodes = new Node[vertices()];
		for (int i = 0; i < vertices(); i++) {
			nodes[i] = new Node();
		}

		nodes[s].distance = 0;

		for (int currentDistance = 0; currentDistance < vertices(); currentDistance++) {
			for (int i = 0; i < vertices(); i++) {
				if (!nodes[i].known && nodes[i].distance == currentDistance) {
					nodes[i].known = true;
					for (int j = 0; j < vertices(); j++) {
						if (connected(i, j)) {
							if (nodes[j].distance == Integer.MAX_VALUE) {
								nodes[j].distance = currentDistance + 1;
								nodes[j].parent = i;
							}
						}
					}
				}
			}
		}
		System.out.println();
	}

    public boolean connected(int node1, int node2) { //are they connected? }
        return adj[node1][node2];
    }

    public AdjList getAdjList(int vertex) { // your code here }
        return new AdjArray(vertex);
    }

    private class AdjArray implements AdjList {
        private int v; // what vertex we are interested in
        private int i; // so we can keep track of where we are

        public AdjArray(int v) {
            this.v = v;
            i = -1;
// write the code for the constructors
// save the value of the vertex passed in
// (that will be where the iterator starts)
// start the “i” counter at negative one
        }

        public int next() { // perhaps the trickiest method
// use a for loop to advance the value of “i”
            for (++i; i < vertices(); i++) {
// and search the appropriate row return the index
// of the next true value found
                if (connected(v, i)) {
                    return i;
                }
            }
            // if the loop completes without finding anything return -1
            return -1;
        }

        public int begin() {
            i = -1;
            return next();
        }

        public boolean end() {
            return i >= vertices();

// if “i” is less than the number of vertices return false
        }
    }


}