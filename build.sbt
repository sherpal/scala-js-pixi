name := "scala-js-pixi"

version := "0.1.0"

scalaVersion := "2.12.8"

organization := "be.doeraene"

lazy val `pixi-facade` = project.in(file("pixi"))
.enablePlugins(ScalaJSPlugin)
.settings(
  name := "scala-js-pixi",
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.9.6"
  ),
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  pomExtra :=
    <developers>
      <developer>
        <id>sherpal</id>
        <name>Antoine Doeraene</name>
        <url>https://github.com/sherpal</url>
      </developer>
    </developers>,
  pomIncludeRepository := { _ => false },

)

lazy val `examples` = project.in(file("pixi-examples/scala-project"))
.enablePlugins(ScalaJSPlugin)
.dependsOn(`pixi-facade`)
.settings(
  scalaJSUseMainModuleInitializer := true
)
