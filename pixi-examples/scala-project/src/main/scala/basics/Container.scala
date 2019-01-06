package basics

import pixi.PIXIExample
import pixigraphics._
import pixigraphics.options.ApplicationOptions

import scala.scalajs.js

object Container extends PIXIExample {

  val name: String = "Container"

  val pixiUrl: String = "https://pixijs.io/examples/#/basics/container.js"

  def newApplication(): Application = {

    val app = new Application(new ApplicationOptions {
      override val backgroundColor: js.UndefOr[Int] = 0x1099bb
    })

    val container = new Container()

    app.stage.addChild(container)

    val texture = Texture.fromImage("required/assets/basics/bunny.png")

    // Create a 5x5 grid of bunnies
    for (i <- 0 until 25) {
      val bunny = new Sprite(texture)
      bunny.anchor.set(0.5)
      bunny.x = (i % 5) * 40
      bunny.y = Math.floor(i / 5) * 40
      container.addChild(bunny)
    }

    // Center on the screen
    container.x = (app.screen.width - container.width) / 2
    container.y = (app.screen.height - container.height) / 2

    app
  }

}
