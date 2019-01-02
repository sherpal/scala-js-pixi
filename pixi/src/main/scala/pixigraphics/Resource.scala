package pixigraphics

import scala.scalajs.js

/**
 * Resource
 */
trait Resource extends js.Object {

  val name: String

  val url: String

  val texture: Texture

  val data: js.Object

}
