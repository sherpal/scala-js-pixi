package pixigraphics

import org.scalajs.dom.html

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal("PIXI.TextMetrics")
final class TextMetrics(val text: String, val style: TextStyle,
                        val width: Double, val height: Double,
                        val lines: js.Array[String], val lineWidths: js.Array[Double], // TODO: check type
                        val lineHeight: Double, val maxLineWidth: Double,
                        val fontProperties: js.Object) extends js.Object {

}


@js.native
@JSGlobal("PIXI.TextMetrics")
object TextMetrics extends js.Object {

  def measureText(text: String, style: TextStyle,
                  wordWrap: Boolean = js.native, canvas: html.Canvas = js.native): TextMetrics = js.native

}
