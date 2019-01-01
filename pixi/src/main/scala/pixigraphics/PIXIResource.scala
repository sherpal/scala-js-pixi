package pixigraphics

import scala.scalajs.js

/**
 * Resource
 */
trait PIXIResource extends js.Object {

  val name: String

  val url: String

  val texture: PIXITexture

  val data: js.Object

}
