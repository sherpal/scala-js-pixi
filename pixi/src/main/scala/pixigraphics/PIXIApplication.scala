package pixigraphics

import org.scalajs.dom.html

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@JSGlobal("PIXI.Application")
@js.native
final class PIXIApplication(options: PIXIApplicationOptions) extends js.Object {

  val renderer: WebGLRenderer = js.native

  val screen: PIXIRectangle = js.native

  val stage: PIXIContainer = js.native

  val ticker: PIXITickerTicker = js.native

  val view: html.Canvas = js.native

}
