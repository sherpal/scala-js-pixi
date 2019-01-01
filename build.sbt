name := "scala-js-pixi"

version := "1.0.0"

scalaVersion := "2.12.8"

organization := "be.adoeraene"

lazy val `pixi-facade` = project.in(file("pixi"))
.enablePlugins(ScalaJSPlugin)
.settings(
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.9.6"
  )
)
