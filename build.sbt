name := "scala-js-pixi"

scalaVersion := "2.12.8"

organization := "be.doeraene"

lazy val `pixi-facade` = project.in(file("pixi"))
.enablePlugins(ScalaJSPlugin)
.enablePlugins(Sonatype).enablePlugins(SbtPgp).enablePlugins(DynVerPlugin)
.settings(
  name := "scala-js-pixi",
  homepage := Some(url("https://github.com/sherpal/scala-js-pixi")),
  licenses += ("MIT", url("https://github.com/sherpal/scala-js-pixi/blob/master/LICENSE")),
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.9.6"
  ),
  scmInfo := Some(ScmInfo(
    url("https://github.com/sherpal/scala-js-pixi"),
    "scm:git:git@github.com:sherpal/scala-js-pixi.git"
  )),
  publishMavenStyle := true,
  publishTo := sonatypePublishTo.value,
  description := "A Scala.js facade for PixiJS",
  developers := List(Developer("sherpal", "Antoine Doeraene", "antoine.doerane@gmail.com", url("https://github.com/sherpal"))),
  pomExtra :=
    <developers>
      <developer>
        <id>sherpal</id>
        <name>Antoine Doeraene</name>
        <url>https://github.com/sherpal</url>
      </developer>
    </developers>,
  pomIncludeRepository := { _ => false },
  credentials += Credentials(Path.userHome / ".sbt" / "sonatype_credential")
)

lazy val `examples` = project.in(file("pixi-examples/scala-project"))
.enablePlugins(ScalaJSPlugin)
.dependsOn(`pixi-facade`)
.settings(
  scalaJSUseMainModuleInitializer := true
)
