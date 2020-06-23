package Graph;

import exceptions.InvalidVerticeException;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphAdjacencyList {
    private Map<Integer, List<Integer>> adjacencyList;

    /** Constructor */
    @Inject
    public GraphAdjacencyList(int numberOfVertices){
        adjacencyList = new HashMap<Integer, List<Integer>>();
        for(int i=0; i<numberOfVertices; i++){
            adjacencyList.put(i,new LinkedList<Integer>());
        }
    }

    /** Add Edge */
    public void addEdge(int source, int destination) throws InvalidVerticeException {
        /** Validation */
        if(adjacencyList.size() < source || adjacencyList.size() < destination){
            throw new InvalidVerticeException("Vertex value is not correct");
        }
        List<Integer> src = adjacencyList.get(source);
        src.add(destination);
        List<Integer> dest = adjacencyList.get(destination);
        dest.add(source);
    }

    /** Get Edge */
    public List<Integer> getEdge(int source) throws InvalidVerticeException {
        if(adjacencyList.size() < source){
            throw new InvalidVerticeException("Vertex value is not correct");
        }
        return adjacencyList.get(source);
    }

    /** Get Graph */
    public Map<Integer, List<Integer>> getGraph(){
        return adjacencyList;
    }

    /** Print Graph */
    public void printGraph(){
        for(int i=0; i<adjacencyList.size(); i++){
            if(adjacencyList.get(i).size() > 0){
                System.out.print("Vertex :: "+i+" is connected to vertex :: {");
                for(Integer vertices : adjacencyList.get(i)){
                    System.out.print(vertices+",");
                }
                System.out.println("}");
            }
        }
    }
}
