package pixigraphics

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
 * http://pixijs.download/v4.3.5/docs/PIXI.Sprite.html
 */
@js.native
@JSGlobal("PIXI.Sprite")
class PIXISprite(var texture: PIXITexture) extends PIXIContainer with WithTint{

  var anchor: PIXIObservablePoint = js.native

  var blendMode: Int = js.native

  var mask: PIXISprite | PIXIGraphics = js.native

  //var tint: Int = js.native


}


@js.native
@JSGlobal("PIXI.Sprite")
object PIXISprite extends js.Object {

  def fromImage(imageId: String): PIXISprite = js.native

}