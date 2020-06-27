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

    private void dfsHelper(GraphAdjacencyList graphAdjacencyList, Set<Integer> visitedNodes, int root){
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

    public void DFSInMatrix(int[][] grid) {

        int h = grid.length;
        if (h == 0)
            return;
        int l = grid[0].length;

        boolean[][] visited = new boolean[h][l];

        Stack<String> stack = new Stack<>();

        stack.push(0 + "," + 0);

        System.out.println("Depth-First Traversal: ");
        while (stack.empty() == false) {

            String x = stack.pop();
            int row = Integer.parseInt(x.split(",")[0]);
            int col = Integer.parseInt(x.split(",")[1]);

            if(row<0 || col<0 || row>=h || col>=l || visited[row][col])
                continue;

            visited[row][col]=true;
            System.out.print(grid[row][col] + " ");
            stack.push(row + "," + (col-1)); //go left
            stack.push(row + "," + (col+1)); //go right
            stack.push((row-1) + "," + col); //go up
            stack.push((row+1) + "," + col); //go down
        }
    }
}
