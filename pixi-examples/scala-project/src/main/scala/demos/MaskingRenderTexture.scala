package demos

import pixi.PIXIExample
import pixigraphics._
import pixigraphics.interaction.InteractionEvent

import scala.scalajs.js

object MaskingRenderTexture extends PIXIExample {

  val name: String = "Masking + renderTexture"

  val pixiUrl: String = "https://pixijs.io/examples/#/demos/mask-render-texture.js"

  def newApplication(): Application = {
    // for this example you have to use mouse or touchscreen

    val app = new Application()
    val stage = app.stage

    //prepare circle texture, that will be our brush
    val brush = new Graphics()
    brush.beginFill(0xffffff)
    brush.drawCircle(0, 0, 50)
    brush.endFill()

    def setup(loader: Loader, resources: js.Dictionary[Resource]): Unit = {
      val background = new Sprite(resources("t1").texture)
      stage.addChild(background)
      background.width = app.screen.width
      background.height = app.screen.height

      val imageToReveal = new Sprite(resources("t2").texture)
      stage.addChild(imageToReveal)
      imageToReveal.width = app.screen.width
      imageToReveal.height = app.screen.height

      val renderTexture = RenderTexture.create(app.screen.width, app.screen.height)

      val renderTextureSprite = new Sprite(renderTexture)
      stage.addChild(renderTextureSprite)
      imageToReveal.mask = renderTextureSprite

      var dragging = false

      def pointerMove(event: InteractionEvent): Unit = {
        if (dragging) {
          brush.position.copy(event.data.global)
          app.renderer.render(brush, renderTexture, clear = false)
        }
      }

      def pointerDown(event: InteractionEvent): Unit = {
        dragging = true
        pointerMove(event)
      }

      def pointerUp(event: InteractionEvent): Unit = {
        dragging = false
      }

      app.stage.interactive = true
      app.stage.on("pointerdown", (event: InteractionEvent) => pointerDown(event))
      app.stage.on("pointerup", (event: InteractionEvent) => pointerUp(event))
      app.stage.on("pointermove", (event: InteractionEvent) => pointerMove(event))

    }
    PIXI.loader.add("t1", "required/assets/bkg-grass.jpg")
    PIXI.loader.add("t2", "required/assets/BGrotate.jpg")
    PIXI.loader.load(setup)

    app
  }

}
