package pixigraphics

import scala.scalajs.js

trait BitmapTextStyle extends js.Object {

  val font: js.UndefOr[String] = js.undefined

  val align: js.UndefOr[String] = js.undefined // default: "left"

  val tint: js.UndefOr[Int] = js.undefined // default: 0xFFFFFF

}
