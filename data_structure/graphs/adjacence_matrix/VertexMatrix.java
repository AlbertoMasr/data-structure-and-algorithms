package data_structure.graphs.adjacence_matrix;

public class VertexMatrix {
    private String[] vertexList;
    private int vertexPointer  = 0;
    private int[][] edgeMatrix;

    public VertexMatrix(int verticeAmount) {
        this.vertexList = new String[verticeAmount];
        this.edgeMatrix = new int[verticeAmount][verticeAmount];
    }

    public boolean isOutOfBounds(int position) {
        return position < 0 || position >= vertexList.length;
    }

    public boolean isVerticeEmpty() {
        return vertexPointer == 0;
    }

    public boolean isVerticeFull() {
        return vertexPointer == vertexList.length;
    }

    private void createNewVerticeList() {
        System.out.println("Creating a new vertice list...");
        String[] newVertexList = new String[vertexList.length * 2];
        System.out.println("Copying elements...");
        System.arraycopy(vertexList, 0, newVertexList, 0, vertexList.length);
        vertexList = newVertexList;
        System.out.println("New vertice list created.");
    }

    public void readVertice() {
        if(isVerticeEmpty()) {
            System.err.println("\nThere are no vertices.");
            return;
        }

        System.out.println("Vertices:");
        for (int i = 0; i < vertexList.length; i++) {
            if(vertexList[i] == null) {
                continue;
            }

            System.out.println(i + " - " + vertexList[i]);
        }
    }

    public void readEdge() {
        if(isVerticeEmpty()) {
            System.err.println("\nThere are no vertices.");
            return;
        }

        System.out.println("Edges:");
        for (int i = 0; i < edgeMatrix.length; i++) {
            if(edgeMatrix[i] == null) {
                continue;
            }
            System.out.print(i);
            for (int j = 0; j < edgeMatrix[i].length; j++) {
                if(j == 0) {
                    System.out.print(" [");
                }
                
                System.out.print(vertexList[j] + " = " + edgeMatrix[i][j]);

                if(j != edgeMatrix[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public void addVertice(String vertice) {
        if(isVerticeFull()) {
            System.err.println("\nThere are no more space for vertices.");
            createNewVerticeList();
        }

        vertexList[vertexPointer++] = vertice;
        System.out.println("\nVertice added.");
    }

    public void addEdge(int verticePosition1, int verticePosition2, int weight) {
        edgeMatrix[verticePosition1][verticePosition2] = weight;
        System.out.println("\nEdge added.");
    }

    public void findAdjacents(int position) {

        boolean hasAdjacents = false;
        for(int i = 0; i < edgeMatrix[position].length; i++) {
            if(edgeMatrix[position][i] != 0) {
                System.out.println(i +" : "+ vertexList[position] + " -> " + vertexList[i] + " = " + edgeMatrix[position][i]);
                hasAdjacents = true;
            }
        }

        if(!hasAdjacents) {
            System.out.println("There are no adjacents.");
        }
    }
}