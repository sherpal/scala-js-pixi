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

  var dirty: Boolean = js.native

  var filters: js.Array[PIXIFilter] = js.native

  var interactive: Boolean = js.native

  val parent: PIXIContainer = js.native

  val pivot: PIXIPoint = js.native

  val position: PIXIPoint = js.native

  var rotation: Double = js.native

  var visible: Boolean = js.native

  var x: Double = js.native

  var y: Double = js.native


}