package pixigraphics.extras

import pixigraphics.{PIXISprite, PIXITexture}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal


/**
  * http://pixijs.download/v4.3.5/docs/PIXI.extras.AnimatedSprite.html
  */
@js.native
@JSGlobal("PIXI.extras.AnimatedSprite")
final class AnimatedSprite(
                      val textures: js.Array[PIXITexture],
                      autoUpdate: Boolean = true
                    ) extends PIXISprite(js.native) {

  var animationSpeed: Double = js.native

  def play(): Unit = js.native

}
