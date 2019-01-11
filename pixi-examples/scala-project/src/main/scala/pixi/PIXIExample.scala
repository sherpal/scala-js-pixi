package pixi

import basics._
import demos._
import pixigraphics.Application

trait PIXIExample {

  val name: String

  val pixiUrl: String

  private var pixiApp: Option[Application] = None

  private def stop(): Unit = {
    pixiApp match {
      case Some(app) =>
        app.destroy(removeView = true, stageOptions = true)
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

  val allExamples: Map[String, List[PIXIExample]] = Map(
    "Basics" -> List(
      Basics,
      Container,
      ContainerPivot,
      SpriteSheetAnimation,
      Click,
      TilingSprite,
      Text,
      Graphics,
      Video,
      RenderTexture,
      CustomFilter
    ),
    "Demos" -> List(
      AnimatedSprite,
      AnimationSpeed,
      Interactivity,
      TransparentBackground,
      Dragging,
      DemoRenderTexture,
      DemoGraphics,
      Masking,
      MaskingRenderTexture,
      BlendModes,
      Tinting,
      ParticleContainer,
      Strip,
      TextureSwap,
      TextureRotate,
      AlphaMask,
      MouseTrail
    )
  )

  def stopAll(): Unit =
    allExamples.values.flatten.foreach(_.stop())

}
