package com.example.santaderdevweek.data.local

import com.example.santaderdevweek.data.Cartao
import com.example.santaderdevweek.data.Cliente
import com.example.santaderdevweek.data.Conta

class FakeData() {

    fun getLocalData() : Conta {
        return Conta(
            "9013-1",
            "0436-7",
            "910,02",
            "10.000",
            Cliente("Caio Marin"),
            Cartao("4520-5851-9628-2014")
        )
    }
}