/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cypher;

import Calculater.Calculator;
import java.util.ArrayList;
import java.util.List;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;

/**
 *
 * @author louis
 */
public class ConnectionTest {

    private static List<String> cypherQueries;
    private static List<Double> runtimeDepth1;
    private static List<Double> runtimeDepth2;
    private static List<Double> runtimeDepth3;
    private static List<Double> runtimeDepth4;
    private static List<Double> runtimeDepth5;

    public static void main(String[] args) {
        neo4jQueries();
        runNeo4jQueries();
        neo4jRuntimes();
    }

    public static void runNeo4jQueries() {
        runtimeDepth1 = new ArrayList<>();
        runtimeDepth2 = new ArrayList<>();
        runtimeDepth3 = new ArrayList<>();
        runtimeDepth4 = new ArrayList<>();
        runtimeDepth5 = new ArrayList<>();

        final int randomUser = 20;

        for (int i = 0; i < randomUser; i++) {
            System.out.println("<----- Neo4j ----->");

            for (int j = 0; j < cypherQueries.size(); j++) {
                String query = cypherQueries.get(j).replace("UserId", String.valueOf((int) (Math.random() * 100))); //bør være antal af max userId i DB

                double startTime = System.currentTimeMillis();
                neo4jConnection(query);
                double endTime = System.currentTimeMillis();

                switch (j) {
                    case 0:
                        runtimeDepth1.add((endTime - startTime));
                        break;
                    case 1:
                        runtimeDepth2.add((endTime - startTime));
                        break;
                    case 2:
                        runtimeDepth3.add((endTime - startTime));
                        break;
                    case 3:
                        runtimeDepth4.add((endTime - startTime));
                        break;
                    case 4:
                        runtimeDepth5.add((endTime - startTime));
                        break;
                    case 5:
                }

                System.out.println("Depth " + (j + 1) + " runtime: " + (endTime - startTime) + " ms");
            }
        }
    }

    public static void neo4jQueries() {
        cypherQueries = new ArrayList<>();

        cypherQueries.add("MATCH (p:Person)-[:ENDORSES]->(p2:Person) \n"
                + "WHERE p.id = UserId \n"
                + "RETURN p.name, p2.name");

        cypherQueries.add("MATCH (p:Person)-[:ENDORSES]->(p2:Person)-[:ENDORSES]->(p3:Person) \n"
                + "WHERE p.id = UserId \n"
                + "RETURN p.name, p2.name, p3.name");

        cypherQueries.add("MATCH(p:Person)-[:ENDORSES]->(p2:Person)-[:ENDORSES]->(p3:Person)-[:ENDORSES]->(p4:Person) \n"
                + "WHERE p.id = UserId \n"
                + "RETURN p.name, p2.name, p3.name, p4.name");

        cypherQueries.add("MATCH(p:Person)-[:ENDORSES]->(p2:Person)-[:ENDORSES]->(p3:Person)-[:ENDORSES]->(p4:Person)-[:ENDORSES]->(p5:Person) \n"
                + "WHERE p.id = UserId \n"
                + "RETURN p.name, p2.name, p3.name, p4.name, p5.name");

        cypherQueries.add("MATCH(p:Person)-[:ENDORSES]->(p2:Person)-[:ENDORSES]->(p3:Person)-[:ENDORSES]->(p4:Person)-[:ENDORSES]->(p5:Person)-[:ENDORSES]->(p6:Person) \n"
                + "WHERE p.id = UserId \n"
                + "RETURN p.name, p2.name, p3.name, p4.name, p5.name, p6.name");

    }

    public static void neo4jRuntimes() {
        double average1 = Calculator.average(runtimeDepth1);
        double median1 = Calculator.median(runtimeDepth1);
        System.out.println("<----- Average ----->");
        System.out.println("Average time depth 1: " + average1 + " ms");
        System.out.println("<----- Median ----->");
        System.out.println("Median time depth 1: " + median1 + " ms \n");

        double average2 = Calculator.average(runtimeDepth2);
        double median2 = Calculator.median(runtimeDepth2);
        System.out.println("<----- Average ----->");
        System.out.println("Average time depth 2: " + average2 + " ms");
        System.out.println("<----- Median ----->");
        System.out.println("Median time depth 2: " + median2 + " ms \n");

        double average3 = Calculator.average(runtimeDepth3);
        double median3 = Calculator.median(runtimeDepth3);
        System.out.println("<----- Average ----->");
        System.out.println("Average time depth 3: " + average3 + " ms");
        System.out.println("<----- Median ----->");
        System.out.println("Median time depth 3: " + median3 + " ms \n");

        double average4 = Calculator.average(runtimeDepth4);
        double median4 = Calculator.median(runtimeDepth4);
        System.out.println("<----- Average ----->");
        System.out.println("Average time depth 4: " + average4 + " ms");
        System.out.println("<----- Median ----->");
        System.out.println("Median time depth 4: " + median4 + " ms \n");

        double average5 = Calculator.average(runtimeDepth5);
        double median5 = Calculator.median(runtimeDepth5);
        System.out.println("<----- Average ----->");
        System.out.println("Average time depth 5: " + average5 + " ms");
        System.out.println("<----- Median ----->");
        System.out.println("Median time depth 5: " + median5 + " ms \n");
    }

    public static void neo4jConnection(String query) {

        Driver driver = GraphDatabase.driver(
                "bolt://localhost:7687",
                AuthTokens.basic("neo4j", "class"));
        Session session = driver.session();

        session.run(query);

        session.close();
        driver.close();
    }

}
