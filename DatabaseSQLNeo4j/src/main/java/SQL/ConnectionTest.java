/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Calculater.Calculator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author louis
 */
public class ConnectionTest {

    private static List<String> sqlQueries;
    private static List<Double> runtimeDepth1;
    private static List<Double> runtimeDepth2;
    private static List<Double> runtimeDepth3;
    private static List<Double> runtimeDepth4;
    private static List<Double> runtimeDepth5;

    public static void main(String[] args) {
        sqlQueries();
        runSqlQueries();
        sqlRuntimes();
    }

    public static void runSqlQueries() {
        runtimeDepth1 = new ArrayList<>();
        runtimeDepth2 = new ArrayList<>();
        runtimeDepth3 = new ArrayList<>();
        runtimeDepth4 = new ArrayList<>();
        runtimeDepth5 = new ArrayList<>();

        final int randomUser = 20;

        for (int i = 0; i < randomUser; i++) {
            System.out.println("<----- MySQL ----->");

            for (int j = 0; j < sqlQueries.size(); j++) {
                String query = sqlQueries.get(j).replace("UserId", String.valueOf(0));

                double startTime = System.currentTimeMillis();
                mySQLConnection(query);
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

                System.out.println("Depth " + (j + 1) + " runtime: ms " + (endTime - startTime));
            }
        }
    }

    public static void sqlQueries() {
        sqlQueries = new ArrayList<>();

        sqlQueries.add("SELECT t_user.name, t_user2.name FROM t_user, t_user as t_user2, t_endorsments \n"
                + "WHERE t_user.id = UserId \n"
                + "AND t_user.id = t_endorsments.source_node_id \n"
                + "AND t_user2.id = t_endorsments.target_node_id");

        sqlQueries.add("SELECT t_user.name, t_user2.name, t_user3.name \n"
                + "FROM t_user, t_user as t_user2, t_user as t_user3, t_endorsments, t_endorsments as t_endorsments2 \n"
                + "WHERE t_user.id = UserId \n"
                + "AND t_user.id = t_endorsments.source_node_id \n"
                + "AND t_user2.id = t_endorsments.target_node_id \n"
                + "AND t_user2.id = t_endorsments2.source_node_id \n"
                + "AND t_user3.id = t_endorsments2.target_node_id");

        sqlQueries.add("SELECT t_user.name, t_user2.name, t_user3.name, t_user4.name \n"
                + "FROM t_user, t_user as t_user2, t_user as t_user3, t_user as t_user4, t_endorsments, t_endorsments as t_endorsments2, t_endorsments as t_endorsments3 \n"
                + "WHERE t_user.id = UserId \n"
                + "AND t_user.id = t_endorsments.source_node_id \n"
                + "AND t_user2.id = t_endorsments.target_node_id \n"
                + "AND t_user2.id = t_endorsments2.source_node_id \n"
                + "AND t_user3.id = t_endorsments2.target_node_id \n"
                + "AND t_user3.id = t_endorsments3.source_node_id \n"
                + "AND t_user4.id = t_endorsments3.target_node_id");

        sqlQueries.add("SELECT t_user.name, t_user2.name, t_user3.name, t_user4.name, t_user5.name \n"
                + "FROM t_user, t_user as t_user2, t_user as t_user3, t_user as t_user4, t_user as t_user5, t_endorsments, t_endorsments as t_endorsments2, t_endorsments as t_endorsments3, t_endorsments as t_endorsments4\n"
                + "WHERE t_user.id = UserId \n"
                + "AND t_user.id = t_endorsments.source_node_id \n"
                + "AND t_user2.id = t_endorsments.target_node_id \n"
                + "AND t_user2.id = t_endorsments2.source_node_id \n"
                + "AND t_user3.id = t_endorsments2.target_node_id \n"
                + "AND t_user3.id = t_endorsments3.source_node_id \n"
                + "AND t_user4.id = t_endorsments3.target_node_id \n"
                + "AND t_user4.id = t_endorsments4.source_node_id \n"
                + "AND t_user5.id = t_endorsments4.target_node_id");

        sqlQueries.add("SELECT t_user.name, t_user2.name, t_user3.name, t_user4.name, t_user5.name, t_user6.name \n"
                + "FROM t_user, t_user as t_user2, t_user as t_user3, t_user as t_user4, t_user as t_user5, t_user as t_user6, t_endorsments, t_endorsments as t_endorsments2, t_endorsments as t_endorsments3, t_endorsments as t_endorsments4, t_endorsments as t_endorsments5\n"
                + "WHERE t_user.id = UserId \n"
                + "AND t_user.id = t_endorsments.source_node_id \n"
                + "AND t_user2.id = t_endorsments.target_node_id \n"
                + "AND t_user2.id = t_endorsments2.source_node_id \n"
                + "AND t_user3.id = t_endorsments2.target_node_id \n"
                + "AND t_user3.id = t_endorsments3.source_node_id \n"
                + "AND t_user4.id = t_endorsments3.target_node_id \n"
                + "AND t_user4.id = t_endorsments4.source_node_id \n"
                + "AND t_user5.id = t_endorsments4.target_node_id \n"
                + "AND t_user5.id = t_endorsments5.source_node_id \n"
                + "AND t_user6.id = t_endorsments5.target_node_id");

    }

    public static void sqlRuntimes() {
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

    public static void mySQLConnection(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String url = "jdbc:mysql://localhost:3306/neo4j";
        String user = "root";
        String password = "1234";

        try {

            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.err.println(ex);
            }
        }
    }
}
