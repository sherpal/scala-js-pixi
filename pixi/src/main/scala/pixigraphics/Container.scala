package pixigraphics

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
 * http://pixijs.download/v4.3.5/docs/PIXI.Container.html
 */
@js.native
@JSGlobal("PIXI.Container")
class Container extends DisplayObject {

  def children: js.Array[DisplayObject] = js.native

  var height: Double = js.native

  var interactiveChildren: Boolean = js.native

  val scale: Point = js.native

  var width: Double = js.native

  def addChild(child: DisplayObject*): DisplayObject = js.native

  def removeChild(child: DisplayObject*): DisplayObject = js.native

}
