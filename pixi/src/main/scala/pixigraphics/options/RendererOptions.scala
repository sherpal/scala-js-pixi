package pixigraphics.options

import org.scalajs.dom.html

import scala.scalajs.js

/**
 * Options that can be put into a
 */
trait RendererOptions extends js.Object {

  /** the canvas to use as a view, optional */
  val view: js.UndefOr[html.Canvas] = js.undefined

  val antialias: js.UndefOr[Boolean] = js.undefined

}
