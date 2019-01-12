package pixigraphics.filters

import pixigraphics.Filter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal("PIXI.filters.OutlineFilter")
final class OutlineFilter(
                           thickness: Double = 1,
                           color: Int = 0x000000,
                           quantity: Double = 0.1
                         ) extends Filter(js.native, js.native, js.native) {

}
