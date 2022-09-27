package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    lateinit var button0: Button
    lateinit var button00: Button
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var button5: Button
    lateinit var button6: Button
    lateinit var button7: Button
    lateinit var button8: Button
    lateinit var button9: Button
    lateinit var button_ac: Button
    lateinit var button_percent: Button
    lateinit var button_backspace: Button
    lateinit var button_div: Button
    lateinit var button_add: Button
    lateinit var button_sub: Button
    lateinit var button_mul: Button
    lateinit var button_equal: Button
    lateinit var button_dot: Button

    lateinit var input_text_field: EditText
    lateinit var output_text_field: EditText

    var check = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button0 = findViewById(R.id.button0)
        button00 = findViewById(R.id.button00)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        button_ac = findViewById(R.id.button_ac)
        button_mul = findViewById(R.id.button_mul)
        button_div = findViewById(R.id.button_div)
        button_add = findViewById(R.id.button_add)
        button_sub = findViewById(R.id.button_sub)
        button_percent = findViewById(R.id.button_percent)
        button_backspace = findViewById(R.id.button_backspace)
        button_dot = findViewById(R.id.button_dot)
        button_equal = findViewById(R.id.button_equal)

        input_text_field = findViewById(R.id.input_text_field)
        output_text_field = findViewById(R.id.output_text_field)

        input_text_field.movementMethod = ScrollingMovementMethod()
        input_text_field.setActivated(true)
        input_text_field.setPressed(true)

        var text: String


        button1.setOnClickListener {
            text = input_text_field.text.toString()+"1"
            input_text_field.setText(text)
            result(text)
        }

        button2.setOnClickListener {
            text = input_text_field.text.toString()+"2"
            input_text_field.setText(text)
            result(text)
        }

        button3.setOnClickListener {
            text = input_text_field.text.toString()+"3"
            input_text_field.setText(text)
            result(text)
        }

        button4.setOnClickListener {
            text = input_text_field.text.toString()+"4"
            input_text_field.setText(text)
            result(text)
        }

        button5.setOnClickListener {
            text = input_text_field.text.toString()+"5"
            input_text_field.setText(text)
            result(text)
        }

        button6.setOnClickListener {
            text = input_text_field.text.toString()+"6"
            input_text_field.setText(text)
            result(text)
        }

        button7.setOnClickListener {
            text = input_text_field.text.toString()+"7"
            input_text_field.setText(text)
            result(text)
        }

        button8.setOnClickListener {
            text = input_text_field.text.toString()+"8"
            input_text_field.setText(text)
            result(text)
        }

        button9.setOnClickListener {
            text = input_text_field.text.toString()+"9"
            input_text_field.setText(text)
            result(text)
        }

        button0.setOnClickListener {
            text = input_text_field.text.toString()+"0"
            input_text_field.setText(text)
            result(text)
        }

        button00.setOnClickListener {
            text = input_text_field.text.toString()+"00"
            input_text_field.setText(text)
            result(text)
        }

        button_dot.setOnClickListener {
            text = input_text_field.text.toString()+"."
            input_text_field.setText(text)
            result(text)
        }

        // Operations buttons
        button_add.setOnClickListener {
            text = input_text_field.text.toString()+"+"
            input_text_field.setText(text)
            check = check + 1
        }

        button_sub.setOnClickListener {
            text = input_text_field.text.toString()+"-"
            input_text_field.setText(text)
            check = check + 1
        }

        button_mul.setOnClickListener {
            text = input_text_field.text.toString()+"*"
            input_text_field.setText(text)
            check = check + 1
        }

        button_div.setOnClickListener {
            text = input_text_field.text.toString()+"/"
            input_text_field.setText(text)
            check = check + 1
        }

        button_percent.setOnClickListener {
            text = input_text_field.text.toString()+"%"
            input_text_field.setText(text)
            check = check + 1
        }

        button_equal.setOnClickListener {
            text = output_text_field.text.toString()+"+"
            input_text_field.setText(text)
            output_text_field.setText(null)
        }

        button_ac.setOnClickListener {
            input_text_field.setText(null)
            output_text_field.setText(null)
        }

        button_backspace.setOnClickListener {
            var backspace: String?= null
            if (input_text_field.text.length > 0) {
                val stringBuilder: StringBuilder = StringBuilder(input_text_field.text)
                val find = input_text_field.text.toString();
                val find2 = find.last()

                if (find2.equals('+') || find2.equals('-') || find2.equals('*') || find2.equals('/') || find2.equals('%')) {
                    check = check - 1
                }

                stringBuilder.deleteCharAt(input_text_field.text.length - 1)
                backspace = stringBuilder.toString()
                input_text_field.setText(backspace)
                result(backspace)
            }
        }
    }

    private fun result(text: String) {

        val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        try {
            val result: Any = engine.eval(text)
            var mainr = result.toString()
            if (check == 0)
            {
                output_text_field.setText(null)
            }
            else
            {
                output_text_field.setText(mainr)
            }
        }
        catch (e:ScriptException) {
            Log.d("TAG", "ERROR")
        }
    }
}