package basics

import pixi.PIXIExample
import pixigraphics._
import pixigraphics.extras.AnimatedSprite
import pixigraphics.options.ApplicationOptions

import scala.scalajs.js.Dictionary
import scala.scalajs.js.JSConverters._

case object SpriteSheetAnimation extends PIXIExample {

  val name: String = "SpriteSheet Animation"

  val pixiUrl: String = "https://pixijs.io/examples/#/basics/spritesheet.js"

  def newApplication(): Application = {
    val app = new Application(new ApplicationOptions {})

    PIXI.loader
      .add("required/assets/basics/fighter.json")
      .load(onAssetsLoaded)

    def onAssetsLoaded(loader: Loader, dictionary: Dictionary[Resource]): Unit = {
      // create an array of textures from an image path
      val frames = for (i <- 0 until 30) yield {
        val value = (if (i < 10) "0" else "") + i
        // magically works since the spritesheet was loaded with the pixi loader
        Texture.fromFrame("rollSequence00" + value + ".png")
      }


      // create an AnimatedSprite (brings back memories from the days of Flash, right ?)
      val anim = new AnimatedSprite(frames.toJSArray)

      /*
       * An AnimatedSprite inherits all the properties of a PIXI sprite
       * so you can change its position, its anchor, mask it, etc
       */
      anim.x = app.screen.width / 2
      anim.y = app.screen.height / 2
      anim.anchor.set(0.5)
      anim.animationSpeed = 0.5
      anim.play()

      app.stage.addChild(anim)

      // Animate the rotation
      app.ticker.add((_: Double) => {
        anim.rotation += 0.01
      })
    }

    app
  }

}
