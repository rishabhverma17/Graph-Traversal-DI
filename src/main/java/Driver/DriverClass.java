package Driver;

import Graph.GraphAdjacencyList;
import Traversals.BFS;
import Traversals.DFS;
import exceptions.InvalidVerticeException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DriverClass {

    @Inject @Named("BFS")
    private BFS BreadthFirstSearch;

    @Inject @Named("DFS")
    private DFS DepthFirstSearch;

    public void run(){
        GraphAdjacencyList graphAdjacencyList = new GraphAdjacencyList(6);
        try {
            graphAdjacencyList.addEdge(0, 1);
            graphAdjacencyList.addEdge(0, 2);
            graphAdjacencyList.addEdge(1, 2);
            graphAdjacencyList.addEdge(1, 3);
            graphAdjacencyList.addEdge(3, 4);
            graphAdjacencyList.addEdge(2, 3);
            graphAdjacencyList.addEdge(4, 0);
            graphAdjacencyList.addEdge(4, 1);
            graphAdjacencyList.addEdge(4, 5);
            graphAdjacencyList.printGraph();

        } catch (InvalidVerticeException e) {
            e.printStackTrace();
        }
        Map<Integer, List<Integer>> myGraph = graphAdjacencyList.getGraph();

        Set<Integer> dfsResult =  DepthFirstSearch.DepthFirstSearch(graphAdjacencyList,0);
        System.out.println("Depth First Search Over Graph (Iterative)");
        for(Integer i : dfsResult){
            System.out.print(i+" ");
        }

        Set<Integer> dfsResultRecursive =  DepthFirstSearch.dfsRecursive(graphAdjacencyList,0);
        System.out.println("\nDepth First Search Over Graph (Recursive)");
        for(Integer i : dfsResultRecursive){
            System.out.print(i+" ");
        }

        Set<Integer> bfsResult = BreadthFirstSearch.BreadthFirstSearch(graphAdjacencyList,0);
        System.out.println("\nBreadth First Search Over Graph (Iterative)");
        for(Integer i : bfsResult){
            System.out.print(i+" ");
        }

        Set<Integer> bfsResultRecursive = BreadthFirstSearch.BreadthFirstSearch(graphAdjacencyList,0);
        System.out.println("\nBreadth First Search Over Graph (Recursive)");
        for(Integer i : bfsResultRecursive){
            System.out.print(i+" ");
        }
    }
}
