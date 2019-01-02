package basics

import pixi.PIXIExample
import pixigraphics._

import scala.scalajs.js

object RenderTexture extends PIXIExample {

  val name: String = "Render Texture"

  val pixiUrl: String = "https://pixijs.io/examples/#/basics/render-texture.js"

  def newApplication(): Application = {
    val app = new Application(new ApplicationOptions {
      override val backgroundColor: js.UndefOr[Int] = 0x1099bb
    })

    val container = new Container()
    app.stage.addChild(container)

    val texture = Texture.fromImage("required/assets/basics/bunny.png")

    for (i <- 0 until 25) {
      val bunny = new Sprite(texture)
      bunny.x = (i % 5) * 30
      bunny.y = Math.floor(i / 5) * 30
      bunny.rotation = Math.random() * (Math.PI * 2)
      container.addChild(bunny)
    }

    val brt = new BaseRenderTexture(
      300, 300, PIXI.SCALE_MODES.LINEAR, 1
    )
    val rt = new RenderTexture(brt)

    val sprite = new Sprite(rt)

    sprite.x = 450
    sprite.y = 60
    app.stage.addChild(sprite)

    /*
     * All the bunnies are added to the container with the addChild method
     * when you do this, all the bunnies become children of the container, and when a container moves,
     * so do all its children.
     * This gives you a lot of flexibility and makes it easier to position elements on the screen
     */
    container.x = 100
    container.y = 60

    app.ticker.add((_: Double) => {
      app.renderer.render(container, rt)
    })

    app
  }

}
