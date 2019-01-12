package filters

import pixi.PIXIExample
import pixigraphics.filters.ColorMatrixFilter
import pixigraphics._

import scala.scalajs.js
import scala.scalajs.js.|

object Filter extends PIXIExample {

  val name: String = "Filter"

  val pixiUrl: String = "https://pixijs.io/examples/#/filters/filter.js"

  def newApplication(): Application = {
    val app = new Application()

    app.stage.interactive = true

    val bg = Sprite.fromImage("required/assets/BGrotate.jpg")
    bg.anchor.set(0.5)

    bg.x = app.screen.width / 2
    bg.y = app.screen.height / 2

    val filter = new ColorMatrixFilter()

    val container = new Container()
    container.x = app.screen.width / 2
    container.y = app.screen.height / 2

    val bgFront = Sprite.fromImage("required/assets/SceneRotate.jpg")
    bgFront.anchor.set(0.5)

    container.addChild(bgFront)

    val light2 = Sprite.fromImage("required/assets/LightRotate2.png")
    light2.anchor.set(0.5)
    container.addChild(light2)

    val light1 = Sprite.fromImage("required/assets/LightRotate1.png")
    light1.anchor.set(0.5)
    container.addChild(light1)

    val panda =  Sprite.fromImage("required/assets/panda.png")
    panda.anchor.set(0.5)

    container.addChild(panda)

    app.stage.addChild(container)

    app.stage.filters = js.Array(filter)

    var count = 0.0
    var enabled = true

    app.stage.on("pointertap", () => {
      enabled = !enabled
      app.stage.filters = if (enabled) js.Array(filter) else null
    })

    val help = new Text("Click or tap to turn filters on / off.", new TextStyle(new TextStyleStyle {
      override val fontFamily: js.UndefOr[String] = "Arial"
      override val fontSize: js.UndefOr[String | Int] = 12
      override val fontWeight: js.UndefOr[String] = "bold"
      override val fill: js.UndefOr[String | js.Array[String]] = "white"
    }))

    help.y = app.screen.height - 25
    help.x = 10

    app.stage.addChild(help)

    def ticker(): Unit = {
      bg.rotation += 0.01
      bgFront.rotation -= 0.01
      light1.rotation += 0.02
      light2.rotation += 0.01

      panda.scale.x = 1 + Math.sin(count) * 0.04
      panda.scale.y = 1 + Math.cos(count) * 0.04

      count += 0.1

      val matrix = filter.matrix

      matrix(1) = Math.sin(count) * 3
      matrix(2) = Math.cos(count)
      matrix(3) = Math.cos(count) * 1.5
      matrix(4) = Math.sin(count / 3) * 2
      matrix(5) = Math.sin(count / 2)
      matrix(6) = Math.sin(count / 4)
    }

    app.ticker.add(() => ticker())


    app
  }

}
