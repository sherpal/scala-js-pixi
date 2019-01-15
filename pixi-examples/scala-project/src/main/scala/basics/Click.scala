package basics

import pixi.PIXIExample
import pixigraphics.options.ApplicationOptions
import pixigraphics.{Application, PIXI, Sprite}

import scala.scalajs.js

case object Click extends PIXIExample {

  val name: String = "Click"

  val pixiUrl: String = "https://pixijs.io/examples/#/basics/click.js"

  def newApplication(): Application = {

    val app = new Application(new ApplicationOptions {
      override val backgroundColor: js.UndefOr[Int] = 0x1099bb
    })

    // Scale mode for all textures, will retain pixelation
    PIXI.settings.SCALE_MODE = PIXI.SCALE_MODES.NEAREST

    val sprite = Sprite.fromImage("required/assets/basics/bunny.png")

    // Set the initial position
    sprite.anchor.set(0.5)
    sprite.x = app.screen.width / 2
    sprite.y = app.screen.height / 2

    // Opt-in to interactivity
    sprite.interactive = true

    // Shows hand cursor
    sprite.buttonMode = true

    // Pointers normalize touch and mouse
    sprite.on("pointerdown", () => onClick())

    // Alternatively, use the mouse & touch events:
    // sprite.on('click', onClick); // mouse-only
    // sprite.on('tap', onClick); // touch-only

    app.stage.addChild(sprite)

    def onClick(): Unit = {
      sprite.scale.x *= 1.25
      sprite.scale.y *= 1.25
    }

    app
  }

}
