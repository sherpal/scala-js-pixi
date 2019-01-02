package pixigraphics.extras

import pixigraphics.{Sprite, Texture}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal


/**
  * http://pixijs.download/v4.3.5/docs/PIXI.extras.AnimatedSprite.html
  */
@js.native
@JSGlobal("PIXI.extras.AnimatedSprite")
final class AnimatedSprite(
                            val textures: js.Array[Texture],
                            autoUpdate: Boolean = true
                    ) extends Sprite(js.native) {

  var animationSpeed: Double = js.native

  def play(): Unit = js.native

}
