package pixigraphics.filters

import pixigraphics.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal("PIXI.filters.BlurFilter")
final class BlurFilter() extends Filter(js.native, js.native, js.native) {

  var blur: Double = js.native

}
