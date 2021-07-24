package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    //dont forget to create emulator and push to git

    fun onClick(view: View) {

        when (view.id) {

            R.id.btn0 -> addNumber("0")
            R.id.btn1 -> addNumber("1")
            R.id.btn2 -> addNumber("2")
            R.id.btn3 -> addNumber("3")
            R.id.btn4 -> addNumber("4")
            R.id.btn5 -> addNumber("5")
            R.id.btn6 -> addNumber("6")
            R.id.btn7 -> addNumber("7")
            R.id.btn8 -> addNumber("8")
            R.id.btn9 -> addNumber("9")
            R.id.btnC -> clear()
            R.id.btnMin -> operator("-")
            R.id.btnZarb -> operator("*")
            R.id.btnTaghsim -> operator("/")
            R.id.btnPlus -> operator("+")
            R.id.btnMosavi -> calculate()

        }

    }

    lateinit var textNumber: TextView
    lateinit var textOperator: TextView
    lateinit var textPrevious: TextView
    var operator_var = ""
    var firstNumber = ""
    var secondNumber = ""

    private fun addNumber(num: String) {

        textNumber = findViewById(R.id.textShow)
        textNumber.append(num)

    }


    private fun operator(op: String) {
        textNumber = findViewById(R.id.textShow)
        textOperator = findViewById(R.id.textOperator)
        textPrevious = findViewById(R.id.textPrevious)
        if (textNumber.text.isEmpty() && firstNumber.isEmpty()) {
            Toast.makeText(this, "مقداری وارد نشده است", Toast.LENGTH_SHORT).show()
            return
        }
        if (operator_var.isEmpty()) {
            operator_var = op
            firstNumber = textNumber.text.toString()
            textPrevious.text = firstNumber
            textNumber.text = ""
            textOperator.text = op
            secondNumber = textNumber.text.toString()
        } else {

            if (firstNumber.isNotEmpty() && textNumber.text.isEmpty()) {
                operator_var = op
                textOperator.text = op
            } else {

                secondNumber = textNumber.text.toString()
                operator_var = op
                textOperator.text = op
                calculate()
            }
        }

    }


    private fun clear() {

        textNumber.text = ""
        textPrevious.text = ""
        textOperator.text = ""
        operator_var = ""
        firstNumber = ""
        secondNumber = ""
    }

    private fun calculate() {
             if (operator_var.isEmpty() && firstNumber.isEmpty() && secondNumber.isEmpty())
            Toast.makeText(this, "مقداری وارد نشده است", Toast.LENGTH_SHORT).show()
        else {
            secondNumber = textNumber.text.toString()
            textNumber = findViewById(R.id.textShow)
            textOperator = findViewById(R.id.textOperator)
            textPrevious = findViewById(R.id.textPrevious)
            var intFirstNumber = firstNumber.toInt()
            var intSecondNumber = secondNumber.toInt()
            var result = ""
            when (operator_var) {

                "+" -> result = "${intFirstNumber + intSecondNumber}"
                "-" -> result = "${intFirstNumber - intSecondNumber}"
                "/" -> result = "${(intFirstNumber / intSecondNumber).toFloat()}"
                "*" -> result = "${intFirstNumber * intSecondNumber}"

            }

            textPrevious.text = "$firstNumber $operator_var $secondNumber = "
            textNumber.text = result
            operator_var = ""
            textOperator.text = ""


        }
    }



}