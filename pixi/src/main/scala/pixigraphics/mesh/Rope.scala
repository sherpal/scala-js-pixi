package pixigraphics.mesh

import pixigraphics.{Point, Texture}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal("PIXI.mesh.Rope")
final class Rope(texture: Texture, points: js.Array[Point]) extends Mesh {

}
