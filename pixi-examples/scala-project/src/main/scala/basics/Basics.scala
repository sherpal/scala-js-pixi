package basics

import pixi.PIXIExample
import pixigraphics.{Application, ApplicationOptions, Sprite}

import scala.scalajs.js

object Basics extends PIXIExample {

  val name: String = "Basics"

  val pixiUrl: String = "https://pixijs.io/examples/#/basics/basic.js"

  def newApplication(): Application = {
    val app = new Application(new ApplicationOptions {
      override val backgroundColor: js.UndefOr[Int] = 0x1099bb
    })

    // create a new Sprite from an image path
    val bunny = Sprite.fromImage("required/assets/basics/bunny.png")

    // center the sprite's anchor point
    bunny.anchor.set(0.5)

    // move the sprite to the center of the screen
    bunny.x = app.screen.width / 2
    bunny.y = app.screen.height / 2

    app.stage.addChild(bunny)

    // Listen for animate update
    app.ticker.add((delta: Double) => {
      // just for fun, let's rotate mr rabbit a little
      // delta is 1 if running at 100% performance
      // creates frame-independent transformation
      bunny.rotation += 0.1 * delta
    })

    app
  }

}
