package pixigraphics

import org.scalajs.dom.html

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
 * http://pixijs.download/v4.3.5/docs/PIXI.Texture.html
 */
@js.native
@JSGlobal("PIXI.Texture")
final class PIXITexture() extends js.Object {

  def update(): Unit = js.native

}


@js.native
@JSGlobal("PIXI.Texture")
object PIXITexture extends js.Object {

  def fromFrame(frameId: String): PIXITexture = js.native

  def fromImage(imageId: String): PIXITexture = js.native

  def fromCanvas(canvas: html.Canvas): PIXITexture = js.native

}