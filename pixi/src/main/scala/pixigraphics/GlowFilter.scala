package pixigraphics

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
 * http://pixijs.github.io/pixi-filters/docs/PIXI.filters.GlowFilter.html
 */
@js.native
@JSGlobal("PIXI.filters.GlowFilter")
class GlowFilter(var distance: Double = 10, var outerStrength: Double = 4, var innerStrength: Double = 0,
                 var color: Int = 0xFFFFFF, quality: Double = 0.1) extends PIXIFilter(js.native, js.native, js.native) {

}
