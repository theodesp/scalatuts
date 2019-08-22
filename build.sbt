name := "scalatuts"

version := "0.1"

scalaVersion := "2.13.0"

organization := "filesearcher"

// if you have more than one main method, you can specify which is used when typing 'run' in sbt
mainClass := Some("fileSearcher.App")

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

scalacOptions ++= Seq("-unchecked", "-deprecation")
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.8"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"