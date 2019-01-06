package pixigraphics

import pixigraphics.utils.EventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
 * http://pixijs.download/v4.3.5/docs/PIXI.DisplayObject.html
 */
@js.native
@JSGlobal("PIXI.DisplayObject")
abstract class DisplayObject extends EventEmitter {

  final var alpha: Double = js.native

  final var buttonMode: Boolean = js.native

  final var dirty: Boolean = js.native

  final var filters: js.Array[Filter] = js.native

  final var interactive: Boolean = js.native

  final var mask: Sprite | Graphics = js.native

  final val parent: Container = js.native

  final val pivot: Point = js.native

  final val position: Point = js.native

  final var rotation: Double = js.native

  final var visible: Boolean = js.native

  final var x: Double = js.native

  final var y: Double = js.native

}