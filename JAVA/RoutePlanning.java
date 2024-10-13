import java.util.*;

public class RoutePlanning {

    private static final int MAX_DISTANCE = 1000; // taken a rough distance 1000

    public static void findOptimalRoute(int currentLocation, List<Integer> remainingPackages, int totalDistance, List<Integer> route) {
        if (remainingPackages.isEmpty()) {
            // all packages delivered, print the optimal route
            System.out.println("Optimal route: " + route);
            System.out.println("Total distance: " + totalDistance);
            return;
        }

        // iterating through remaining packages and explore different possible routes
        for (int i = 0; i < remainingPackages.size(); i++) {
            int nextLocation = remainingPackages.get(i);
            int distance = calculateDistance(currentLocation, nextLocation);

            // Check if the route is feasible within the maximum distance limit
            if (totalDistance + distance <= MAX_DISTANCE) {
                
                remainingPackages.remove(i);  //removes the next location from the remaining packages list.
                route.add(nextLocation);
                findOptimalRoute(nextLocation, remainingPackages, totalDistance + distance, route);
                route.remove(route.size() - 1);
                remainingPackages.add(i, nextLocation);
            }
        }
    }

    private static int calculateDistance(int location1, int location2) {
        //calculates the distance between two locations
        return 0; 
    }

    public static void main(String[] args) {
       
        List<Integer> locations = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> remainingPackages = new ArrayList<>(locations);

        findOptimalRoute(0, remainingPackages, 0, new ArrayList<>());
    }
}