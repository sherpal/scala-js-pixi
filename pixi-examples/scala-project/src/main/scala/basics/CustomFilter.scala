package basics

import pixi.PIXIExample
import pixigraphics._

import scala.scalajs.js

case object CustomFilter extends PIXIExample {

  val name: String = "Custom Filter"

  val pixiUrl: String = "https://pixijs.io/examples/#/basics/custom-filter.js"

  def newApplication(): Application = {
    val app = new Application()

    // Create background image
    val background = Sprite.fromImage("required/assets/bkg-grass.jpg")
    background.width = app.screen.width
    background.height = app.screen.height
    app.stage.addChild(background)

    // Stop application wait for load to finish
    app.stop()

    var filter: Filter = null

    // Handle the load completed
    def onLoaded(loader: Loader, res: js.Dictionary[Resource]): Unit = {

      // Create the new filter, arguments: (vertexShader, framentSource)
      filter = new Filter(null, res("shader").data.asInstanceOf[String])

      // Add the filter
      background.filters = js.Array(filter)

      // Resume application update
      app.start()
    }

    PIXI.loader.add("shader", "required/assets/basics/shader.frag")
      .load(onLoaded)


    // Animate the filter
    app.ticker.add((delta: Double) => {
      filter.uniforms.asInstanceOf[js.Dynamic].customUniform =
        filter.uniforms.asInstanceOf[js.Dynamic].customUniform.asInstanceOf[Double] + 0.04 * delta
    })

    app
  }

}
