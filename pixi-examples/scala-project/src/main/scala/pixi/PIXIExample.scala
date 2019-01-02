package pixi

import basics._
import pixigraphics.PIXIApplication

trait PIXIExample {

  val name: String

  val pixiUrl: String

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
    ExampleSelector.changeCanvas(pixiApp.get.view, pixiUrl)
  }

}

object PIXIExample {

  val allExamples: List[PIXIExample] = List(
    Basics,
    Container,
    ContainerPivot,
    SpriteSheetAnimation,
    Click,
    TilingSprite
  )

  def stopAll(): Unit =
    allExamples.foreach(_.stop())

}
