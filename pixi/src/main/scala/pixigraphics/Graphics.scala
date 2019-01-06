package pixigraphics

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
 * http://pixijs.download/v4.3.5/docs/PIXI.Graphics.html
 */
@js.native
@JSGlobal("PIXI.Graphics")
final class Graphics() extends Container {

  def arc(x: Double, y: Double, radius: Int,
          startAngle: Double, endingAngle: Double, antiClockwise: Boolean = false): Graphics = js.native

  def beginFill(color: Int, alpha: Double = 1.0): Graphics = js.native

  def bezierCurveTo(cpX: Double, cpY: Double, cpX2: Double, cpY2: Double, toX: Double, toY: Double): Graphics =
    js.native

  def clear(): Graphics = js.native

  def closePath(): Graphics = js.native

  def destroy(): Unit = js.native

  def drawCircle(x: Double, y: Double, radius: Double): Graphics = js.native

  def drawRect(x: Double, y: Double, width: Double, height: Double): Graphics = js.native

  def drawRoundedRect(x: Double, y: Double, width: Double, height: Double, radius: Double): Graphics = js.native

  def drawPolygon(xs: js.Array[Double]): Graphics = js.native

  def endFill(): Graphics = js.native

  def lineStyle(lineWidth: Double, color: Double = 1.0, alpha: Double = 1.0): Graphics = js.native

  def lineTo(x: Double, y: Double): Graphics = js.native

  def moveTo(x: Double, y: Double): Graphics = js.native

  def quadraticCurveTo(cpX: Double, cpY: Double, toX: Double, toY: Double): Graphics = js.native

}
