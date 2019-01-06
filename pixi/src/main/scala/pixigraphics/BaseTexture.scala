package pixigraphics

import org.scalajs.dom.html
import pixigraphics.utils.EventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
  * http://pixijs.download/dev/docs/PIXI.BaseTexture.html
  */
@js.native
@JSGlobal("PIXI.BaseTexture")
class BaseTexture(
                     val source: html.Image | html.Canvas,
                     var scaleMode: Double = js.native,
                     var resolution: Double = js.native
                     ) extends EventEmitter {

}
