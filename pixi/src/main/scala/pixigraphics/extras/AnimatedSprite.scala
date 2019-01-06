package pixigraphics.extras

import pixigraphics.objects.FrameObject
import pixigraphics.{Sprite, Texture}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|


/**
  * http://pixijs.download/v4.3.5/docs/PIXI.extras.AnimatedSprite.html
  */
@js.native
@JSGlobal("PIXI.extras.AnimatedSprite")
final class AnimatedSprite(
                            val textures: js.Array[Texture] | js.Array[FrameObject],
                            autoUpdate: Boolean = true
                    ) extends Sprite(js.native) {

  var animationSpeed: Double = js.native

  def gotoAndPlay(frameNumber: Int): Unit = js.native

  def play(): Unit = js.native

}
