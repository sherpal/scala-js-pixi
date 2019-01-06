package demos

import pixi.PIXIExample
import pixigraphics.options.ApplicationOptions
import pixigraphics.{Application, Graphics}

import scala.scalajs.js.UndefOr

object DemoGraphics extends PIXIExample {

  val name: String = "Graphics"

  val pixiUrl: String = "https://pixijs.io/examples/#/demos/graphics-demo.js"

  def newApplication(): Application = {
    val app = new Application(new ApplicationOptions {
      override val antialias: UndefOr[Boolean] = true
    })

    app.stage.interactive = true

    val graphics = new Graphics()

    // set a fill and line style
    graphics.beginFill(0xFF3300)
    graphics.lineStyle(10, 0xffd900)

    // draw a shape
    graphics.moveTo(50,50)
    graphics.lineTo(250, 50)
    graphics.lineTo(100, 100)
    graphics.lineTo(250, 220)
    graphics.lineTo(50, 220)
    graphics.lineTo(50, 50)
    graphics.endFill()

    // set a fill and line style again
    graphics.lineStyle(10, 0xFF0000, 0.8)
    graphics.beginFill(0xFF700B)

    // draw a second shape
    graphics.moveTo(210,300)
    graphics.lineTo(450,320)
    graphics.lineTo(570,350)
    graphics.quadraticCurveTo(600, 0, 480,100)
    graphics.lineTo(330,120)
    graphics.lineTo(410,200)
    graphics.lineTo(210,300)
    graphics.endFill()

    // draw a rectangle
    graphics.lineStyle(2, 0x0000FF)
    graphics.drawRect(50, 250, 100, 100)

    // draw a circle
    graphics.lineStyle(0)
    graphics.beginFill(0xFFFF0B, 0.5)
    graphics.drawCircle(470, 200,100)
    graphics.endFill()

    graphics.lineStyle(20, 0x33FF00)
    graphics.moveTo(30,30)
    graphics.lineTo(600, 300)


    app.stage.addChild(graphics)

    // let's create a moving shape
    val thing = new Graphics()
    app.stage.addChild(thing)
    thing.x = 800/2
    thing.y = 600/2

    var count = 0.1

    def onClick(): Unit = {
      graphics.lineStyle(Math.random() * 30, Math.random() * 0xFFFFFF)
      graphics.moveTo(Math.random() * 800, Math.random() * 600)
      graphics.bezierCurveTo(
        Math.random() * 800, Math.random() * 600,
        Math.random() * 800, Math.random() * 600,
        Math.random() * 800, Math.random() * 600
      )
    }
    // Just click on the stage to draw random lines
    app.stage.on("pointertap", () => onClick())

    def ticking(): Unit = {
      count += 0.1

      thing.clear()
      thing.lineStyle(10, 0xff0000)
      thing.beginFill(0xffFF00, 0.5)

      thing.moveTo(-120 + Math.sin(count) * 20, -100 + Math.cos(count)* 20)
      thing.lineTo( 120 + Math.cos(count) * 20, -100 + Math.sin(count)* 20)
      thing.lineTo( 120 + Math.sin(count) * 20, 100 + Math.cos(count)* 20)
      thing.lineTo( -120 + Math.cos(count)* 20, 100 + Math.sin(count)* 20)
      thing.lineTo( -120 + Math.sin(count) * 20, -100 + Math.cos(count)* 20)

      thing.rotation = count * 0.1
    }

    app.ticker.add((_: Double) => ticking())

    app
  }

}
