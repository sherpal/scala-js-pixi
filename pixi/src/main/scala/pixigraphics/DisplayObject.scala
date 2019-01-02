package pixigraphics

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
 * http://pixijs.download/v4.3.5/docs/PIXI.DisplayObject.html
 */
@js.native
@JSGlobal("PIXI.DisplayObject")
abstract class DisplayObject extends EventEmitter {

  var alpha: Double = js.native

  var buttonMode: Boolean = js.native

  var dirty: Boolean = js.native

  var filters: js.Array[Filter] = js.native

  var interactive: Boolean = js.native

  val parent: Container = js.native

  val pivot: Point = js.native

  val position: Point = js.native

  var rotation: Double = js.native

  var visible: Boolean = js.native

  var x: Double = js.native

  var y: Double = js.native


}