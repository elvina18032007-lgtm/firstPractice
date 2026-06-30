package com.example.myapplication.practice

/* 5.1
На вход даем:

analyzeIntList(listOf(67, -14, 22, -8, 15))

Что выводит программа
Минимальное: -14
Максимальное: 67
Сумма: 82
Четных: 3
Нечетных: 2*/

/*
5.2
Написать функцию, которая проверяет "силу" пароля. Пароль считается надежным, если:
• Длина не меньше 8 символов
• Содержит хотя бы 1 цифру
• Содержит хотя бы 1 заглавную букву
• Содержит хотя бы 1 прописную букву
• Содержит хотя бы 1 спец. символ

В консоли пишете результат работы программы.
• Если выполняется 5 условий - надежный пароль
• Если выполняется 4 условия - хороший пароль
• Выполняется 2-3 условия - средний пароль
• Менее двух условий - ненадежный

Пример:


На вход даем такой пароль: someTestPassword

Вывод:

Надежность пароля: средняя

*/
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DZ_01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analyzeIntList(listOf(67, -14, 22, -8, 15))
        passwordStrength("someTestPassword")
    }
}
//5.1
fun analyzeIntList(input: List<Int>) {
    // Логика программы
    if (input.isEmpty()) {
        println("Список пуст")
    }

    val min = input.min()
    val max = input.max()
    val sum = input.sum()

    var countEven = 0
    var countOdd  = 0

    for (num in input) {
        if (num % 2 == 0) countEven++
        else countOdd++
    }

    println("""
        TEST-TAG Минимальное: $min
        TEST-TAG Максимальное: $max
        TEST-TAG Сумма: $sum
        TEST-TAG Четных: $countEven
        TEST-TAG Нечетных: $countOdd
    """.trimIndent())
}
//5.2
fun passwordStrength(password : String) {
    var check = 0

    if (password.length >= 8) check++
    for (ch in password) {
        if (ch.isDigit()) {
            check++
            break
        }
    }
    for (ch in password) {
        if (ch.isUpperCase()) {
            check++
            break
        }
    }
    for (ch in password) {
        if (ch.isLowerCase()) {
            check++
            break
        }
    }
    for (ch in password) {
        if (!ch.isLetterOrDigit()) {
            check++
            break
        }
    }

    if (check == 5) println("TEST-TAG надежный")
    if (check == 4) println("TEST-TAG хороший")
    if (check == 3) println("TEST-TAG средний")
    if (check <= 2) println("TEST-TAG ненадежный")
}
