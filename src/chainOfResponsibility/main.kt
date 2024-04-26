package chainOfResponsibility

import kotlin.random.Random

fun main() {
    val board = Board()
    val winningRuleControl = WinningRuleControl()
    println("Initialize board")
    board.draw()

    while (!board.isFull()) {
        val randomCoordinate = Coordinate.getRandomCoordinate()
        if (board.isCoordinateBlank(randomCoordinate)) {
            board.setMember(randomCoordinate)
            board.draw()
        }
        val result = winningRuleControl.winningControl(board)
        if (result) {
            println("We have a winner!!! ${board.getLastPlayer()}")
            break
        }
    }
}

enum class Character(val value: String) {
    Blank(" "),
    X("X"),
    O("O")
}

data class Player(val character: Character)

data class Coordinate(
    val x: Int,
    val y: Int,
) {
    var char: Character = Character.Blank

    companion object {
        fun getRandomCoordinate(): Coordinate {
            val randomX = Random.nextInt(1, 4)
            val randomY = Random.nextInt(1, 4)
            return Coordinate(randomX, randomY)
        }
    }
}

class Board {
    val members = mutableListOf(
        Coordinate(1, 1),
        Coordinate(1, 2),
        Coordinate(1, 3),
        Coordinate(2, 1),
        Coordinate(2, 2),
        Coordinate(2, 3),
        Coordinate(3, 1),
        Coordinate(3, 2),
        Coordinate(3, 3)
    )

    private val players = listOf(Player(Character.X), Player(Character.O))
    private var lastPlayer: Player = Player(Character.O)

    fun getLastPlayer(): Player {
        return lastPlayer
    }

    fun setMember(coordinate: Coordinate) {
        val player = getPlayer()
        members.first { it.x == coordinate.x && it.y == coordinate.y }.char = player.character
        setLastPlayer(player)
    }

    fun draw() {
        println("-----------------")
        println("[${members[0].char.value} ${members[1].char.value} ${members[2].char.value}]")
        println("[${members[3].char.value} ${members[4].char.value} ${members[5].char.value}]")
        println("[${members[6].char.value} ${members[7].char.value} ${members[8].char.value}]")
    }

    fun isFull(): Boolean {
        return !members.any { c -> c.char.equals(Character.Blank) }
    }

    fun isCoordinateBlank(coordinate: Coordinate): Boolean {
        return members.any { it.x == coordinate.x && it.y == coordinate.y && it.char == Character.Blank }
    }

    private fun setLastPlayer(player: Player) {
        lastPlayer = player
    }

    private fun getPlayer(): Player {
        return players.first { it.character != lastPlayer.character }
    }
}
