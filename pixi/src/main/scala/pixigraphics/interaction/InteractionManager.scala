package pixigraphics.interaction

import pixigraphics.Renderer
import pixigraphics.objects.CursorStyles

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * http://pixijs.download/release/docs/PIXI.interaction.InteractionManager.html
  */
// todo: type-safe options
@js.native
@JSGlobal("PIXI.interaction.InteractionManager")
class InteractionManager(val renderer: Renderer, options: js.Object = js.native) extends js.Object {

  val cursorStyles: CursorStyles = js.native

  def mouse: InteractionData = js.native

}
