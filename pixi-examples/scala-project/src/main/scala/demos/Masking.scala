package demos

import pixi.PIXIExample
import pixigraphics.interaction.InteractionEvent
import pixigraphics._
import pixigraphics.options.ApplicationOptions

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, |}

case object Masking extends PIXIExample {

  val name: String = "Masking"

  val pixiUrl: String = "https://pixijs.io/examples/#/demos/masking.js"

  def newApplication(): Application = {
    val app = new Application(new ApplicationOptions {
      override val antialias: UndefOr[Boolean] = true
    })

    app.stage.interactive = true

    val bg = Sprite.fromImage("required/assets/BGrotate.jpg")

    bg.anchor.set(0.5)

    bg.x = app.screen.width / 2
    bg.y = app.screen.height / 2

    app.stage.addChild(bg)

    val container = new Container()
    container.x = app.screen.width / 2
    container.y = app.screen.height / 2

    // add a bunch of sprites
    val bgFront = Sprite.fromImage("required/assets/SceneRotate.jpg")
    bgFront.anchor.set(0.5)

    val light2 = Sprite.fromImage("required/assets/LightRotate2.png")
    light2.anchor.set(0.5)

    val light1 = Sprite.fromImage("required/assets/LightRotate1.png")
    light1.anchor.set(0.5)

    val panda =  Sprite.fromImage("required/assets/panda.png")
    panda.anchor.set(0.5)

    container.addChild(bgFront, light2, light1, panda)

    app.stage.addChild(container)

    // let's create a moving shape
    val thing = new Graphics()
    app.stage.addChild(thing)
    thing.x = app.screen.width / 2
    thing.y = app.screen.height / 2
    thing.lineStyle(0)

    container.mask = thing

    var count: Double = 0

    app.stage.on("pointertap", (_: InteractionEvent) => {
      if (container.mask == null) {
        container.mask = thing
      } else {
        container.mask = null
      }
    })

    val help = new Text("Click or tap to turn masking on / off.", new TextStyle(new TextStyleStyle {
      override val fontFamily: js.UndefOr[String] = "Arial"
      override val fontSize: js.UndefOr[String | Int] = 12
      override val fontWeight: js.UndefOr[String] = "bold"
      override val fill: js.UndefOr[String | js.Array[String]] = "white"
    }))
    help.y = app.screen.height - 26
    help.x = 10
    app.stage.addChild(help)

    app.ticker.add((_: Double) => {

      bg.rotation += 0.01
      bgFront.rotation -= 0.01

      light1.rotation += 0.02
      light2.rotation += 0.01

      panda.scale.x = 1 + Math.sin(count) * 0.04
      panda.scale.y = 1 + Math.cos(count) * 0.04

      count += 0.1

      thing.clear()

      thing.beginFill(0x8bc5ff, 0.4)
      thing.moveTo(-120 + Math.sin(count) * 20, -100 + Math.cos(count)* 20)
      thing.lineTo(120 + Math.cos(count) * 20, -100 + Math.sin(count)* 20)
      thing.lineTo(120 + Math.sin(count) * 20, 100 + Math.cos(count)* 20)
      thing.lineTo(-120 + Math.cos(count)* 20, 100 + Math.sin(count)* 20)
      thing.rotation = count * 0.1
    })

    app
  }

}
