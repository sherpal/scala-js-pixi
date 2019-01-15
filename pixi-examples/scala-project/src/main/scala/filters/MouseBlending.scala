package filters

import pixi.PIXIExample
import pixigraphics.{Application, Container, Filter => PIXIFilter, Sprite}

import scala.scalajs.js

case object MouseBlending extends PIXIExample {

  val name: String = "Mouse blending"

  val pixiUrl: String = "https://pixijs.io/examples/#/filters/filter-mouse.js"

  def newApplication(): Application = {
    /**
      * This demo contains platform-dependant bug. If you dont use vTextureCoord, it'll be removed by glsl compiler
      * FilterManager will be upset about it. Consider using renderer plugin for it.
      *
      * https://github.com/pixijs/pixi.js/wiki/v4-Creating-Filters#cannot-read-property-location-of-undefined
      */

    val app = new Application()

    // Create background image
    val background = Sprite.fromImage("required/assets/bkg-grass.jpg")
    background.width = app.screen.width
    background.height = app.screen.height
    app.stage.addChild(background)

    val shaderFrag =
      """
        |    precision mediump float;
        |
        |    uniform vec2 mouse;
        |    uniform vec2 resolution;
        |    uniform float time;
        |
        |    void main() {
        |      //pixel coords are inverted in framebuffer
        |      vec2 pixelPos = vec2(gl_FragCoord.x, resolution.y - gl_FragCoord.y);
        |      if (length(mouse - pixelPos) < 25.0) {
        |        gl_FragColor = vec4(1.0, 1.0, 0.0, 1.0) * 0.7; //yellow circle, alpha=0.7
        |      } else {
        |        gl_FragColor = vec4( sin(time), mouse.x/resolution.x, mouse.y/resolution.y, 1) * 0.5; // blend with underlying image, alpha=0.5
        |      }
        |    }
        |
      """.stripMargin


    val container = new Container()
    container.filterArea = app.screen
    app.stage.addChild(container)
    val filter = new PIXIFilter(null, shaderFrag)
    container.filters = js.Array(filter)

    // Animate the filter
    app.ticker.add(() => {
      var v2 = filter.uniforms.mouse.asInstanceOf[js.Array[Double]]
      val global = app.renderer.plugins.interaction.mouse.global
      v2(0) = global.x
      v2(1) = global.y
      filter.uniforms.mouse = v2

      v2 = filter.uniforms.resolution.asInstanceOf[js.Array[Double]]
      v2(0) = app.screen.width
      v2(1) = app.screen.height
      filter.uniforms.resolution = v2
    })

    app
  }

}
