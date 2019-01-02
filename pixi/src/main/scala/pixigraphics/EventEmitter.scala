package pixigraphics

import scala.scalajs.js

@js.native
trait EventEmitter extends js.Object {
  def on(eventName: String, listener: js.Function): Unit = js.native
}

