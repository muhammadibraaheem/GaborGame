package tutorial.webapp

import org.scalajs.dom
import org.scalajs.dom.document
import org.scalajs.dom.html.Canvas

case class Player (x: Int, y: Int)

object Game {

  def drawShape(context: dom.CanvasRenderingContext2D, player: Player): Unit = {
    context.fillRect(0, 0, context.canvas.width, context.canvas.height )
    context.strokeRect(player.x, player.y, 20, 20)
  }

  def setupKeyEventListener(context: dom.CanvasRenderingContext2D, intialX: Int, initialY: Int) = {

    var player = Player(intialX, initialY)

    def keyListener(e: dom.KeyboardEvent) = {
      println("Da keycode is " + e.keyCode)


      player = e.keyCode match {
        case 38 => Player(player.x, player.y -5)
        case 37 => Player(player.x -5, player.y)
        case 39 => Player(player.x +5, player.y)
        case 40 => Player(player.x, player.y +5)
      }

      drawShape(context, player)

    }

    drawShape(context, player)

    dom.window.addEventListener(
    "keydown", keyListener, false)
  }
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

    setupKeyEventListener(ctx, shapePositionX, shapePositionY)
    ctx

  }
}

