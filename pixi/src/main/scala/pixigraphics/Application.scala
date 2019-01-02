package pixigraphics

import org.scalajs.dom.html

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@JSGlobal("PIXI.Application")
@js.native
final class Application(options: ApplicationOptions) extends js.Object {

  val renderer: WebGLRenderer = js.native

  val screen: Rectangle = js.native

  val stage: Container = js.native

  val ticker: TickerTicker = js.native

  val view: html.Canvas = js.native

  def destroy(removeView: Boolean = false): Unit = js.native

}
