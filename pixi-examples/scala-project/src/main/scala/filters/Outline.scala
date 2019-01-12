package filters

import pixi.PIXIExample
import pixigraphics.filters.{GlowFilter, OutlineFilter}
import pixigraphics.{Application, Sprite}

import scala.scalajs.js

object Outline extends PIXIExample {

  val name: String = "Outline"

  val pixiUrl: String = "https://pixijs.io/examples/#/filters/outline-filter.js"

  def newApplication(): Application = {
    // this example uses plugin https://github.com/pixijs/pixi-extra-filters/

    val app = new Application()

    app.stage.position.set(400, 300)

    val outlineFilterBlue = new OutlineFilter(2, 0x99ff99)
    val outlineFilterRed = new GlowFilter(15, 2, 1, 0xff9999, 0.5)


    final class Bunny {
      val bunny: Sprite =  Sprite.fromImage("required/assets/bunny.png")
      // bunny.anchor.set(0.5);
      bunny.interactive = true
      bunny.position.set((Math.random() * 2 - 1) * 300, (Math.random()*2 - 1) * 200)
      bunny.scale.x = (Math.random() * 3 * 0.1) + 1
      bunny
        .on("pointerover", () => filterOn() )
        .on("pointerout", () => filterOff() )

      def filterOn(): Unit = {
        bunny.filters = js.Array(outlineFilterRed)
      }

      def filterOff(): Unit = {
        bunny.filters = js.Array(outlineFilterBlue)
      }

      filterOff()
      app.stage.addChild(bunny)

    }

    for (_ <- 0 until 20) yield new Bunny

    app
  }

}
