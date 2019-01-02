package pixigraphics

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
 * http://pixijs.download/dev/docs/PIXI.extras.BitmapText.html
 */
@js.native
@JSGlobal("PIXI.extras.BitmapText")
final class BitmapText(var text: String, style: BitmapTextStyle) extends Container with WithTint {

  var align: String = js.native

  def textHeight: Double = js.native

  def textWidth: Double = js.native

}
