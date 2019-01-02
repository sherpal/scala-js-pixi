package pixigraphics.extras

import pixigraphics.{ObservablePoint, Sprite, Texture}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * http://pixijs.download/release/docs/PIXI.extras.TilingSprite.html
  */
@js.native
@JSGlobal("PIXI.extras.TilingSprite")
final class TilingSprite(
                          texture: Texture,
                          width: Double = 100,
                          height: Double = 100
                        ) extends Sprite(js.native) {

  val tilePosition: ObservablePoint = js.native

  val tileScale: ObservablePoint = js.native

}
