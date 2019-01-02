# scala-js-pixi

[Scala-js](https://www.scala-js.org/) 
[facade](https://www.scala-js.org/doc/interoperability/facade-types.html)
for
[PixiJS](http://www.pixijs.com/) (v4).

Pixi is an awesome framework for 2D rendering on canvas, using either webgl
or canvas-2d rendering.

This facade allows you to use Pixi from Scala
with Scala-js.

The facade is far from complete. However, adding
missing pieces according to your needs should be
straightforward.

## Documentation

The 
[PixiJS documentation](http://pixijs.download/release/docs/index.html)
is great and there is nothing to be added to it
from here. Source files point to the relevant
documentation web page.

## Examples

Pixi has many
[examples](https://pixijs.io/examples/)
usage of the framework.


You will find the translation of (most of) these
examples in the `pixi-examples` part of the project.


In order to run it, open up a server in the root
directory, and head over
`localhost:[port]/pixi-examples/html`.
You can then select the example you want to see
in action. There's a link to the official PIXI
example. As you can see, most of the changes from
the JavaScript code to the Scala code goes along
the lines:

- copy-paste the JavaScript code
- change PIXI.SomeClass to PIXISomeClass
(will probably change to just ChangeClass)
- changing `var` to `val`
- removing the semi-colon at end of lines
- changing `for` loops into for comprehensions

Adding the canvas to the DOM is made automatically
in
`PIXIExample`.

## Random thoughts

- Until proven otherwise, all classes are final
- We don't wrap PIXI in more convenient Scala
classes, since there're already convenient as is.
The major drawback is that `js.Array` can't be
Scala collections.
