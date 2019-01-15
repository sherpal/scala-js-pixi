package demos

import pixi.PIXIExample
import pixigraphics.{Application, ParticleContainerProperties, Rectangle, Sprite, Text, TextStyle, TextStyleStyle, WebGLRenderer, ParticleContainer => PIXIParticleContainer}

import scala.scalajs.js
import scala.scalajs.js.|

case object ParticleContainer extends PIXIExample {

  val name: String = "Particle Container"

  val pixiUrl: String = "https://pixijs.io/examples/#/demos/batch.js"

  def newApplication(): Application = {
    val app = new Application()
    val sprites = new PIXIParticleContainer(10000, new ParticleContainerProperties {
      override val scale: js.UndefOr[Boolean] = true
      override val position: js.UndefOr[Boolean] = true
      override val rotation: js.UndefOr[Boolean] = true
      override val uvs: js.UndefOr[Boolean] = true
      override val alpha: js.UndefOr[Boolean] = true
    })
    app.stage.addChild(sprites)

    val totalSprites = if (app.renderer.isInstanceOf[WebGLRenderer]) 10000 else  100

    final class Maggot {

      // create a new Sprite
      val dude: Sprite = Sprite.fromImage("required/assets/tinyMaggot.png")

      dude.tint = Math.random() * 0xE8D4CD

      // set the anchor point so the texture is centerd on the sprite
      dude.anchor.set(0.5)

      // different maggots, different sizes
      dude.scale.set(0.8 + Math.random() * 0.3)

      // scatter them all
      dude.x = Math.random() * app.screen.width
      dude.y = Math.random() * app.screen.height

      dude.tint = Math.random() * 0x808080

      // create a random direction in radians
      var direction: Double = Math.random() * Math.PI * 2

      // this number will be used to modify the direction of the sprite over time
      val turningSpeed: Double = Math.random() - 0.8

      // create a random speed between 0 - 2, and these maggots are slooww
      val speed: Double = (2 + Math.random() * 2) * 0.2

      val offset: Double = Math.random() * 100

      sprites.addChild(dude)
    }

    val maggots = (0 until totalSprites).map(_ => new Maggot)

    // create a bounding box box for the little maggots
    val dudeBoundsPadding = 100
    val dudeBounds = new Rectangle(
      -dudeBoundsPadding,
      -dudeBoundsPadding,
      app.screen.width + dudeBoundsPadding * 2,
      app.screen.height + dudeBoundsPadding * 2
    )

    var tick = 0.0

    val fpsText = new Text("FPS: ", new TextStyle(new TextStyleStyle {
      override val fill: js.UndefOr[String | js.Array[String]] = "#ffffff"
    }))
    app.stage.addChild(fpsText)
    fpsText.x = 10
    fpsText.y = 10

    app.ticker.add((_: Double) => {

      fpsText.text = s"FPS: ${app.ticker.FPS.round}"

      // iterate through the sprites and update their position
      for (maggot <- maggots) {

        val dude = maggot.dude
        dude.scale.y = 0.95 + Math.sin(tick + maggot.offset) * 0.05
        maggot.direction += maggot.turningSpeed * 0.01
        dude.x += Math.sin(maggot.direction) * (maggot.speed * dude.scale.y)
        dude.y += Math.cos(maggot.direction) * (maggot.speed * dude.scale.y)
        dude.rotation = -maggot.direction + Math.PI

        // wrap the maggots
        if (dude.x < dudeBounds.x) {
          dude.x += dudeBounds.width
        } else if (dude.x > dudeBounds.x + dudeBounds.width) {
          dude.x -= dudeBounds.width
        }

        if (dude.y < dudeBounds.y) {
          dude.y += dudeBounds.height
        } else if (dude.y > dudeBounds.y + dudeBounds.height) {
          dude.y -= dudeBounds.height
        }
      }

      // increment the ticker
      tick += 0.1
    })

    app
  }

}
