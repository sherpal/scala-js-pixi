package demos

import pixi.PIXIExample
import pixigraphics.{Application, PIXI, Rectangle, Sprite}

case object BlendModes extends PIXIExample {

  val name: String = "BlendModes"

  val pixiUrl: String = "https://pixijs.io/examples/#/demos/blendmodes.js"

  override def newApplication(): Application = {

    val app = new Application()

    // create a new background sprite
    val background = Sprite.fromImage("required/assets/BGrotate.jpg")
    background.width = app.screen.width
    background.height = app.screen.height
    app.stage.addChild(background)


    val totaldudes = 20

    final class Dude {
      // create a new Sprite that uses the image name that we just generated as its source
      val dude: Sprite = Sprite.fromImage("required/assets/flowerTop.png")

      dude.anchor.set(0.5)

      // set a random scale for the dude
      dude.scale.set(0.8 + Math.random() * 0.3)

      // finally let's set the dude to be at a random position...
      dude.x = Math.floor(Math.random() * app.screen.width)
      dude.y = Math.floor(Math.random() * app.screen.height)

      // The important bit of this example, this is how you change the default blend mode of the sprite
      dude.blendMode = PIXI.BLEND_MODES.ADD


      // create some extra properties that will control movement
      var direction: Double = Math.random() * Math.PI * 2

      // this number will be used to modify the direction of the dude over time
      var turningSpeed: Double = Math.random() - 0.8

      // create a random speed for the dude between 0 - 2
      var speed: Double = 2 + Math.random() * 2

      app.stage.addChild(dude)
    }

    // create an array to store a reference to the dudes
    val dudeArray = for (_ <- 0 until totaldudes) yield new Dude

    // create a bounding box for the little dudes
    val dudeBoundsPadding = 100

    val dudeBounds = new Rectangle(
      -dudeBoundsPadding,
      -dudeBoundsPadding,
      app.screen.width + dudeBoundsPadding * 2,
      app.screen.height + dudeBoundsPadding * 2
    )

    app.ticker.add((_: Double) => {

      // iterate through the dudes and update the positions
      for (dude <- dudeArray) {

        dude.direction += dude.turningSpeed * 0.01
        dude.dude.x += Math.sin(dude.direction) * dude.speed
        dude.dude.y += Math.cos(dude.direction) * dude.speed
        dude.dude.rotation = -dude.direction - Math.PI / 2

        // wrap the dudes by testing their bounds...
        if (dude.dude.x < dudeBounds.x) {
          dude.dude.x += dudeBounds.width
        } else if (dude.dude.x > dudeBounds.x + dudeBounds.width) {
          dude.dude.x -= dudeBounds.width
        }

        if (dude.dude.y < dudeBounds.y) {
          dude.dude.y += dudeBounds.height
        } else if (dude.dude.y > dudeBounds.y + dudeBounds.height) {
          dude.dude.y -= dudeBounds.height
        }
      }
    })

    app
  }

}
