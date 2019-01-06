package pixigraphics

import pixigraphics.options.RendererOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
 * http://pixijs.download/v4.3.5/docs/PIXI.CanvasRenderer.html
 */
@js.native
@JSGlobal("PIXI.CanvasRenderer")
final class CanvasRenderer(width: Int, height: Int, options: RendererOptions) extends Renderer
