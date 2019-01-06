package demos

import pixi.PIXIExample
import pixigraphics.mesh.Rope
import pixigraphics.{Application, Container, Point, Texture}

import scala.scalajs.js.JSConverters._

object Strip extends PIXIExample {

  val name: String = "Strip"

  val pixiUrl: String = "https://pixijs.io/examples/#/demos/strip-demo.js"

  def newApplication(): Application = {
    val app = new Application()

    var count = 0.0

    // build a rope!
    val ropeLength = 918 / 20.0

    val points = (for (i <- 0 until 20) yield {
      new Point(i * ropeLength, 0)
    }).toJSArray

    val strip = new Rope(Texture.fromImage("required/assets/snake.png"), points)

    strip.x = -459

    val snakeContainer = new Container()
    snakeContainer.x = 400
    snakeContainer.y = 300

    snakeContainer.scale.set(800 / 1100.0)
    app.stage.addChild(snakeContainer)

    snakeContainer.addChild(strip)

    app.ticker.add((_: Double) => {

      count += 0.1

      // make the snake
      for (i <- points.indices) {
        points(i).y = Math.sin((i * 0.5) + count) * 30
        points(i).x = i * ropeLength + Math.cos((i * 0.3) + count) * 20
      }
    })


    app
  }

}
