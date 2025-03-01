package com.example.finalproject001.data

import com.example.finalproject001.R

object DataProvider{
    val product =
        ProductData(1, "CASIO FX-991ES", 1385.00, "High Quality Product", R.drawable.scientific_calculator_casiofx991es)

    val productList = listOf(
        product,
        ProductData(2, "CASIO FX-570MS", 1105.00,"Item 2 Description", R.drawable.scientific_calculator_casiofx570ms),
        ProductData(3, "CASIO FX-82MS", 610.00, "Item 3 Description", R.drawable.scientific_calculator_casiofx82ms),
        ProductData(4, "MONGOL 3 Pencil Exam-Set", 74.00, "Item 4 Description", R.drawable.pencil_mongol3_examset),
        ProductData(5, "MONGOL 3 Pencil 3s", 32.00, "Item 5 Description", R.drawable.pencil_mongol3_3s),
        ProductData(6, "ARTLINE 0.1", 100.00, "Item 6 Description", R.drawable.ballpen_artline_01),
        ProductData(7, "ARTLINE 0.4", 100.00, "Item 7 Description", R.drawable.ballpen_artline_04),
        ProductData(8, "ARTLINE 0.5", 100.00, "Item 8 Description", R.drawable.ballpen_artline_05),
        ProductData(9, "ARTLINE 0.8", 100.00, "Item 9 Description", R.drawable.ballpen_artline_08),
        ProductData(10, "DONG-A Gel Ballpoint Pen (Black)", 100.00, "Item 10 Description", R.drawable.ballpen_donga_gel_black)
    )
}