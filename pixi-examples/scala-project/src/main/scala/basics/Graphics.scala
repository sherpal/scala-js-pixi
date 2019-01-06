package basics

import pixi.PIXIExample
import pixigraphics.options.ApplicationOptions
import pixigraphics.{Application, Graphics => PIXIGraphics}

import scala.scalajs.js.UndefOr

object Graphics extends PIXIExample {

  val name: String = "Graphics"

  val pixiUrl: String = "https://pixijs.io/examples/#/basics/graphics.js"

  override def newApplication(): Application = {
    val app = new Application(new ApplicationOptions {
      override val antialias: UndefOr[Boolean] = true
    })

    val graphics = new PIXIGraphics()

    // set a fill and line style
    graphics.beginFill(0xFF3300)
    graphics.lineStyle(4, 0xffd900)

    // draw a shape
    graphics.moveTo(50,50)
    graphics.lineTo(250, 50)
    graphics.lineTo(100, 100)
    graphics.lineTo(50, 50)
    graphics.endFill()

    // set a fill and a line style again and draw a rectangle
    graphics.lineStyle(2, 0x0000FF)
    graphics.beginFill(0xFF700B)
    graphics.drawRect(50, 250, 120, 120)

    // draw a rounded rectangle
    graphics.lineStyle(2, 0xFF00FF)
    graphics.beginFill(0xFF00BB, 0.25)
    graphics.drawRoundedRect(150, 450, 300, 100, 15)
    graphics.endFill()

    // draw a circle, set the lineStyle to zero so the circle doesn't have an outline
    graphics.lineStyle(0.0)
    graphics.beginFill(0xFFFF0B, 0.5)
    graphics.drawCircle(470, 90,60)
    graphics.endFill()

    app.stage.addChild(graphics)

    app
  }

}
