import com.grouper.cli.Builder
import com.grouper.csv.CSVParser

object Grouper {
  def main(args: Array[String]): Unit = {
    val user_input = Builder.init(args)

    if (user_input.length < 2) {
      println("No inputs provided!")
      sys.exit(1)
    }

    for (in <- user_input) {
      if (in.endsWith(".csv")) {
        CSVParser.records(in)
      }
    }
  }
}
