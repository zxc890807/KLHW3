package com.example.kotlin_hw3

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.klhw3.R

class MainActivity : AppCompatActivity() {
    lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn=findViewById(R.id.button)
        btn.setOnClickListener{
            AlertDialog.Builder(this)
                .setTitle("請選擇功能")
                .setMessage("請根據下方按鈕選擇要顯示的物件")
                .setNeutralButton("取消") { dialog, which ->
                    Toast.makeText(this,"dialog關閉",Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("自訂義Toast"){dialog, which ->
                    showToast()
                }
                .setPositiveButton("顯示List"){dialog, which ->
                    showListDialog()
                }.show()
        }

    }
    private fun showToast()
    {
        val toast = Toast(this)
        toast.setGravity(Gravity.TOP,0,50)
        toast.duration=Toast.LENGTH_SHORT
        toast.view= View.inflate(this,R.layout.custom_toast,null)
        toast.show()
    }

    private fun showListDialog()
    {
        val String=arrayOf("message1","message2","message3","message4","message5")
        AlertDialog.Builder(this)
            .setTitle("使用List呈現")
            .setItems(String){dialogInterface,i->
                Toast.makeText(this,"你選的是"+String[i],Toast.LENGTH_SHORT).show()
            }.show()
    }

}