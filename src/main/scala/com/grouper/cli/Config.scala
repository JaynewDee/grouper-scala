package com.grouper.cli

import java.io.File

case class Config(
    in: File = new File("."),
    out: File = new File(".")
)
