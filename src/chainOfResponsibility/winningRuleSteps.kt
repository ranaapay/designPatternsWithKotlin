package chainOfResponsibility

interface IHandler {
    fun setNext(handler: IHandler): IHandler
    fun handle(board: Board): Boolean
}

abstract class AbstractHandler : IHandler {
    var nextHandler: IHandler? = null

    override fun setNext(handler: IHandler): IHandler {
        this.nextHandler = handler

        return handler
    }

    override fun handle(board: Board): Boolean {
        if (this.nextHandler != null) {
            return nextHandler!!.handle(board)
        }
        return false
    }
}

class WinningRuleControl {
    val rowControl = RowControl()
    val columnControl = ColumnControl()
    val diagonalControl = DiagonalControl()

    fun winningControl(board: Board): Boolean {
        rowControl.setNext(columnControl).setNext(diagonalControl)
        return rowControl.handle(board)
    }
}

class RowControl : AbstractHandler() {
    override fun handle(board: Board): Boolean {
        for (i in 1..3) {
            val row = board.members.filter { it.x == i }
            val isSameCharInRaw = row.all { it.char == Character.O } || row.all { it.char == Character.X }
            if (isSameCharInRaw) {
                return true
            }
        }
        return this.nextHandler!!.handle(board)
    }
}

class ColumnControl : AbstractHandler() {
    override fun handle(board: Board): Boolean {
        for (i in 1..3) {
            val column = board.members.filter { it.y == i }
            val isSameCharInColumn = column.all { it.char == Character.X } || column.all { it.char == Character.O }
            if (isSameCharInColumn) {
                return true
            }
        }
        return this.nextHandler!!.handle(board)
    }
}

class DiagonalControl : AbstractHandler() {
    override fun handle(board: Board): Boolean {
        val firstDiagonal =
            board.members.filter { (it.x == 1 && it.y == 1) || (it.x == 2 && it.y == 2) || (it.x == 3 && it.y == 3) }
        val isSameCharInFirstDiagonal = firstDiagonal.all { it.char == Character.X } || firstDiagonal.all { it.char == Character.O }
        val secondDiagonal =
            board.members.filter { (it.x == 1 && it.y == 3) || (it.x == 2 && it.y == 2) || (it.x == 3 && it.y == 1) }
        val isSameCharInSecondDiagonal = secondDiagonal.all { it.char == Character.X } || secondDiagonal.all { it.char == Character.O }
        return isSameCharInFirstDiagonal || isSameCharInSecondDiagonal
    }
}