package pixigraphics

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal("PIXI.Matrix")
final class Matrix(
                    val a: Double = 1,
                    val b: Double = 0,
                    val c: Double = 0,
                    val d: Double = 1,
                    val tx: Double = 0,
                    val ty: Double = 0
                  ) extends js.Object {

}

@js.native
@JSGlobal("PIXI.Matrix")
object Matrix extends js.Object {

  val IDENTITY: Matrix = js.native

  val TEMP_MATRIX: Matrix = js.native

}