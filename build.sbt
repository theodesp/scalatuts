name := "scalatuts"

version := "0.1"

scalaVersion := "2.12.5"

organization := "filesearcher"

// if you have more than one main method, you can specify which is used when typing 'run' in sbt
mainClass := Some("fileSearcher.App")

scalacOptions ++= Seq("-unchecked", "-deprecation")