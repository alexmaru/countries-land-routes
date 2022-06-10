package com.alexmaru.countrieslandroutes.utils;

import java.util.*;

public class GraphUtil {

    private final Map<String, List<String>> adjacencyList;

    public GraphUtil(Map<String, List<String>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public List<String> computePath(String origin, String destination) {
        List<String> path = new ArrayList<>();
        boolean pathFound = false;

        if (origin == null || destination == null) {
            return new ArrayList<>();
        }

        if (origin.equals(destination)) {
            return Collections.singletonList(origin);
        }

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> previous = new HashMap<>();

        visited.add(origin);
        queue.add(origin);

        while (!queue.isEmpty()) {

            String currentNode = queue.poll();
            List<String> adjacentNodes = adjacencyList.get(currentNode);
            if (adjacentNodes != null) {
                for (String adjacentNode : adjacentNodes) {
                    if (adjacentNode != null && !visited.contains(adjacentNode)) {
                        visited.add(adjacentNode);
                        queue.add(adjacentNode);
                        previous.put(adjacentNode, currentNode);

                        if (adjacentNode.equals(destination)) {
                            pathFound =true;
                            break;
                        }
                    }
                }
            }
        }

        if (!pathFound) {
            return new ArrayList<>();
        }

        for (String node = destination; node != null; node = previous.get(node)) {
            path.add(node);
        }

        Collections.reverse(path);

        return path;
    }


}
