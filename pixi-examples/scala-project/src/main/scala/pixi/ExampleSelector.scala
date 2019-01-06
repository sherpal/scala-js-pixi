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
    pixiUrlLink.style.display = "block"
    canvasContainer.appendChild(canvas)
    canvas
  }

  private val menu: html.Div = dom.document.getElementById("menu").asInstanceOf[html.Div]

  def makeSection(title: String, examples: List[PIXIExample]): Unit = {
    menu.appendChild({
      val div = dom.document.createElement("div").asInstanceOf[html.Div]
      div.className = "menu-section"

      val exampleContainer = dom.document.createElement("div").asInstanceOf[html.Div]
      exampleContainer.style.display = "none"
      for (example <- examples) {
        val option = dom.document.createElement("div").asInstanceOf[html.Option]
        option.className = "example-option"
        option.textContent = example.name
        option.value = example.name

        option.onclick = (_: dom.MouseEvent) => {
          print(s"Running example ${example.name}")
          example.run()
        }

        exampleContainer.appendChild(option)
      }

      val titleDiv = dom.document.createElement("div").asInstanceOf[html.Div]
      titleDiv.className = "section-header"
      titleDiv.textContent = title
      titleDiv.style.cursor = "pointer"
      titleDiv.onclick = (_: dom.MouseEvent) => {
        if (exampleContainer.style.display == "none")
          exampleContainer.style.display = "block"
        else
          exampleContainer.style.display = "none"
      }

      div.appendChild(titleDiv)
      div.appendChild(exampleContainer)

      div
    })
  }

  def main(args: Array[String]): Unit = {

    PIXIExample.allExamples.foreach({ case (title, examples) => makeSection(title, examples) })

  }

}
