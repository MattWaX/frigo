package com.frigo.frigo.model

class Quantity(
    var value: Float,
    var unit: MUnit
) {
    init {
        value = (if (value < 0.0) 0.0 else value).toFloat()
    }
}
