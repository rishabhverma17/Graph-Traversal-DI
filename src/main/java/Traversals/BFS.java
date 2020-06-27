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

    public Set<Integer> recursiveBFS(GraphAdjacencyList graphAdjacencyList, int root){
        Set<Integer> visitedNodes = new LinkedHashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        bfsHelper(graphAdjacencyList,visitedNodes,q);
        return visitedNodes;
    }

    private void bfsHelper(GraphAdjacencyList graphAdjacencyList, Set<Integer> visitedNodes, Queue<Integer> q){
        if(q.isEmpty()){
            return;
        }
        int polledVertex = q.poll();
        if(!visitedNodes.contains(polledVertex)){
            visitedNodes.add(polledVertex);
            try {
                for(Integer vertex : graphAdjacencyList.getEdge(polledVertex)){
                    if(!visitedNodes.contains(vertex) && !q.contains(vertex)){
                        q.offer(vertex);
                    }
                }
            } catch (InvalidVerticeException e) {
                e.printStackTrace();
            }

            bfsHelper(graphAdjacencyList,visitedNodes,q);
        }
    }

}
