package demos

import pixi.PIXIExample
import pixigraphics._

import scala.scalajs.js
import scala.scalajs.js.|

object TextureRotate extends PIXIExample {

  val name: String = "Texture Rotate"

  val pixiUrl: String = "https://pixijs.io/examples/#/demos/texture-rotate.js"

  def newApplication(): Application = {
    val app = new Application()

    // create a texture from an image path

    PIXI.loader.add("flowerTop", "required/assets/flowerTop.png")
    PIXI.loader.load((_: Loader, resources: js.Dictionary[Resource]) => {
      val texture = resources("flowerTop").texture.asInstanceOf[Texture]
      init(texture)
    })

    def init(texture: Texture): Unit = {
      // create rotated textures
      val D8 = PIXI.GroupD8
      val textures = texture +: (for (rotate <- 1 until 16) yield {
        val h = if (D8.isVertical(rotate)) texture.frame.width else texture.frame.height
        val w = if (D8.isVertical(rotate)) texture.frame.height else texture.frame.width

        val frame = texture.frame
        val crop = new Rectangle(texture.frame.x, texture.frame.y, w, h)
        val trim = crop
        if (rotate % 2 == 0) {
          new Texture(texture.baseTexture, frame, crop, trim, rotate)
        } else {
          //HACK to avoid exception
          //PIXI doesnt like diamond-shaped UVs, because they are different in canvas and webgl
          val rt = new Texture(texture.baseTexture, frame, crop, trim, rotate - 1)
          rt.rotate += 1
          rt
        }
      }).toList

      val offsetX = app.screen.width / 16 | 0
      val offsetY = app.screen.height / 8 | 0
      val gridW = app.screen.width / 4 | 0
      val gridH = app.screen.height / 5 | 0

      //normal rotations and mirrors
      for (i <- 0 until 16) {
        // create a new Sprite using rotated texture
        val dude = new Sprite(textures(if (i < 8) i * 2 else (i - 8) * 2 + 1))
        dude.scale.x = 0.5
        dude.scale.y = 0.5
        // show it in grid
        dude.x = offsetX + gridW * (i % 4)
        dude.y = offsetY + gridH * (i / 4 | 0)
        app.stage.addChild(dude)
        val text = new Text("rotate = " + dude.texture.rotate, new TextStyle(new TextStyleStyle {
          override val fontFamily: js.UndefOr[String] = "Courier New"
          override val fontSize: js.UndefOr[String | Int] = "12px"
          override val fill: js.UndefOr[String | js.Array[String]] = "white"
          override val align: js.UndefOr[String] = "left"
        }))
        text.x = dude.x
        text.y = dude.y - 20
        app.stage.addChild(text)
      }
    }


    app
  }

}
