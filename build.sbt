name := "MyFrist"
 
version := "1.0" 
      
lazy val `myfrist` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"
      
scalaVersion := "2.12.13"

libraryDependencies ++= Seq( jdbc ,
  ehcache ,
  ws ,
  specs2 % Test ,
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test ,
  "com.typesafe.play" %% "play-json" % "2.9.2",
  guice )
scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-Xfatal-warnings"
)

