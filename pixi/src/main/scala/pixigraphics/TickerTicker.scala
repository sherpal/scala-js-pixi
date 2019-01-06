package pixigraphics

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * http://pixijs.download/dev/docs/PIXI.ticker.Ticker.html
  */
@JSGlobal("PIXI.ticker.Ticker")
@js.native
final class TickerTicker() extends js.Object {

  var elapsedMS: Double = js.native

  def FPS: Double = js.native

  def add(fn: js.Function): Unit = js.native

}
