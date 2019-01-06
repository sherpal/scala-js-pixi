package pixigraphics.options

import scala.scalajs.js

/**
  * http://pixijs.download/release/docs/PIXI.Application.html#Application
  */
trait ApplicationOptions extends js.Object {

  val width: js.UndefOr[Int] = js.undefined
  val height: js.UndefOr[Int] = js.undefined

  val antialias: js.UndefOr[Boolean] = js.undefined

  val backgroundColor: js.UndefOr[Int] = js.undefined

  val transparent: js.UndefOr[Boolean] = js.undefined

}
