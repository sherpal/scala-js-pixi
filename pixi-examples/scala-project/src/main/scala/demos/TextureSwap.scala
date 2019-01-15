package demos

import pixi.PIXIExample
import pixigraphics.{Application, Sprite, Texture}

case object TextureSwap extends PIXIExample {

  val name: String = "Texture Swap"

  val pixiUrl: String = "https://pixijs.io/examples/#/demos/texture-swap.js"

  def newApplication(): Application = {
    val app = new Application()

    var bol = false

    // create a texture from an image path
    val texture = Texture.fromImage("required/assets/flowerTop.png")

    // create a second texture
    val secondTexture = Texture.fromImage("required/assets/eggHead.png")

    // create a new Sprite using the texture
    val dude = new Sprite(texture)

    // center the sprites anchor point
    dude.anchor.set(0.5)

    // move the sprite to the center of the screen
    dude.x = app.screen.width / 2
    dude.y = app.screen.height / 2

    app.stage.addChild(dude)

    // make the sprite interactive
    dude.interactive = true
    dude.buttonMode = true

    dude.on("pointertap", () => {
      bol = !bol
      if (bol) {
        dude.texture = secondTexture
      }
      else {
        dude.texture = texture
      }
    })

    app.ticker.add((_: Double) => {
      // just for fun, let's rotate mr rabbit a little
      dude.rotation += 0.1
    })

    app
  }

}
