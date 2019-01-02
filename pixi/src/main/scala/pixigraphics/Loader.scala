package pixigraphics

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
 * http://pixijs.download/v4.3.5/docs/PIXI.loaders.Loader.html
 */
@js.native
@JSGlobal("PIXI.loaders.Loader")
final class Loader extends js.Object {

  val resources: js.Dictionary[Resource] = js.native

  def add(sourceFile: String): Loader = js.native

  def add(name: String, sourceFile: String): Loader = js.native

  def load(callback: js.Function2[Loader, js.Dictionary[Resource], Unit]): Unit = js.native

}
