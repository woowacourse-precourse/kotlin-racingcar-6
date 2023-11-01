package racingcar.model

class Winner {
    fun discriminate(scoreBoard: List<String>, cars: List<String>): MutableList<String> {
        val winnerIndices = indexing(scoreBoard)
        val winnerCars = mutableListOf<String>()
        for (selectedIndex in winnerIndices) {
            winnerCars.add(cars[selectedIndex])
        }
        return winnerCars
    }

    private fun indexing(scoreBoard: List<String>): MutableList<Int> {
        var winnerIndices = mutableListOf<Int>()
        var max = 0
        for ((index, score) in scoreBoard.withIndex()) {
            if (score.length > max) {
                max = score.length
                winnerIndices = mutableListOf(index)
            } else if (score.length == max) {
                winnerIndices.add(index)
            }
        }
        return winnerIndices
    }
}