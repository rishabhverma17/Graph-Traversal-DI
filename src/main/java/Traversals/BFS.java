package Traversals;

import Graph.GraphAdjacencyList;
import exceptions.InvalidVerticeException;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {
    public Set<Integer> BreadthFirstSearch(GraphAdjacencyList graphAdjacencyList, int root){
        Set<Integer> visitedNodes = new LinkedHashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            if(!visitedNodes.contains(vertex)){
                visitedNodes.add(vertex);
                try {
                    for(Integer item : graphAdjacencyList.getEdge(vertex)){
                        queue.offer(item);
                    }
                } catch (InvalidVerticeException e) {
                    e.printStackTrace();
                }
            }
        }
        return visitedNodes;
    }
}
