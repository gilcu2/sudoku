

case class Position(x: Int, y: Int)

object Sudoku {

  val board = scala.collection.mutable.ArrayBuffer(
    5, 3, 0, 0, 7, 0, 0, 0, 0,
    6, 0, 0, 1, 9, 5, 0, 0, 0,
    0, 9, 8, 0, 0, 0, 0, 6, 0,
    8, 0, 0, 0, 6, 0, 0, 0, 3,
    4, 0, 0, 8, 0, 3, 0, 0, 1,
    7, 0, 0, 0, 2, 0, 0, 0, 6,
    0, 6, 0, 0, 0, 0, 2, 8, 0,
    0, 0, 0, 4, 1, 9, 0, 0, 5,
    0, 0, 0, 0, 8, 0, 0, 7, 9
  )

  def printBoard:Unit={
    for(i<-0 to 8) {
      val relatedNumbers = (0 to 8).map(j => board(getPositionInArray(j,i)))
      println(relatedNumbers)
    }
  }

  def play(x:Int,y:Int,value:Int):Boolean={
    assert(x>=0 && x<9 && y>=0 && y<9 && value>0 && value<=9)
    if(checkPosition(x,y,value)) {
      board(getPositionInArray(x,y))=value
      true
    } else false
  }

  def checkWin:Boolean= !board.contains(0)


  def checkPosition(x: Int, y: Int, value: Int): Boolean = {
    if (checkPositionAvalaibility(x, y)) {
      val rowCheck = checkRow(x, y, value)
      val colCheck = checkCol(x, y, value)
      val squareCheck = checkSquare(x, y, value)
      rowCheck && colCheck && squareCheck
    }
    else
      false
  }

  def checkRow(x: Int, y: Int, value: Int): Boolean = {
    val avalaibility = checkPositionAvalaibility(x, y)
    val repetition = checkRowRepetition(x, y, value)
    avalaibility && repetition
  }

  def checkRowRepetition(x: Int, y: Int, value: Int) = {
    val relatedNumbers = (0 to 8).map(i => board(getPositionInArray(i, y)))
    !relatedNumbers.contains(value)
  }

  def checkPositionAvalaibility(x: Int, y: Int): Boolean = {
    val position = getPositionInArray(x, y)
    board(position) == 0
  }

  def checkCol(x: Int, y: Int, value: Int): Boolean = {
    val avalaibility = checkPositionAvalaibility(x, y)
    val repetition = checkColRepetition(x, y, value)
    avalaibility && repetition
  }

  def checkColRepetition(x: Int, y: Int, value: Int) = {
    val relatedNumbers = (0 to 8).map(i => board(getPositionInArray(x, i)))
    !relatedNumbers.contains(value)
  }

  def checkSquare(x: Int, y: Int, value: Int): Boolean = {
    checkPositionAvalaibility(x, y) && checkSquareRepetition(x, y, value)
  }

  def checkSquareRepetition(x: Int, y: Int, value: Int): Boolean = {
    val xSquare = x / 3
    val ySquare = y / 3
    var exists = false
    val relatedNumbers = (0 to 2).flatMap(i =>
      (0 to 2).map(j => {
        val posX = xSquare * 3 + i
        val posY = ySquare * 3 + j
        board(getPositionInArray(posX, posY))
      }))
    relatedNumbers.forall(_ != value)
  }

  private def getPositionInArray(x: Int, y: Int) = {
    y * 9 + x
  }

}
