import org.apache.spark._
object wordCount {
  def main(args: Array[String]): Unit = {
    // Set up a SparkContext named WordCount that runs locally using all available cores
    val conf = new SparkConf().setAppName("WordCount")
    conf.setMaster("local[*]")
    val sc = new SparkContext(conf)

    // Create a RDD of lines of text in our book
    val input = sc.textFile("/Users/yixuan-li/Documents/github/Functional-Programming_in_Scala_Specialization/Spark-Streaming/SparkStreamingConcepts/book.txt")
    // Use flatMap to convert this into an rdd of each word in each line
    val words = input.flatMap(line => line.split(' '))
    // Convert these words to lowercase
    val lowerCaseWords = words.map(word => word.toLowerCase())
    // Count up the occurence of each unique word
    val wordCounts = lowerCaseWords.countByValue()

    // Print the first 20 results
    val sample = wordCounts.take(20)
    for ((word, count) <- sample) {
      println(word + " " + count)
    }
  }
}
