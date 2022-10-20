package com.example.calculator

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    private var check = 0

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var text: String

        binding.apply {

            inputTextField.movementMethod = ScrollingMovementMethod()
            inputTextField.isActivated = true
            inputTextField.isPressed = true

            button1.setOnClickListener {
                text = inputTextField.text.toString() + "1"
                inputTextField.setText(text)
                result(text)
            }

            button2.setOnClickListener {
                text = inputTextField.text.toString() + "2"
                inputTextField.setText(text)
                result(text)
            }

            button3.setOnClickListener {
                text = inputTextField.text.toString() + "3"
                inputTextField.setText(text)
                result(text)
            }

            button4.setOnClickListener {
                text = inputTextField.text.toString() + "4"
                inputTextField.setText(text)
                result(text)
            }

            button5.setOnClickListener {
                text = inputTextField.text.toString() + "5"
                inputTextField.setText(text)
                result(text)
            }

            button6.setOnClickListener {
                text = inputTextField.text.toString() + "6"
                inputTextField.setText(text)
                result(text)
            }

            button7.setOnClickListener {
                text = inputTextField.text.toString() + "7"
                inputTextField.setText(text)
                result(text)
            }

            button8.setOnClickListener {
                text = inputTextField.text.toString() + "8"
                inputTextField.setText(text)
                result(text)
            }

            button9.setOnClickListener {
                text = inputTextField.text.toString() + "9"
                inputTextField.setText(text)
                result(text)
            }

            button0.setOnClickListener {
                text = inputTextField.text.toString() + "0"
                inputTextField.setText(text)
                result(text)
            }

            button00.setOnClickListener {
                text = inputTextField.text.toString() + "00"
                inputTextField.setText(text)
                result(text)
            }

            buttonDot.setOnClickListener {
                text = inputTextField.text.toString() + "."
                inputTextField.setText(text)
                result(text)
            }

            // Operations buttons
            buttonAdd.setOnClickListener {
                text = inputTextField.text.toString() + "+"
                inputTextField.setText(text)
                check += 1
            }

            buttonSub.setOnClickListener {
                text = inputTextField.text.toString() + "-"
                inputTextField.setText(text)
                check += 1
            }

            buttonMul.setOnClickListener {
                text = inputTextField.text.toString() + "*"
                inputTextField.setText(text)
                check += 1
            }

            buttonDiv.setOnClickListener {
                text = inputTextField.text.toString() + "/"
                inputTextField.setText(text)
                check += 1
            }

            buttonPercent.setOnClickListener {
                text = inputTextField.text.toString() + "%"
                inputTextField.setText(text)
                check += 1
            }

            buttonEqual.setOnClickListener {
                text = outputTextField.text.toString() + "+"
                inputTextField.setText(text)
                outputTextField.text = null
            }

            buttonAc.setOnClickListener {
                inputTextField.text = null
                outputTextField.text = null
            }

            buttonBackspace.setOnClickListener {
                val backspace: String?
                if (inputTextField.text.isNotEmpty()) {
                    val stringBuilder: StringBuilder = StringBuilder(inputTextField.text)
                    val find = inputTextField.text.toString()
                    val find2 = find.last()

                    if (find2 == '+' || find2 == '-' || find2 == '*' || find2 == '/' || find2 == '%'
                    ) {
                        check -= 1
                    }

                    stringBuilder.deleteCharAt(inputTextField.text.length - 1)
                    backspace = stringBuilder.toString()
                    inputTextField.setText(backspace)
                    result(backspace)
                }
            }
        }
    }

    private fun result(text: String) = with(binding) {

        val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        try {
            val result: Any = engine.eval(text)
            val mainr = result.toString()
            if (check == 0) {
                outputTextField.setText(null)
            } else {
                outputTextField.setText(mainr)
            }
        } catch (e: ScriptException) {
            Log.d("TAG", "ERROR")
        }
    }
}