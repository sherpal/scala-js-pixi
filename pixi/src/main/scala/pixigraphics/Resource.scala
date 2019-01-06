package pixigraphics

import scala.scalajs.js

/**
 * Resource
  *
  * Represents a Resource when loaded via the PIXI.loader.
  *
  * It might be worth making trait that extends js.Object to represent the data, as they depend on the type
  * of loaded file.
  *
  * see https://github.com/englercj/resource-loader
 */
trait Resource extends js.Object {

  val name: String

  val url: String

  val texture: Texture

  val data: js.Object

}
