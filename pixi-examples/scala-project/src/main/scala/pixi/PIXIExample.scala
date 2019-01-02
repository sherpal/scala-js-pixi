package pixi

import basics._
import pixigraphics.Application

trait PIXIExample {

  val name: String

  val pixiUrl: String

  private var pixiApp: Option[Application] = None

  private def stop(): Unit = {
    pixiApp match {
      case Some(app) =>
        app.destroy(removeView = true)
      case None =>
    }
    pixiApp = None
  }

  protected def newApplication(): Application

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
    TilingSprite,
    Text,
    Graphics,
    Video,
    RenderTexture
  )

  def stopAll(): Unit =
    allExamples.foreach(_.stop())

}
