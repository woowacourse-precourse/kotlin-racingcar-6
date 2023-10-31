package racingcar.model

import net.bytebuddy.pool.TypePool.CacheProvider.Discriminating

class WinnerDiscrimination {
    fun answer(scoreBoard: List<String>, cars: List<String>): MutableList<String> {
        var winnerIndices = Discriminating(scoreBoard)
        var winnerCars = mutableListOf<String>()
        for (selectedIndex in winnerIndices) {
            winnerCars.add(cars[selectedIndex])
        }
        return winnerCars
    }
    fun Discriminating(scoreBoard: List<String>):MutableList<Int>{
        var winnerIndices = mutableListOf<Int>()
        for ((index, score) in scoreBoard.withIndex()) {
            var max = 0
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