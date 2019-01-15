package filters

import pixi.PIXIExample
import pixigraphics.filters.BlurFilter
import pixigraphics.{Application, Sprite}

import scala.scalajs.js

case object Blur extends PIXIExample {

  val name: String = "Blur"

  val pixiUrl: String = "https://pixijs.io/examples/#/filters/blur-filter.js"

  def newApplication(): Application = {
    val app = new Application()

    val bg = Sprite.fromImage("required/assets/depth_blur_BG.jpg")
    bg.width = app.screen.width
    bg.height = app.screen.height
    app.stage.addChild(bg)

    val littleDudes = Sprite.fromImage("required/assets/depth_blur_dudes.jpg")
    littleDudes.x = (app.screen.width / 2) - 315
    littleDudes.y = 200
    app.stage.addChild(littleDudes)

    val littleRobot = Sprite.fromImage("required/assets/depth_blur_moby.jpg")
    littleRobot.x = (app.screen.width / 2) - 200
    littleRobot.y = 100
    app.stage.addChild(littleRobot)

    val blurFilter1 = new BlurFilter()
    val blurFilter2 = new BlurFilter()

    littleDudes.filters = js.Array(blurFilter1)
    littleRobot.filters = js.Array(blurFilter2)

    var count = 0.0

    app.ticker.add(() => {

      count += 0.005

      val blurAmount = Math.cos(count)
      val blurAmount2 = Math.sin(count)

      blurFilter1.blur = 20 * blurAmount
      blurFilter2.blur = 20 * blurAmount2
    })

    app
  }

}
