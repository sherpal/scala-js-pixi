package pixigraphics

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@JSGlobal("PIXI.Rectangle")
@js.native
class PIXIRectangle(var x: Int = 0, var y: Int = 0,
                    var width: Int = 0, var height: Int = 0) extends js.Object {

  def contains(x: Int, y: Int): Boolean = js.native

}
