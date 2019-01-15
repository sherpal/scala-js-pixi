package pixi

import org.scalajs.dom
import org.scalajs.dom.html
import org.scalajs.dom.raw.XMLHttpRequest

import scala.scalajs.js.timers.setTimeout

import scala.scalajs.js

object ExampleSelector {

  private val overallContainer: html.Div = dom.document.getElementById("overall-container")
    .asInstanceOf[html.Div]

  private val titleH1: html.Anchor = dom.document.getElementById("title").asInstanceOf[html.Anchor]

  private val codeDiv: html.Div = dom.document.getElementById("code-container").asInstanceOf[html.Div]

  private val canvasContainer: html.Div = dom.document.getElementById("canvas-container")
    .asInstanceOf[html.Div]

  private val pixiUrlLink: html.Anchor = dom.document.getElementById("pixi-url")
    .asInstanceOf[html.Anchor]

  def loadAndDisplayCode(example: PIXIExample, pkg: String): Unit = {
    val request = new XMLHttpRequest

    def display(): Unit = {
      // checking if the page is still the same when we receive the response
      if (titleH1.textContent == example.name & request.readyState == 4 & request.status == 200) {
        val code = request.responseText
        val q = '"'

        codeDiv.innerHTML = s"<pre><code class=${q}scala hljs$q>$code</code></pre>"
        setTimeout(1) {
          dom.window.asInstanceOf[js.Dynamic].hljs.highlightBlock(codeDiv.firstChild.firstChild)
        }
      }
    }

    request.open("GET", example.githubUrl(pkg))
    request.send()

    request.onreadystatechange = (_: dom.Event) => display()
  }

  /**
    * Removes the content of the canvas-container div, and puts a new html.Canvas into it.
    * @return
    */
  def changeCanvas(example: PIXIExample): html.Canvas = {
    val children = canvasContainer.children
    for (idx <- 0 until children.length) canvasContainer.removeChild(children(idx))

    titleH1.textContent = example.name
    pixiUrlLink.href = example.pixiUrl
    canvasContainer.appendChild(example.canvas)
    example.canvas
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
          println(s"Running example ${example.name}")
          example.run(title.toLowerCase)
          overallContainer.style.display = "block"
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
