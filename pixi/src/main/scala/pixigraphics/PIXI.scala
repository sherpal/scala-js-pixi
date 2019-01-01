package pixigraphics

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
 * Base instance of PIXI.
 */
@js.native
@JSGlobal("PIXI")
object PIXI extends js.Object {

  val loader: PIXILoader = js.native

  val SCALE_MODES: js.Dynamic = js.native

  val BLEND_MODES: BlendModeChoices = js.native

}
