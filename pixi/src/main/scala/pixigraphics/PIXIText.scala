package pixigraphics

import org.scalajs.dom
import org.scalajs.dom.html

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
 * http://pixijs.download/dev/docs/PIXI.Text.html
 */
@js.native
@JSGlobal("PIXI.Text")
class PIXIText(t: String, var style: PIXITextStyle,
               canvas: html.Canvas = dom.document.createElement("canvas").asInstanceOf[html.Canvas])
 extends PIXISprite(js.native) {


  var text: String = js.native
}
