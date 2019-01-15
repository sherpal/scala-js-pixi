package demos

import pixi.PIXIExample
import pixigraphics.{Application, Point, Sprite}

case object AlphaMask extends PIXIExample {

  val name: String = "Alpha Mask"

  val pixiUrl: String = "https://pixijs.io/examples/#/demos/alpha-mask.js"

  def newApplication(): Application = {
    val app = new Application()

    app.stage.interactive = true

    val bg = Sprite.fromImage("required/assets/bkg.jpg")

    app.stage.addChild(bg)

    val cells = Sprite.fromImage("required/assets/cells.png")

    cells.scale.set(1.5)

    val mask = Sprite.fromImage("required/assets/flowerTop.png")
    mask.anchor.set(0.5)
    mask.x = 310
    mask.y = 190

    cells.mask = mask

    app.stage.addChild(mask, cells)

    val target = new Point()

    def reset(): Unit = {
      target.x = Math.floor(Math.random() * 550)
      target.y = Math.floor(Math.random() * 300)
    }

    reset()

    app.ticker.add((_: Double) => {

      mask.x += (target.x - mask.x) * 0.1
      mask.y += (target.y - mask.y) * 0.1

      if (Math.abs(mask.x - target.x) < 1) {
        reset()
      }
    })

    app
  }

}
