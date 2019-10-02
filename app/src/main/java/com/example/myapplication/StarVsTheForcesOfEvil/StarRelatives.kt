package com.example.homework2.StarVsTheForcesOfEvil

import android.content.ContentValues.TAG
import android.util.Log


class StarRelatives(var family: Family, name : String, age: Int)  : Magical{
    override fun useDimensialScissors(dimension: Dimension) {
        super.useDimensialScissors(dimension)
    }
    fun callStar(name: String){
        Log.i( TAG,"Star,$name is calling")

    }

}

