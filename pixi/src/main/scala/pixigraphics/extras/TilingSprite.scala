package pixigraphics.extras

import pixigraphics.{PIXIObservablePoint, PIXISprite, PIXITexture}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * http://pixijs.download/release/docs/PIXI.extras.TilingSprite.html
  */
@js.native
@JSGlobal("PIXI.extras.TilingSprite")
final class TilingSprite(
                          texture: PIXITexture,
                          width: Double = 100,
                          height: Double = 100
                        ) extends PIXISprite(js.native) {

  val tilePosition: PIXIObservablePoint = js.native

  val tileScale: PIXIObservablePoint = js.native

}
