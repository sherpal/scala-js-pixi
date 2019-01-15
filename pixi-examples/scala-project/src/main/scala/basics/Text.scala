package basics

import pixi.PIXIExample
import pixigraphics._
import pixigraphics.options.ApplicationOptions

import scala.scalajs.js
import scala.scalajs.js.|

case object Text extends PIXIExample {

  val name: String = "Text"

  val pixiUrl: String = "https://pixijs.io/examples/#/basics/text.js"

  override def newApplication(): Application = {
    val app = new Application(new ApplicationOptions {
      override val backgroundColor: js.UndefOr[Int] = 0x1099bb
    })

    val basicText = new Text("Basic text in pixi")
    basicText.x = 30
    basicText.y = 90

    app.stage.addChild(basicText)

    val style = new TextStyle(new TextStyleStyle {
      override val fontFamily: js.UndefOr[String] = "Arial"
      override val fontSize: js.UndefOr[String | Int] = 36
      override val fontStyle: js.UndefOr[String] = "italic"
      override val fontWeight: js.UndefOr[String] = "bold"
      override val fill: js.UndefOr[String | js.Array[String]] = js.Array("#ffffff", "#00ff99") // gradient
      override val stroke: js.UndefOr[String] = "#4a1850"
      override val strokeThickness: js.UndefOr[Int] = 5
      override val dropShadow: js.UndefOr[Boolean] = true
      override val dropShadowColor: js.UndefOr[String] = "#000000"
      override val dropShadowBlur: js.UndefOr[Int] = 4
      override val dropShadowAngle: js.UndefOr[Double] = Math.PI / 6
      override val dropShadowDistance: js.UndefOr[Int] = 6
      override val wordWrap: js.UndefOr[Boolean] = true
      override val wordWrapWidth: js.UndefOr[Int] = 440
    })

    val richText = new Text("Rich text with a lot of options and across multiple lines", style)
    richText.x = 30
    richText.y = 180

    app.stage.addChild(richText)

    app
  }

}
