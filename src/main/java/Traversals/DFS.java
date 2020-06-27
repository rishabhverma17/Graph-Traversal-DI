package Traversals;

import Graph.GraphAdjacencyList;
import exceptions.InvalidVerticeException;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class DFS {
    public Set<Integer> DepthFirstSearch(GraphAdjacencyList graphAdjacencyList, int root){
        Set<Integer> visitedNodes = new LinkedHashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            int vertex = stack.pop();
            if(!visitedNodes.contains(vertex)){
                visitedNodes.add(vertex);
                try {
                    for(Integer vertices : graphAdjacencyList.getEdge(vertex)){
                        stack.push(vertices);
                    }
                } catch (InvalidVerticeException e) {
                    e.printStackTrace();
                }
            }
        }

        return visitedNodes;
    }

    public Set<Integer> dfsRecursive(GraphAdjacencyList graphAdjacencyList, int root){
        Set<Integer> visitedNodes = new LinkedHashSet<>();
        dfsHelper(graphAdjacencyList,visitedNodes,root);
        return visitedNodes;
    }

    public void dfsHelper(GraphAdjacencyList graphAdjacencyList, Set<Integer> visitedNodes, int root){
        if(!visitedNodes.contains(root)){
            visitedNodes.add(root);
            try {
                for(Integer vertex : graphAdjacencyList.getEdge(root)){
                    if(!visitedNodes.contains(vertex)){
                        dfsHelper(graphAdjacencyList,visitedNodes,vertex);
                    }
                }
            } catch (InvalidVerticeException e) {
                e.printStackTrace();
            }
        }
    }
}
