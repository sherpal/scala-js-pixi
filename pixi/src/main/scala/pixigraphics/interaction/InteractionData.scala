package pixigraphics.interaction

import pixigraphics.{DisplayObject, Point}

import scala.scalajs.js

/**
  * http://pixijs.download/dev/docs/PIXI.interaction.InteractionData.html
  */
@js.native
trait InteractionData extends js.Object {

  def getLocalPosition(displayObject: DisplayObject, point: Point = js.native, globalPos: Point = js.native): Point =
    js.native

}
