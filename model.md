FoodItem {
    name
    quantity
    unit mes
    exp. date
    categoria {}
}

FoodPantry {
    name
    type :enum (puramente estetica)
}

Recipe {
    name
    servings
    FoodItem[] // variazioni
    Passaggio[] :String
}

Calendario {
    // array di giorni che associa le ricette
}
