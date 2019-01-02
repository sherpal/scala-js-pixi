package pixigraphics

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
 * http://pixijs.download/v4.3.5/docs/PIXI.loaders.Loader.html
 */
@js.native
@JSGlobal("PIXI.loaders.Loader")
final class PIXILoader extends js.Object {

  val resources: js.Dictionary[PIXIResource] = js.native

  def add(sourceFile: String): PIXILoader = js.native

  def add(name: String, sourceFile: String): PIXILoader = js.native

  def load(callback: js.Function2[PIXILoader, js.Dictionary[PIXIResource], Unit]): Unit = js.native

}
