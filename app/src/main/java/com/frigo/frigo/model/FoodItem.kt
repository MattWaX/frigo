package com.frigo.frigo.model

import kotlinx.datetime.LocalDate

class FoodItem(
    var name: String,
    var quantity: Quantity,
    var type: List<FoodType>,
    var expirationDate: LocalDate
    // metadati
    // immagine
)
