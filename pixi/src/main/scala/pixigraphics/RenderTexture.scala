package pixigraphics

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * http://pixijs.download/dev/docs/PIXI.RenderTexture.html
  */
@js.native
@JSGlobal("PIXI.RenderTexture")
final class RenderTexture(baseRenderTexture: BaseRenderTexture, frame: Rectangle = js.native)
extends Texture(js.native) {

}

@js.native
@JSGlobal("PIXI.RenderTexture")
object RenderTexture extends js.Object {

  def create(width: Double = 100, height: Double = 100,
             scalaMode: Int = js.native, resolution: Double = 1): RenderTexture = js.native

}