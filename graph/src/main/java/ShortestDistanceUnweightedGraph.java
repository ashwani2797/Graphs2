import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceUnweightedGraph {

    public static void main(String... args) {

        Graph<String> graph = new Graph<String>();
        graph.addEdge("A", "B", false);
        graph.addEdge("A", "D", false);
        graph.addEdge("C", "A", false);
        graph.addEdge("C", "F", false);
        graph.addEdge("B", "E", false);
        graph.addEdge("B", "D", false);
        graph.addEdge("D", "F", false);
        graph.addEdge("D", "G", false);
        graph.addEdge("E", "G", false);
        graph.addEdge("G", "F", false);
        System.out.println(graph);

        ArrayList<String> vertexes = new ArrayList<String>();
        vertexes.add("A");
        vertexes.add("B");
        vertexes.add("C");
        vertexes.add("D");
        vertexes.add("E");
        vertexes.add("F");
        vertexes.add("G");
        final ArrayList<Integer> distance = new ArrayList<Integer>();
        final ArrayList<String> path = new ArrayList<String>();
        vertexes.forEach(vertex -> {
            distance.add(-1);
            path.add("");
        });
        getShortestPathToAllVertices(graph, distance, vertexes, path);

        vertexes.forEach(vertex -> {
            System.out.println(vertex + " " + distance.get(vertexes.indexOf(vertex)) + " " + path.get(vertexes.indexOf(vertex)));
        });

    }

    public static void getShortestPathToAllVertices(Graph<String> graph, ArrayList<Integer> distance, ArrayList<String> vertexes, ArrayList<String> path) {
        Queue<String> queue = new LinkedList<>();
        queue.add("C"); //begin vertex
        distance.set(vertexes.indexOf("C"),0);


        while (!queue.isEmpty()){
            String vertex = queue.remove();


            LinkedList<String> adjacentVertices = (LinkedList<String>) graph.getAdjacentVertices(vertex);
            Iterator<String> iterator = adjacentVertices.iterator();
            while(iterator.hasNext()){
                String adjacentVertex = iterator.next();
                int adjacentVertexIndex = vertexes.indexOf(adjacentVertex);
                if(distance.get(adjacentVertexIndex) == -1){
                    distance.set(adjacentVertexIndex,distance.get(vertexes.indexOf(vertex)) + 1);
                    path.set(adjacentVertexIndex, vertex);
                    queue.add(adjacentVertex);
                }
            }
        }
    }
}
