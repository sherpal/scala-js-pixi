package pixigraphics

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * http://pixijs.download/dev/docs/PIXI.BaseRenderTexture.html
  */
@js.native
@JSGlobal("PIXI.BaseRenderTexture")
final class BaseRenderTexture(
                                   val width: Double = 100,
                                   val height: Double = 100,
                                   scaleMode: Int = js.native,
                                   resolution: Double = js.native
                                 ) extends BaseTexture(js.native, js.native, js.native) {

}
