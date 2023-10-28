package racingcar.model

class WinnerDiscrimination {
    fun answer(scoreBoard: List<Int>): MutableList<Int> {
        var index = 0
        var score: Int
        var max = 0
        var winner = mutableListOf<Int>()
        for (score in scoreBoard) {
            if (score > max) {
                max = score
                winner = mutableListOf()
                winner.add(index)
            } else if (score == max) {
                winner.add(index)
            }
            index++
        }
        return winner
    }
}