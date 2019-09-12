package tutorial.webapp

import org.scalajs.dom
import dom.document

import scala.scalajs.js.annotation.JSExportTopLevel


object TutorialApp {
  def main(args: Array[String]): Unit = {

    addParagraph(createParagraph(), "Hello Word")
    Game.initScreen(createParagraph())
    Game
  }

  @JSExportTopLevel("addClickedMessage")
  def addClickedMessage(): Unit = {
    addParagraph(document.body, "You clicked the button!")
  }

  def createParagraph():dom.Node = {
    val p = document.createElement("p")
    document.body.appendChild(p)
    p
  }

  def addParagraph(targetNode: dom.Node, text: String): dom.Node = {
    val textNode = document.createTextNode(text)
    targetNode.appendChild(textNode)
  }

}
