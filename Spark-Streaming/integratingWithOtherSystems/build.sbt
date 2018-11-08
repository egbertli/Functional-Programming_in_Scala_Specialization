name := "integratingWithOtherSystems"

version := "0.1"

scalaVersion := "2.11.12"

// https://mvnrepository.com/artifact/com.datastax.spark/spark-cassandra-connector
libraryDependencies += "com.datastax.spark" %% "spark-cassandra-connector" % "2.3.2"

// https://mvnrepository.com/artifact/com.datastax.spark/spark-cassandra-connector-embedded
libraryDependencies += "com.datastax.spark" %% "spark-cassandra-connector-embedded" % "2.3.2" % Test

// https://mvnrepository.com/artifact/com.twitter/jsr166e
libraryDependencies += "com.twitter" % "jsr166e" % "1.1.0"
