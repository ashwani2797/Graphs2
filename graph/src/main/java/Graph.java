import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph<T> {
    private Map<T, List<T>> map = new HashMap<T, List<T>>();

    public void addVertex(T newVertex) {
        if (map.containsKey(newVertex)) {
            System.out.println("Vertex already exist: " + newVertex);
        }
        map.put(newVertex, new LinkedList<T>());
    }

    public void addEdge(T source, T destination, boolean bidirectional) {
        if (!map.containsKey(source))
            addVertex(source);

        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(destination);
        if (bidirectional) {
            map.get(destination).add(source);
        }
    }

    // This function gives the count of vertices
    public void getVertexCount() {
        System.out.println("The graph has "
                + map.keySet().size()
                + " vertex");
    }

    public void getEdgesCount(boolean bidirection) {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirection) {
            count = count / 2;
        }
        System.out.println("The graph has "
                + count
                + " edges.");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for (T w : map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }


}
