package com.grouper.cli

import java.io.File
import scala.collection.immutable.ArraySeq

object Builder {
  import scopt.OParser

  def init(args: Seq[String]): Seq[String] = {

    val builder = OParser.builder[Config]

    val parser1 = {
      import builder._
      OParser.sequence(
        programName("grouper"),
        head("grouper", "1.0"),
        opt[File]('i', "in")
          .required()
          .valueName("<file>")
          .text("In is a required file property"),
        opt[File]('o', "out")
          .valueName("<file>")
      )
    }

// OParser.parse returns Option[Config]
    OParser.parse(parser1, args, Config()) match {
      case Some(config) => args.toSeq
      case _            => ArraySeq.empty[String]
      // arguments are bad, error message will have been displayed
    }
  }
}
