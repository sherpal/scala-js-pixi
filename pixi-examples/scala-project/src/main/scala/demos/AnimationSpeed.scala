package demos

import pixi.PIXIExample
import pixigraphics.extras.{AnimatedSprite => PIXIAnimatedSprite}
import pixigraphics._
import pixigraphics.objects.FrameObject

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

object AnimationSpeed extends PIXIExample {

  val name: String = "AnimationSpeed"

  val pixiUrl: String = "https://pixijs.io/examples/#/demos/animatedsprite-animationspeed.js"

  def newApplication(): Application = {
    val app = new Application()

    app.stop()

    trait ImageInfo extends js.Object {
      val duration: Int
    }

    trait ResourceData extends js.Object {
      val frames: js.Dictionary[ImageInfo]
    }

    def onAssetsLoaded(loader: Loader, resources: js.Dictionary[Resource]) {

      // create an array to store the textures
      val textures = for (i <- 0 until 10) yield {
        val framekey = s"0123456789 $i.ase"
        val tex = Texture.fromFrame(framekey)
        val t = resources("spritesheet2").data
          .asInstanceOf[ResourceData].frames(framekey).duration

        new FrameObject {
          override val texture: Texture = tex
          override val time: Double = t
        }
      }

      val scaling = 4

      // create a slow AnimatedSprite
      val slow = new PIXIAnimatedSprite(textures.toJSArray)
      slow.anchor.set(0.5)
      slow.scale.set(scaling)
      slow.animationSpeed = 0.5
      slow.x = (app.screen.width - slow.width) / 2
      slow.y = app.screen.height / 2
      slow.play()
      app.stage.addChild(slow)

      // create a fast AnimatedSprite
      val fast = new PIXIAnimatedSprite(textures.toJSArray)
      fast.anchor.set(0.5)
      fast.scale.set(scaling)
      fast.x = (app.screen.width + fast.width) / 2
      fast.y = app.screen.height / 2
      fast.play()
      app.stage.addChild(fast)

      // start animating
      app.start()
    }

    PIXI.loader
      .add("spritesheet2", "required/assets/0123456789.json")
      .load(onAssetsLoaded)

    app

  }

}
