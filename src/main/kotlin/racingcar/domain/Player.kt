package racingcar.domain

data class Player(
        val name: String,
        var winCount: Int = 0
) {
    fun addWinCount() {
        winCount++
    }

    companion object {
        fun toPlayer(name: String): Player = Player(name, 0)
    }
}
