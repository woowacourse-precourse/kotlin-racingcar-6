import camp.nextstep.edu.missionutils.Randoms

object NumCheck {

    fun randomCheck() : Boolean{

        return if(4 <= Randoms.pickNumberInRange(0,9)){
            true
        } else {
            false
        }

    }


}