package racingcar.data

import racingcar.ui.repository.RacingCarRepository
import racingcar.util.GameUtils
import kotlin.properties.Delegates

class RacingCarRepositoryImpl : RacingCarRepository {
    private lateinit var carList: List<RacingCarModel>
    private var gameRound by Delegates.notNull<Int>()

    override fun setRounds(round: Int) {
        gameRound = round
    }

    override fun setCarList(list: List<RacingCarModel>) {
        carList = list
    }

    override fun updateRoundState() {
        carList = GameUtils.updateCarsState(carList)
        gameRound--
    }

    override fun checkRemainingRounds(): Boolean {
        return GameUtils.checkRoundEnded(gameRound)
    }

    override fun getState(): List<RacingCarModel> = carList

}