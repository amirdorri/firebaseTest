package com.example.goldpriceapp.data.model

data class HomePageModel(
    val channel_id: String,
    val creator_id: String,
    val gerami_seke: GeramiSeke,
    val gold: Gold,
    val gold_18k: Gold18k,
    val gold_24k: Gold18k,
    val gold_mini: GoldMini,
    val nim_seke: NimSeke,
    val palladium: Palladium,
    val platinum: Platinum,
    val rob_seke: RobSeke,
    val seke_bahar: SekeBahar,
    val seke_imami: SekeImami,
    val silver: Silver,
    val silver_999: Silver
)