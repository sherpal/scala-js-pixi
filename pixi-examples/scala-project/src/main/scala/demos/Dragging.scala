package demos

import pixi.PIXIExample
import pixigraphics._
import pixigraphics.interaction.{InteractionData, InteractionEvent}
import pixigraphics.options.ApplicationOptions

import scala.scalajs.js.UndefOr

case object Dragging extends PIXIExample {

  val name: String = "Dragging"

  val pixiUrl: String = "https://pixijs.io/examples/#/demos/dragging.js"

  def newApplication(): Application = {
    val app = new Application(new ApplicationOptions {
      override val backgroundColor: UndefOr[Int] = 0x1099bb
    })

    // create a texture from an image path
    val texture = Texture.fromImage("required/assets/bunny.png")

    // Scale mode for pixelation
    texture.baseTexture.scaleMode = PIXI.SCALE_MODES.NEAREST

    final class Bunny(x: Double, y: Double) {

      private var data: Option[InteractionData] = None

      private def dragging: Boolean = data.isDefined

      private val bunny: Sprite = new Sprite(texture)

      // enable the bunny to be interactive... this will allow it to respond to mouse and touch events
      bunny.interactive = true

      // this button mode will mean the hand cursor appears when you roll over the bunny with your mouse
      bunny.buttonMode = true

      // center the bunny's anchor point
      bunny.anchor.set(0.5)

      // make it a bit bigger, so it's easier to grab
      bunny.scale.set(3)

      // setup events for mouse + touch using
      // the pointer events
      bunny
        .on("pointerdown", (event: InteractionEvent) => onDragStart(event))
        .on("pointerup", () => onDragEnd())
        .on("pointerupoutside", () => onDragEnd())
        .on("pointermove", () => onDragMove())

      // For mouse-only events
      // .on('mousedown', onDragStart)
      // .on('mouseup', onDragEnd)
      // .on('mouseupoutside', onDragEnd)
      // .on('mousemove', onDragMove);

      // For touch-only events
      // .on('touchstart', onDragStart)
      // .on('touchend', onDragEnd)
      // .on('touchendoutside', onDragEnd)
      // .on('touchmove', onDragMove);

      // move the sprite to its designated position
      bunny.x = x
      bunny.y = y

      // add it to the stage
      app.stage.addChild(bunny)

      def onDragStart(event: InteractionEvent) {
        // store a reference to the data
        // the reason for this is because of multitouch
        // we want to track the movement of this particular touch
        data = Some(event.data)
        bunny.alpha = 0.5
      }

      def onDragEnd(): Unit = {
        bunny.alpha = 1
        // set the interaction data to null
        data = None
      }

      def onDragMove(): Unit = {
        if (dragging) {
          val newPosition = data.get.getLocalPosition(bunny.parent)
          bunny.x = newPosition.x
          bunny.y = newPosition.y
        }
      }

    }

    for (_ <- 0 until 10) {
      new Bunny(
        Math.floor(Math.random() * app.screen.width),
        Math.floor(Math.random() * app.screen.height)
      )
    }

    app

  }

}
