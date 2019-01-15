package demos

import pixi.PIXIExample
import pixigraphics.extras.{AnimatedSprite => PIXIAnimatedSprite}
import pixigraphics.{Application, PIXI, Texture}

import scala.scalajs.js.JSConverters._

case object AnimatedSprite extends PIXIExample {

  val name: String = "AnimatedSprite"

  val pixiUrl: String = "https://pixijs.io/examples/#/demos/animatedsprite-demo.js"

  override def newApplication(): Application = {

    val app = new Application()

    app.stop()

    def onAssetsLoaded(): Unit = {

      // create an array to store the textures
      val explosionTextures = for (j <- 1 until 27) yield {
        Texture.fromFrame(s"Explosion_Sequence_A $j.png")
      }

      for (_ <- 0 until 50) {
        // create an explosion AnimatedSprite
        val explosion = new PIXIAnimatedSprite(explosionTextures.toJSArray)

        explosion.x = Math.random() * app.screen.width
        explosion.y = Math.random() * app.screen.height
        explosion.anchor.set(0.5)
        explosion.rotation = Math.random() * Math.PI
        explosion.scale.set(0.75 + Math.random() * 0.5)
        explosion.gotoAndPlay((Math.random() * 27).toInt)
        app.stage.addChild(explosion)
      }
    }

    PIXI.loader
      .add("spritesheet", "required/assets/mc.json")
      .load((_, _) => onAssetsLoaded())


      // start animating
      app.start()

      app

  }

}
