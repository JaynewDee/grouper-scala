val scala3Version = "3.3.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "grouper",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      "com.github.scopt" %% "scopt" % "4.1.0",
      "org.apache.commons" % "commons-csv" % "1.9.0"
    )
  )
