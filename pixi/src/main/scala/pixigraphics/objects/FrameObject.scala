package pixigraphics.objects

import pixigraphics.Texture

import scala.scalajs.js

trait FrameObject extends js.Object {

  val texture: Texture

  val time: Double

}
