package pixigraphics.utils

import scala.scalajs.js

@js.native
trait EventEmitter extends js.Object {
  def on(eventName: String, listener: js.Function): EventEmitter = js.native
}

