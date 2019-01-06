package demos

import pixigraphics.{Application, Container, RenderTexture, Sprite}
import pixi.PIXIExample

object DemoRenderTexture extends PIXIExample {

  val name: String = "Render Texture"

  val pixiUrl: String = "https://pixijs.io/examples/#/demos/render-texture-demo.js"

  def newApplication(): Application = {
    val app = new Application()

    // create two render textures... these dynamic textures will be used to draw the scene into itself
    var renderTexture = RenderTexture.create(
      app.screen.width,
      app.screen.height
    )
    var renderTexture2 = RenderTexture.create(
      app.screen.width,
      app.screen.height
    )
    val currentTexture = renderTexture

    // create a new sprite that uses the render texture we created above
    val outputSprite = new Sprite(currentTexture)

    // align the sprite
    outputSprite.x = 400
    outputSprite.y = 300
    outputSprite.anchor.set(0.5)

    // add to stage
    app.stage.addChild(outputSprite)

    val stuffContainer = new Container()

    stuffContainer.x = 400
    stuffContainer.y = 300

    app.stage.addChild(stuffContainer)

    // create an array of image ids..
    val fruits = Vector(
    "required/assets/spinObj_01.png",
    "required/assets/spinObj_02.png",
    "required/assets/spinObj_03.png",
    "required/assets/spinObj_04.png",
    "required/assets/spinObj_05.png",
    "required/assets/spinObj_06.png",
    "required/assets/spinObj_07.png",
    "required/assets/spinObj_08.png"
    )

    // create an array of items
    // now create some items and randomly position them in the stuff container
    val items = for (texture <- List(fruits, fruits, fruits).flatten.take(20)) yield {
      val item = Sprite.fromImage(texture)
      item.x = Math.random() * 400 - 200
      item.y = Math.random() * 400 - 200
      item.anchor.set(0.5)
      stuffContainer.addChild(item)
      item
    }

    // used for spinning!
    var count = 0.0

    def ticking(): Unit = {

      for (item <- items)
        item.rotation += 0.1

      count += 0.01

      // swap the buffers ...
      val temp = renderTexture
      renderTexture = renderTexture2
      renderTexture2 = temp

      // set the new texture
      outputSprite.texture = renderTexture

      // twist this up!
      stuffContainer.rotation -= 0.01
      outputSprite.scale.set(1 + Math.sin(count) * 0.2)

      // render the stage to the texture
      // the 'true' clears the texture before the content is rendered
      app.renderer.render(app.stage, renderTexture2)
    }

    app.ticker.add((_: Double) => ticking())

    app
  }

}
