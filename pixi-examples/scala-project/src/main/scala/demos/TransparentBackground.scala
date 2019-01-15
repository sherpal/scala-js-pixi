package demos

import pixi.PIXIExample
import pixigraphics.options.ApplicationOptions
import pixigraphics.{Application, Sprite}

import scala.scalajs.js.UndefOr

case object TransparentBackground extends PIXIExample {

  val name: String = "Transparent Background"

  val pixiUrl: String = "https://pixijs.io/examples/#/demos/transparent-background.js"

  def newApplication(): Application = {
    val app = new Application(new ApplicationOptions {
      override val transparent: UndefOr[Boolean] = true
    })

    // create a new Sprite from an image path.
    val bunny = Sprite.fromImage("required/assets/bunny.png")

    // center the sprite's anchor point
    bunny.anchor.set(0.5)

    // move the sprite to the center of the screen
    bunny.x = app.screen.width / 2
    bunny.y = app.screen.height / 2

    app.stage.addChild(bunny)

    app.ticker.add((_: Double) => {

      // just for fun, let's rotate mr rabbit a little
      bunny.rotation += 0.1
    })

    app
  }

}
