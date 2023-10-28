package racingcar.model

class CarProgress {
    fun progress(carNums:Int):List<Int>{
        val carProgress:MutableList<Int> = mutableListOf()
        for (i in 0..carNums){
            carProgress.add(0)
        }
        return carProgress
    }
}