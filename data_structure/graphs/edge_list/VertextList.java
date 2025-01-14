package data_structure.graphs.edge_list;

public class VertextList {
    private String[] vertexList;
    private int vertexPointer = 0;
    private Edge[] edgeList;
    private int edgePointer = 0;

    public VertextList(int vertices) {
        vertexList = new String[vertices];
        edgeList = new Edge[vertices];
    }

    public boolean isOutOfBounds(int position) {
        return position < 0 || position > vertexPointer;
    }

    public boolean isEdgeEmpty() {
        return edgePointer == 0;
    }

    public boolean isVerticeEmpty() {
        return vertexPointer == 0;
    }

    public boolean isVerticeFull() {
        return vertexPointer == vertexList.length;
    }

    public boolean isEdgeFull() {
        return edgePointer == edgeList.length;
    }

    private void createNewVerticeList() {
        System.out.println("Creating a new vertice list...");
        String[] newVertexList = new String[vertexList.length * 2];
        System.out.println("Copying elements...");
        System.arraycopy(vertexList, 0, newVertexList, 0, vertexList.length);
        vertexList = newVertexList;
        System.out.println("New vertice list created.");
    }

    public void createNewEdgeList() {
        System.out.println("Creating a new edge list...");
        Edge[] newEdgeList = new Edge[edgeList.length * 2];
        System.out.println("Copying elements...");
        System.arraycopy(edgeList, 0, newEdgeList, 0, edgeList.length);
        edgeList = newEdgeList;
        System.out.println("New edge list created.");
    }

    public void readVertice() {
        if(isVerticeEmpty()) {
            System.out.println("The graph is empty.");
            return;
        }

        for(int i = 0; i < vertexList.length; i++) {
            if(vertexList[i] != null) {
                System.out.println(i +" - "+ vertexList[i]);
            }
        }
    }

    public void readEdge() {
        if(isEdgeEmpty()) {
            System.out.println("The edge list is empty.");
            return;
        }

        for (Edge edgeList1 : edgeList) {
            if (edgeList1 != null) {
                System.out.println(edgeList1.startVertex + " -> " + edgeList1.endVertex + " - " + edgeList1.weight);
            }
        }
    }

    public void addVertice(String vertice) {
        if (isVerticeFull()) {
            System.out.println("The graph is full.");
            createNewVerticeList();
        }

        vertexList[vertexPointer] = vertice;
        vertexPointer++;
        System.out.println("Vertice added.");
    }

    public void addEdge(int origin, int destiny, int weight) {
        if(isEdgeFull()) {
            System.out.println("The edge list is full.");
            createNewEdgeList();
        }

        Edge newEdge = new Edge(origin, destiny, weight);

        edgeList[edgePointer] = newEdge;
        edgePointer++;
        System.out.println("Edge added.");
    }

    public void findAdjacents(int position) {
        if(isEdgeEmpty()) {
            System.out.println("The edge list is empty, there is no connections.");
            return;
        }

        boolean hasAdjacents = false;
        for(int i = 0; i < edgeList.length; i++) {
            if(edgeList[i] != null && edgeList[i].startVertex == position) {
                System.out.println(vertexList[edgeList[i].endVertex]);
                hasAdjacents = true;
            }
        }

        if(!hasAdjacents) {
            System.out.println("There is no adjacents.");
        }
    }
}
