package pixigraphics

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
 * http://pixijs.download/v4.3.5/docs/PIXI.Sprite.html
 */
@js.native
@JSGlobal("PIXI.Sprite")
class Sprite(var texture: Texture) extends Container with WithTint {

  var anchor: ObservablePoint = js.native

  var blendMode: Int = js.native

  var mask: Sprite | Graphics = js.native

}


@js.native
@JSGlobal("PIXI.Sprite")
object Sprite extends js.Object {

  def fromImage(imageId: String): Sprite = js.native

}