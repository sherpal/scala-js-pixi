package demos

import pixi.PIXIExample
import pixigraphics.{Application, Sprite, Texture}

import scala.scalajs.js

object Interactivity extends PIXIExample {

  val name: String = "Interactivity"

  val pixiUrl: String = "https://pixijs.io/examples/#/demos/interactivity.js"

  def newApplication(): Application = {

    val app = new Application()

    // create a background...
    val background = Sprite.fromImage("required/assets/button_test_BG.jpg")
    background.width = app.screen.width
    background.height = app.screen.height

    // add background to stage...
    app.stage.addChild(background)

    // create some textures from an image path
    val textureButton = Texture.fromImage("required/assets/button.png")
    val textureButtonDown = Texture.fromImage("required/assets/buttonDown.png")
    val textureButtonOver = Texture.fromImage("required/assets/buttonOver.png")

    val buttonPositions = js.Array(
      175, 75,
      655, 75,
      410, 325,
      150, 465,
      685, 445
    )


    /**
      * The JavaScript example adds fields to the Sprite dynamically.
      * This is definitely not something that we would do in Scala. Hence, we wrap the sprite into a Button class.
      */
    final class Button(val sprite: Sprite) {
      var isOver: Boolean = false
      var isdown: Boolean = false

      def on(event: String, callback: Button => Unit): Button = {
        sprite.on(event, () => callback(this))
        this
      }
    }

    val buttons = for (i <- 0 until 5) yield {

      val button = new Button(new Sprite(textureButton))
      button.sprite.buttonMode = true

      button.sprite.anchor.set(0.5)
      button.sprite.x = buttonPositions(i * 2)
      button.sprite.y = buttonPositions(i * 2 + 1)

      // make the button interactive...
      button.sprite.interactive = true
      button.sprite.buttonMode = true

      def buttonDown(but: Button): Unit = {
        but.isdown = true
        but.sprite.texture = textureButtonDown
        but.sprite.alpha = 1
      }

      def buttonUp(but: Button): Unit = {
        but.isdown = false
        if (but.isOver) {
          but.sprite.texture = textureButtonOver
        } else {
          but.sprite.texture = textureButton
        }
      }

      def buttonOver(but: Button): Unit = {
        but.isOver = true
        if (!but.isdown) {
          but.sprite.texture = textureButtonOver
        }
      }

      def buttonOut(but: Button): Unit = {
        but.isOver = false
        if (!but.isdown) {
          but.sprite.texture = textureButton
        }
      }

      button
        // Mouse & touch events are normalized into
        // the pointer* events for handling different
        // button events.
        .on("pointerdown", buttonDown)
        .on("pointerup", buttonUp)
        .on("pointerupoutside", buttonUp)
        .on("pointerover", buttonOver)
        .on("pointerout", buttonOut)

      // Use mouse-only events
      // .on('mousedown', onButtonDown)
      // .on('mouseup', onButtonUp)
      // .on('mouseupoutside', onButtonUp)
      // .on('mouseover', onButtonOver)
      // .on('mouseout', onButtonOut)

      // Use touch-only events
      // .on('touchstart', onButtonDown)
      // .on('touchend', onButtonUp)
      // .on('touchendoutside', onButtonUp)


      // add it to the stage
      app.stage.addChild(button.sprite)

      button

    }

    // set some silly values...
    buttons(0).sprite.scale.set(1.2)
    buttons(2).sprite.rotation = Math.PI / 10
    buttons(3).sprite.scale.set(0.8)
    buttons(4).sprite.scale.set(0.8,1.2)
    buttons(4).sprite.rotation = Math.PI

    app

  }

}
