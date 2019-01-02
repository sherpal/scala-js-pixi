package pixigraphics

import pixigraphics.pixisettings.PIXISettings

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
 * Base instance of PIXI.
 */
@js.native
@JSGlobal("PIXI")
object PIXI extends js.Object {

  val loader: Loader = js.native

  val SCALE_MODES: ScaleModeChoices = js.native

  val BLEND_MODES: BlendModeChoices = js.native

  val settings: PIXISettings = js.native

}
