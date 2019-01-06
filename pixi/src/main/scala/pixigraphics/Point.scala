package pixigraphics

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
 * http://pixijs.download/v4.3.5/docs/PIXI.Point.html
 */
@js.native
@JSGlobal("PIXI.Point")
final class Point(var x: Double = 0, var y: Double = 0) extends js.Object {

  def set(x: Double, y: Double = x): Unit = js.native

}
