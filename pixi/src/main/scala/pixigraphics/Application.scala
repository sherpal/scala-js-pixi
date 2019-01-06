package pixigraphics

import org.scalajs.dom.html
import pixigraphics.options.{ApplicationOptions, StageOptions}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

@JSGlobal("PIXI.Application")
@js.native
final class Application(options: ApplicationOptions = js.native) extends js.Object {

  val renderer: WebGLRenderer = js.native

  val screen: Rectangle = js.native

  val stage: Container = js.native

  val ticker: TickerTicker = js.native

  val view: html.Canvas = js.native

  def destroy(removeView: Boolean = false,
              stageOptions: StageOptions | Boolean = false): Unit = js.native

  def start(): Unit = js.native

  def stop(): Unit = js.native

}
