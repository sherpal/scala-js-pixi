package pixigraphics.mesh

import pixigraphics.Texture

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.typedarray.{Float32Array, Uint16Array}


@js.native
@JSGlobal("PIXI.mesh.Mesh")
final class SimpleMesh(
                  val texture: Texture = js.native,
                  val vertices: Float32Array = js.native,
                  val uvs: Float32Array = js.native,
                  val indices: Uint16Array = js.native,
                  val drawMode: Int = js.native
                ) extends Mesh {

}
