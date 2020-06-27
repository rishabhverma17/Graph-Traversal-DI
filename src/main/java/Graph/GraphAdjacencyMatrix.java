package Graph;

import exceptions.InvalidVerticeException;

public class GraphAdjacencyMatrix {
    private int limit;
    private int matrix[][];

    public GraphAdjacencyMatrix(int rowCols) {
        this.limit = rowCols;
        this.matrix = new int[rowCols][rowCols];
    }

    public void addEdge(int source, int destination) throws InvalidVerticeException {
        if(source < 0 || destination < 0 || source > limit || destination > limit){
            throw new InvalidVerticeException("Vertex given is not valid");
        }
        matrix[source][destination] = 1;
        matrix[destination][source] = 1;
    }

    public int[][] getAdjacencyMatrix(){
        return matrix;
    }

    public void printMatrix(){
        System.out.println("\nPrinting Adjacency Matrix ");
        for(int i=0; i<limit; i++){
            for(int j=0; j<limit; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("\nPrinting Connections");
        for(int i=0; i<limit; i++){
            System.out.print("Vertex :: "+i+" is connected to vertex :: {");
            for(int j=0; j<limit; j++){
                if(matrix[i][j] == 1){
                    System.out.print(j+" ");
                }
            }
            System.out.print("}");
            System.out.println();
        }
    }
}
