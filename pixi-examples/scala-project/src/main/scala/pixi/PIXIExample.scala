package pixi

import basics.{Basics, Container}
import pixigraphics.PIXIApplication

trait PIXIExample {

  val name: String

  private var pixiApp: Option[PIXIApplication] = None

  private def stop(): Unit = {
    pixiApp match {
      case Some(app) =>
        app.destroy(removeView = true)
      case None =>
    }
    pixiApp = None
  }

  protected def newApplication(): PIXIApplication

  def run(): Unit = {
    PIXIExample.stopAll()
    pixiApp = Some(newApplication())
  }

}

object PIXIExample {

  val allExamples: List[PIXIExample] = List(
    Basics,
    Container
  )

  def stopAll(): Unit =
    allExamples.foreach(_.stop())

}
