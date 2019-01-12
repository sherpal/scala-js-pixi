package pixigraphics.filters

import pixigraphics.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal


@js.native
@JSGlobal("PIXI.filters.ColorMatrixFilter")
final class ColorMatrixFilter() extends Filter(js.native, js.native, js.native) {

  val matrix: js.Array[Double] = js.native

}
