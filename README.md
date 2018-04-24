# Database-assignment-9

1. I have set up a Neo4j and SQL database
2. I could not import the two major csv files, so instead I have imported data from the two small csv files into the Neo4j and SQL database.

The SQL database name is 'Neo4j' (yes, mistake) and the table names is 't_user' and 't_endorsments' (another small mistake, should have been 't_endorsement').
The column names for the 't_user' is 'id', 'name', 'job' and 'birthday'.
The column names for the 't_endorsments' is 'source_node_id' and 'target_node_id'.

3. I have constructed Cypher and SQL queries - those you can see ind the Java project folder:  
For Cypher queries: 
For SQL queries:

4. Both programs executes the queries for twenty random nodes(users) against the two respective databases.
5. Both programs measures the average and median execution times of each query. 
6. I have also collected the measurement results. The results are:

For Cypher queries:

<----- Neo4j ----->  
Depth 1 runtime: 4441.0 ms  
Depth 2 runtime: 304.0 ms  
Depth 3 runtime: 285.0 ms  
Depth 4 runtime: 360.0 ms  
Depth 5 runtime: 505.0 ms  
<----- Neo4j ----->  
Depth 1 runtime: 65.0 ms  
Depth 2 runtime: 62.0 ms  
Depth 3 runtime: 69.0 ms  
Depth 4 runtime: 73.0 ms  
Depth 5 runtime: 148.0 ms  
<----- Neo4j ----->  
Depth 1 runtime: 55.0 ms  
Depth 2 runtime: 58.0 ms  
Depth 3 runtime: 60.0 ms  
Depth 4 runtime: 61.0 ms  
Depth 5 runtime: 75.0 ms  
<----- Neo4j ----->  
Depth 1 runtime: 44.0 ms  
Depth 2 runtime: 50.0 ms  
Depth 3 runtime: 52.0 ms  
Depth 4 runtime: 100.0 ms  
Depth 5 runtime: 138.0 ms  
<----- Neo4j ----->  
Depth 1 runtime: 60.0 ms  
Depth 2 runtime: 88.0 ms  
Depth 3 runtime: 51.0 ms  
Depth 4 runtime: 70.0 ms  
Depth 5 runtime: 122.0 ms  
<----- Neo4j ----->  
Depth 1 runtime: 56.0 ms  
Depth 2 runtime: 41.0 ms  
Depth 3 runtime: 58.0 ms  
Depth 4 runtime: 72.0 ms  
Depth 5 runtime: 105.0 ms  
<----- Neo4j ----->  
Depth 1 runtime: 49.0 ms  
Depth 2 runtime: 48.0 ms  
Depth 3 runtime: 53.0 ms  
Depth 4 runtime: 61.0 ms  
Depth 5 runtime: 192.0 ms  
<----- Neo4j ----->  
Depth 1 runtime: 47.0 ms  
Depth 2 runtime: 72.0 ms  
Depth 3 runtime: 68.0 ms  
Depth 4 runtime: 68.0 ms  
Depth 5 runtime: 88.0 ms  
<----- Neo4j ----->  
Depth 1 runtime: 45.0 ms  
Depth 2 runtime: 42.0 ms  
Depth 3 runtime: 50.0 ms  
Depth 4 runtime: 39.0 ms  
Depth 5 runtime: 62.0 ms  
<----- Neo4j ----->  
Depth 1 runtime: 45.0 ms  
Depth 2 runtime: 51.0 ms  
Depth 3 runtime: 57.0 ms  
Depth 4 runtime: 47.0 ms  
Depth 5 runtime: 87.0 ms  
<----- Neo4j ----->  
Depth 1 runtime: 49.0 ms  
Depth 2 runtime: 52.0 ms  
Depth 3 runtime: 50.0 ms  
Depth 4 runtime: 67.0 ms  
Depth 5 runtime: 60.0 ms  
<----- Neo4j ----->  
Depth 1 runtime: 48.0 ms  
Depth 2 runtime: 54.0 ms  
Depth 3 runtime: 57.0 ms  
Depth 4 runtime: 55.0 ms  
Depth 5 runtime: 120.0 ms  
<----- Neo4j ----->  
Depth 1 runtime: 46.0 ms  
Depth 2 runtime: 56.0 ms  
Depth 3 runtime: 45.0 ms  
Depth 4 runtime: 58.0 ms  
Depth 5 runtime: 59.0 ms  
<----- Neo4j ----->  
Depth 1 runtime: 51.0 ms  
Depth 2 runtime: 46.0 ms  
Depth 3 runtime: 41.0 ms  
Depth 4 runtime: 50.0 ms  
Depth 5 runtime: 73.0 ms  
<----- Neo4j ----->  
Depth 1 runtime: 34.0 ms  
Depth 2 runtime: 46.0 ms  
Depth 3 runtime: 46.0 ms  
Depth 4 runtime: 72.0 ms  
Depth 5 runtime: 78.0 ms  
<----- Neo4j ----->  
Depth 1 runtime: 48.0 ms  
Depth 2 runtime: 54.0 ms  
Depth 3 runtime: 56.0 ms  
Depth 4 runtime: 70.0 ms  
Depth 5 runtime: 82.0 ms  
<----- Neo4j ----->  
Depth 1 runtime: 48.0 ms  
Depth 2 runtime: 46.0 ms  
Depth 3 runtime: 91.0 ms  
Depth 4 runtime: 41.0 ms  
Depth 5 runtime: 47.0 ms  
<----- Neo4j ----->  
Depth 1 runtime: 46.0 ms  
Depth 2 runtime: 45.0 ms  
Depth 3 runtime: 56.0 ms  
Depth 4 runtime: 69.0 ms  
Depth 5 runtime: 40.0 ms  
<----- Neo4j ----->  
Depth 1 runtime: 44.0 ms  
Depth 2 runtime: 46.0 ms  
Depth 3 runtime: 47.0 ms  
Depth 4 runtime: 69.0 ms  
Depth 5 runtime: 106.0 ms  
<----- Neo4j ----->  
Depth 1 runtime: 34.0 ms  
Depth 2 runtime: 36.0 ms  
Depth 3 runtime: 49.0 ms  
Depth 4 runtime: 54.0 ms  
Depth 5 runtime: 63.0 ms  

<----- Average ----->
Average time depth 1: 267.75 ms
<----- Median ----->
Median time depth 1: 72.0 ms 

<----- Average ----->
Average time depth 2: 64.85 ms
<----- Median ----->
Median time depth 2: 76.0 ms 

<----- Average ----->
Average time depth 3: 67.05 ms
<----- Median ----->
Median time depth 3: 81.0 ms 

<----- Average ----->
Average time depth 4: 77.8 ms
<----- Median ----->
Median time depth 4: 101.5 ms 

<----- Average ----->
Average time depth 5: 112.5 ms
<----- Median ----->
Median time depth 5: 126.0 ms 

For SQL queries:

<----- MySQL ----->
Depth 1 runtime: ms 3489.0
Depth 2 runtime: ms 128.0
Depth 3 runtime: ms 887.0
Depth 4 runtime: ms 9792.0

And then..... nothing.. It's takes too much time...
And to answer the two questions "Give an explanation of the differences in your time measurements" and
"Conclude which database is better suited for this kind of queries and explain why":

- Cypher is just so much faster when it comes to depths and node relationships.



