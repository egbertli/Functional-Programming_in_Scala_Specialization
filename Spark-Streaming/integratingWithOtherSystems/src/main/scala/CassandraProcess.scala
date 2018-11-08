import com.datastax.spark.connector._
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import com.datastax.spark.connector._
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object CassandraProcess {
  def main(args: Array[String]) {
    val conf = new SparkConf(true).set("spark.cassandra.connection.host", "localhost")
    conf.setMaster("local[*]")
    conf.setAppName("CassandraProcess")
    val sc = new SparkContext(conf)

    val test_spark_rdd = sc.cassandraTable("visitedlog", "logtest").map {row => row.columnValues.mkString("\t")}
    //println(test_spark_rdd.first())
    for (rdd <- test_spark_rdd) {
      println("\n" + rdd.toString() + "\n")
    }
    println()
    println(test_spark_rdd.count())
    println()
    println(test_spark_rdd.first())
    println()
    //println(test_spark_rdd.map(_.getInt("status")).sum())

    // write into table
    val collection = sc.parallelize(Seq(("12.13.144.78", 300), ("17.188.13.45", 200), ("18.133.67.999", 400)))
    collection.saveToCassandra("visitedlog", "logtest", SomeColumns("ip", "status"))
  }
}
