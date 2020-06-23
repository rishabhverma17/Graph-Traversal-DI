package Traversals;

import Graph.GraphAdjacencyList;
import exceptions.InvalidVerticeException;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class DFS {
    public Set<Integer> DepthFirstSearch(GraphAdjacencyList graphAdjacencyList, int root){
        Set<Integer> visitedNodes = new LinkedHashSet<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
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
}
