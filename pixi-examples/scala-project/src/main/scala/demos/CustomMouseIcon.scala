package demos

import pixi.PIXIExample
import pixigraphics.{Application, Sprite, Texture}
import pixigraphics.options.ApplicationOptions

import scala.scalajs.js.UndefOr

object CustomMouseIcon extends PIXIExample {

  val name: String = "Custom mouse icon"

  val pixiUrl: String = "https://pixijs.io/examples/#/demos/custom-mouse-icon.js"

  override def newApplication(): Application = {
    val app = new Application(new ApplicationOptions {
      override val backgroundColor: UndefOr[Int] = 0x1099bb
    })

    //Css style for icons
    val defaultIcon = "url('required/assets/bunny.png'),auto"
    val hoverIcon = "url('required/assets/bunny_saturated.png'),auto"

    //Add custom cursor styles
    app.renderer.plugins.interaction.cursorStyles.default = defaultIcon
    app.renderer.plugins.interaction.cursorStyles.hover = hoverIcon

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

    val buttonPositions = Vector(
      175, 75,
      655, 75,
      410, 325,
      150, 465,
      685, 445
    )

    final class Button(x: Double, y: Double) {

      val button = new Sprite(textureButton)
      button.cursor = "hover"

      button.anchor.set(0.5)
      button.x = x
      button.y = y

      // make the button interactive...
      button.interactive = true

      button
        // Mouse & touch events are normalized into
        // the pointer* events for handling different
        // button events.
        .on("pointerdown", () => onButtonDown())
        .on("pointerup", () => onButtonUp())
        .on("pointerupoutside", () => onButtonUp())
        .on("pointerover", () => onButtonOver())
        .on("pointerout", () => onButtonOut())

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
      app.stage.addChild(button)

      private var isDown: Boolean = false
      private var isOver: Boolean = false


      def onButtonDown(): Unit = {
        isDown = true
        button.texture = textureButtonDown
        button.alpha = 1
      }

      def onButtonUp(): Unit = {
        isDown = false
        if (isOver) {
          button.texture = textureButtonOver
        } else {
          button.texture = textureButton
        }
      }

      def onButtonOver(): Unit = {
        isOver = true
        if (!isDown) {
          button.texture = textureButtonOver
        }
      }

      def onButtonOut(): Unit = {
        isOver = false
        if (!isDown) {
          button.texture = textureButton
        }
      }
    }



    val buttons = for (i <- 0 until 5) yield new Button(buttonPositions(2 * i), buttonPositions(2 * i + 1))

    // set some silly values...
    buttons(0).button.scale.set(1.2)
    buttons(2).button.rotation = Math.PI / 10
    buttons(3).button.scale.set(0.8)
    buttons(4).button.scale.set(0.8,1.2)
    buttons(4).button.rotation = Math.PI


    app
  }

}
