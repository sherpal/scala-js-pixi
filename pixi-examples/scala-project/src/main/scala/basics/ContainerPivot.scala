package basics

import pixi.PIXIExample
import pixigraphics._

import scala.scalajs.js

object ContainerPivot extends PIXIExample {

  val name: String = "Container Pivot"

  val pixiUrl: String = "https://pixijs.io/examples/#/basics/container-pivot.js"

  def newApplication(): Application = {
    val app = new Application(new ApplicationOptions {
      override val backgroundColor: js.UndefOr[Int] = 0x1099bb
    })

    val container = new Container()

    app.stage.addChild(container)

    // Create a new texture
    val texture = Texture.fromImage("required/assets/basics/bunny.png")

    // Create a 5x5 grid of bunnies
    for (i <- 0 until 25) {
      val bunny = new Sprite(texture)
      bunny.anchor.set(0.5)
      bunny.x = (i % 5) * 40
      bunny.y = Math.floor(i / 5) * 40
      container.addChild(bunny)
    }

    // Move container to the center
    container.x = app.screen.width / 2
    container.y = app.screen.height / 2

    // Center bunny sprite in local container coordinates
    container.pivot.x = container.width / 2
    container.pivot.y = container.height / 2

    // Listen for animate update
    app.ticker.add((delta: Double) => {
      // rotate the container!
      // use delta to create frame-independent transform
      container.rotation -= 0.01 * delta
    })

    app
  }

}
