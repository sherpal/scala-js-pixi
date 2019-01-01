package pixigraphics

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
 * http://pixijs.download/v4.3.5/docs/PIXI.Graphics.html
 */
@js.native
@JSGlobal("PIXI.Graphics")
class PIXIGraphics() extends PIXIContainer {

  def arc(x: Double, y: Double, radius: Int,
          startAngle: Double, endingAngle: Double, antiClockwise: Boolean = false): PIXIGraphics = js.native

  def beginFill(color: Int, alpha: Double = 1.0): PIXIGraphics = js.native

  def clear(): PIXIGraphics = js.native

  def closePath(): PIXIGraphics = js.native

  def drawCircle(x: Double, y: Double, radius: Double): PIXIGraphics = js.native

  def drawRect(x: Double, y: Double, width: Double, height: Double): PIXIGraphics = js.native

  def drawRoundedRect(x: Double, y: Double, width: Double, height: Double, radius: Double): PIXIGraphics = js.native

  def drawPolygon(xs: js.Array[Double]): PIXIGraphics = js.native

  def endFill(): PIXIGraphics = js.native

  def lineStyle(lineWidth: Double, color: Double, alpha: Double = 1.0): PIXIGraphics = js.native

  def lineTo(x: Double, y: Double): PIXIGraphics = js.native

  def moveTo(x: Double, y: Double): PIXIGraphics = js.native

}
