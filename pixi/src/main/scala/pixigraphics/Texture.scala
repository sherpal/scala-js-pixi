package pixigraphics

import org.scalajs.dom.html

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
 * http://pixijs.download/v4.3.5/docs/PIXI.Texture.html
 */
@js.native
@JSGlobal("PIXI.Texture")
class Texture() extends js.Object {

  def update(): Unit = js.native

}


@js.native
@JSGlobal("PIXI.Texture")
object Texture extends js.Object {

  def fromFrame(frameId: String): Texture = js.native

  def fromImage(imageId: String): Texture = js.native

  def fromCanvas(canvas: html.Canvas): Texture = js.native

  def fromVideo(video: html.Video | String): Texture = js.native

}