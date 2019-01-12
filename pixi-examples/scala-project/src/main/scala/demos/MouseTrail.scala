package demos

import pixi.PIXIExample
import pixigraphics.mesh.Rope
import pixigraphics.{Application, PIXI, Point, Texture}
import pixigraphics.options.ApplicationOptions

import scala.collection.mutable
import scala.scalajs.js.UndefOr
import scala.scalajs.js.JSConverters._

object MouseTrail extends PIXIExample {

  val name: String = "Mouse trail"

  val pixiUrl: String = "https://pixijs.io/examples/#/demos/mouse-trail.js"

  def newApplication(): Application = {
    val app = new Application(new ApplicationOptions {
      override val backgroundColor: UndefOr[Int] = 0x1099bb
    })

    //Get the texture for rope.
    val trailTexture = Texture.fromImage("required/assets/trail.png")
    val historyX = mutable.Queue[Double]()
    val historyY = mutable.Queue[Double]()
    //historySize determines how long the trail will be.
    val historySize = 20
    //ropeSize determines how smooth the trail will be.
    val ropeSize = 100

    //Create history array.
    for (_ <- 0 until historySize) {
      historyX += 0
      historyY += 0
    }

    //Create rope points.
     val points = for (_ <- 0 until ropeSize) yield {
      new Point(0,0)
    }

    //Create the rope
    val rope = new Rope(trailTexture, points.toJSArray)

    //Set the blendmode
    rope.blendMode = PIXI.BLEND_MODES.ADD

    app.stage.addChild(rope)

    def ticker(): Unit = {
      // Read mouse points, this could be done also in mousemove/touchmove update.
      // For simplicity it is done here for now.
      // When implemeting this properly, make sure to implement touchmove as interaction plugins mouse might not update
      // on certain devices.
      val mousePosition = app.renderer.plugins.interaction.mouse.global

      //Update the mouse values to history
      historyX.dequeue()
      historyX += mousePosition.x
      historyY.dequeue()
      historyY += mousePosition.y
      //Update the points to correspond with history.
      for (i <- 0 until ropeSize) {
        val p = points(i)

        //Smooth the curve with cubic interpolation to prevent sharp edges.
        val ix = cubicInterpolation( historyX, i.toDouble / ropeSize * historySize)
        val iy = cubicInterpolation( historyY, i.toDouble / ropeSize * historySize)

        p.x = ix
        p.y = iy

      }
    }

    // Listen for animate update
    app.ticker.add((_: Double) => ticker())

    /**
      * Cubic interpolation based on https://github.com/osuushi/Smooth.js
      */
    def clipInput[T](k: Int, arr: Seq[T]): T = arr(math.max(0, math.min(arr.size - 1, k)))

    def getTangent(k: Int, factor: Double, array: Seq[Double]): Double =
      factor * (clipInput(k + 1, array) - clipInput(k - 1, array)) / 2

    def cubicInterpolation(array: Seq[Double], t: Double, tangentFactor: Double = 1): Double = {

      val k = Math.floor(t).toInt
      val m = Seq(getTangent(k, tangentFactor, array), getTangent(k + 1, tangentFactor, array))
      val p = Seq(clipInput(k,array), clipInput(k+1,array))
      val u = t - k
      val t2 = u * u
      val t3 = u * t2
      (2 * t3 - 3 * t2 + 1) * p.head + (t3 - 2 * t2 + u) * m.head + ( -2 * t3 + 3 * t2) * p(1) + (t3 - t2) * m(1)
    }

    app
  }

}
