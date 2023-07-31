package com.grouper.csv

import java.io.FileReader
import org.apache.commons.csv.{CSVFormat, CSVParser, CSVRecord}
import scala.jdk.CollectionConverters._
import collection.convert.ImplicitConversions._

object CSVParser {
  def records(inputPath: String): Unit = {
    val reader = new FileReader(inputPath)
    val csvFormat =
      CSVFormat.DEFAULT
        .withHeader() // Assumes the first row is the header with column names

    val parser = new CSVParser(reader, csvFormat)

    try {
      val records = parser.getRecords

      for (record <- records) {
        // Access data using column names from the header
        val studentName = record.get("Student")
        val studentAvg = record.get("Current Score")
        // and so on...

        // Process the data as per your requirements
        println(s"Student Name: $studentName\nStudent GPA: $studentAvg\n")
      }

    } finally {

      parser.close()

      reader.close()
    }
  }
}
