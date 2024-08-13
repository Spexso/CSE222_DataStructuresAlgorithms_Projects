import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SocialNetworkGraph {
    
    Map<String, Person> people = new HashMap<>();
    Map<Person, List<Person>> friendships = new HashMap<>();

    // Method to add a person
    public void addPerson(String name, int age, List<String> hobbies) {

        // Create the new person
        if(people.containsKey(name)){
            System.out.println("User is already present in the network, try again");
            return;
        }

        Person person = new Person(name, age, hobbies);
        
        // Add to Maps
        people.put(name, person);
        friendships.put(person, new ArrayList<>());
        
        System.out.println("Person added: " + person);
    }

    // Method to remove a person
    public void removePerson(String name) {
        
        // Delete person from person Map
        Person person = people.remove(name);

        if (person != null) {
            
            friendships.remove(person);
            
            for (List<Person> friends : friendships.values()) {

                friends.remove(person);
            }
            System.out.println("Person removed: " + person);
        } 
        else {
            System.out.println("Person not found in the network.");
        }

    }

    // Method to add a friendship
    public void addFriendship(String name1, String name2) {
        
        // Store person ref
        Person person1 = people.get(name1);
        Person person2 = people.get(name2);

        if(friendships.get(person1).contains(person2)){
            
            System.out.println("Users already has a friendship");
            return;
        }
        
        if (person1 != null && person2 != null) {
            
            friendships.get(person1).add(person2);
            friendships.get(person2).add(person1);
            System.out.println("Friendship added between " + person1.name + " and " + person2.name);
        } 
        else {
            System.out.println("One or both persons not found in the network.");
        }
    }

    public void removeFriendship(String username, String friendname){

        if(!people.containsKey(username)){
            System.out.println("User is not present in network");
            return;
        }

        Person user = people.get(username);
        Person friend = people.get(friendname);

        // If user and friend is present in Map remove them from both of their friends list
        if(friend != null){
    
            friendships.get(user).remove(friend);
            friendships.get(friend).remove(user);

            System.out.println("Friendship bond between " + user.getName() + " and " + friend.getName() + " is broken now");
        }
        else {

            System.out.println("Friend of user is not present in the network");
        }

        return;
    }

    // Method to find the shortest path using BFS
    public void findShortestPath(String startName, String endName) {
        
        // Get Person references
        Person start = people.get(startName);
        Person end = people.get(endName);

        if (start == null || end == null) {
            System.out.println("One or both persons not found in the network.");
            return;
        }

        Queue<Person> queue = new LinkedList<>();
        Map<Person, Person> prev = new HashMap<>();
        Set<Person> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Person current = queue.poll();

            if (current.equals(end)) {
                printPath(start, end, prev);
                return;
            }

            for (Person neighbor : friendships.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    prev.put(neighbor, current);
                }
            }
        }

        System.out.println("No path found between " + startName + " and " + endName);
    }

    private void printPath(Person start, Person end, Map<Person, Person> prev) {

        List<Person> path = new ArrayList<>();
        
        for (Person at = end; at != null; at = prev.get(at)) {
            
            path.add(at);
        }
        
        Collections.reverse(path);
        System.out.println("Shortest path: " + path);
    }

    // Method to count clusters using BFS
    public void countClusters() {
        
        Set<Person> visited = new HashSet<>();
        int clusterCount = 0;

        for(Person PNode : friendships.keySet()){

            if(!visited.contains(PNode)){
                
                List<Person> cluster = new ArrayList<>();
                clusterCount++;

                bfs(PNode, visited, cluster);
                
                // Print Cluster population
                System.out.println("Custer: " + clusterCount + ": "); 
                System.out.println(cluster);
            }
        }
    }

    private void bfs(Person start, Set<Person> visited, List<Person> cluster) {

        Queue<Person> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Person current = queue.poll();
            cluster.add(current);

            for (Person neighbor : friendships.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    // VISUALIZE BFS WITH GIVEN INPUT 
}
