package tutorial.webapp

import org.scalajs.dom
import org.scalajs.dom.document
import org.scalajs.dom.html.Canvas

object Player {

  def initScreen(targetNode:dom.Node): dom.CanvasRenderingContext2D = {
    val width = 600
    val height = 400
    val shapePositionX = 40
    val shapePositionY = 40

    val canvas = document.createElement("canvas").asInstanceOf[Canvas]
    canvas.width = width
    canvas.height = height

    val ctx = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
    ctx.fillStyle = "#40E0D0"
    ctx.fillRect(0,0,width,height)

    document.createElement("p")
    targetNode.appendChild(canvas)

    def moveShape () = {
      val keyPress = dom.window.addEventListener(
        "keydown", (e: dom.KeyboardEvent) => {
          println("Da keycode is " + e.keyCode)

          e.keyCode match {
            case 38 => {
              shape(shapePositionX, shapePositionY)
              shape(shapePositionX, shapePositionY + 5)
            }
            case 37 => shape(shapePositionX, shapePositionY)
            case 39 => shape(shapePositionX, shapePositionY)
            case 40 => shape(shapePositionX, shapePositionY)
          }
        }, false)
    }

    def shape(x: Int, y: Int, w: Int = 20, d: Int = 20): Unit = {
      val rect = ctx.strokeRect(x,y,w,d)
    }

    shape(shapePositionX, shapePositionY)
    moveShape()
    ctx
  }
}

