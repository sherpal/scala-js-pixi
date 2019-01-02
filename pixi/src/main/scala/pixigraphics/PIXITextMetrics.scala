package pixigraphics

import org.scalajs.dom.html

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal("PIXI.TextMetrics")
final class PIXITextMetrics(val text: String, val style: PIXITextStyle,
                            val width: Double, val height: Double,
                            val lines: js.Array[String], val lineWidths: js.Array[Double], // TODO: check type
                            val lineHeight: Double, val maxLineWidth: Double,
                            val fontProperties: js.Object) extends js.Object {

}


@js.native
@JSGlobal("PIXI.TextMetrics")
object PIXITextMetrics extends js.Object {

  def measureText(text: String, style: PIXITextStyle,
                  wordWrap: Boolean = js.native, canvas: html.Canvas = js.native): PIXITextMetrics = js.native

}
