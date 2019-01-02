package basics

import pixi.{ExampleSelector, PIXIExample}
import pixigraphics._

import scala.scalajs.js

object Container extends PIXIExample {

  val name: String = "Container"

  def newApplication(): PIXIApplication = {

    val app = new PIXIApplication(new PIXIApplicationOptions {
      override val backgroundColor: js.UndefOr[Int] = 0x1099bb
    })
    ExampleSelector.changeCanvas(app.view)

    val container = new PIXIContainer()

    app.stage.addChild(container)

    val texture = PIXITexture.fromImage("required/assets/basics/bunny.png")

    // Create a 5x5 grid of bunnies
    for (i <- 0 until 25) {
      val bunny = new PIXISprite(texture)
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
