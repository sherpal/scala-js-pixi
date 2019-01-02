package pixi

import org.scalajs.dom
import org.scalajs.dom.html

object ExampleSelector {

  private val canvasContainer: html.Div = dom.document.getElementById("canvas-container")
    .asInstanceOf[html.Div]

  private val pixiUrlLink: html.Anchor = dom.document.getElementById("pixi-url")
    .asInstanceOf[html.Anchor]

  /**
    * Removes the content of the canvas-container div, and puts a new html.Canvas into it.
    * @return
    */
  def changeCanvas(canvas: html.Canvas, url: String): html.Canvas = {
    val children = canvasContainer.children
    for (idx <- 0 until children.length) canvasContainer.removeChild(children(idx))

    pixiUrlLink.href = url
    canvasContainer.appendChild(canvas)
    canvas
  }

  private val selector: html.Select = dom.document.getElementById("selector")
    .asInstanceOf[html.Select]

  selector.onchange = (_: dom.Event) => {
    println(s"Running example ${selector.value}.")
    PIXIExample.allExamples.find(_.name == selector.value).get.run()
  }

  def main(args: Array[String]): Unit = {

    PIXIExample.allExamples.foreach {
      example =>
        val option = dom.document.createElement("option")
          .asInstanceOf[html.Option]

        option.textContent = example.name
        option.value = example.name
        selector.appendChild(option)
    }

    selector.onchange(null)

  }

}
