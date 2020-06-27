package Traversals;

import Graph.GraphAdjacencyList;
import exceptions.InvalidVerticeException;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {
    public Set<Integer> BreadthFirstSearch(GraphAdjacencyList graphAdjacencyList, int root){
        Set<Integer> visitedNodes = new LinkedHashSet<>();
        Queue<Integer> queue = new LinkedList<>();
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

    public void BFSInMatrix(int[][] grid) {

        int h = grid.length;
        if (h == 0)
            return;
        int l = grid[0].length;

        boolean[][] visited = new boolean[h][l];

        Queue<String> queue = new LinkedList<>();

        queue.offer(0 + "," + 0);

        System.out.println("Breadth-First Traversal: ");
        while (queue.isEmpty() == false) {

            String x = queue.poll();
            int row = Integer.parseInt(x.split(",")[0]);
            int col = Integer.parseInt(x.split(",")[1]);

            if (row < 0 || col < 0 || row >= h || col >= l || visited[row][col])
                continue;

            visited[row][col] = true;
            System.out.print(grid[row][col] + " ");
            queue.add(row + "," + (col - 1)); //go left
            queue.add(row + "," + (col + 1)); //go right
            queue.add((row - 1) + "," + col); //go up
            queue.add((row + 1) + "," + col); //go down
        }
    }

}
