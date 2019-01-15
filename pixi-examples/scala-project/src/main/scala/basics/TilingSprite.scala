package basics

import pixi.PIXIExample
import pixigraphics.extras.{TilingSprite => TilingSpriteClass}
import pixigraphics.options.ApplicationOptions
import pixigraphics.{Application, Texture}

case object TilingSprite extends PIXIExample {

  val name: String = "Tiling Sprite"

  val pixiUrl: String = "https://pixijs.io/examples/#/basics/tiling-sprite.js"

  def newApplication(): Application = {

    val app = new Application(new ApplicationOptions {})

    // create a texture from an image path
    val texture = Texture.fromImage("required/assets/p2.jpeg")

    /* create a tiling sprite ...
     * requires a texture, a width and a height
     * in WebGL the image size should preferably be a power of two
     */
    val tilingSprite = new TilingSpriteClass(
      texture,
      app.screen.width,
      app.screen.height
    )
    app.stage.addChild(tilingSprite)

    var count: Double = 0

    app.ticker.add((_: Double) => {

      count += 0.005

      tilingSprite.tileScale.x = 2 + Math.sin(count)
      tilingSprite.tileScale.y = 2 + Math.cos(count)

      tilingSprite.tilePosition.x += 1
      tilingSprite.tilePosition.y += 1
    })

    app

  }

}
