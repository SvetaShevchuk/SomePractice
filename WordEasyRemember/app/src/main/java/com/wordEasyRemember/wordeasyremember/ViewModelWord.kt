package com.wordEasyRemember.wordeasyremember

import java.io.Serializable

data class ViewModelWord(
    var word: String,
    var translation: String,
    var association: String
): Serializable
