package ren.imyan.executeshellsample

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import ren.imyan.executeshell.ExecuteShell.execRootShell
import ren.imyan.executeshell.ExecuteShell.execRootShellSilent
import ren.imyan.executeshell.ExecuteShell.isRoot

/**
 * @author EndureBlaze/炎忍 https://github.com.EndureBlaze
 * @data 2020-12-08 12:43
 * @website https://imyan.ren
 */
class ExecuteShellActivity : Activity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //判断是否有root权限
        val isRootStr: String = if (isRoot()) {
            "true" //有权限
        } else {
            "false" //无权限
        }
        Toast.makeText(this, isRoot().toString() , Toast.LENGTH_SHORT).show()
        val is_root = findViewById<TextView>(R.id.isroot_textView)
        is_root.text = "是否有root权限：$isRootStr"
        val edit = findViewById<EditText>(R.id.editText)
        val output_root = findViewById<TextView>(R.id.output)
        val start_btn: Button = findViewById(R.id.start_btn)
        val start_output_btn: Button = findViewById(R.id.start_output_btn)
        //需要输出结果
        start_output_btn.setOnClickListener {
            val shell_str = edit.text.toString()
            val return_str = execRootShell(shell_str)
            //显示结果
            output_root.text = return_str
        }

        //不需要输出结果
        start_btn.setOnClickListener {
            val shell_str = edit.text.toString()
            val return_int = execRootShellSilent(shell_str)
            output_root.text = "" + return_int
        }
    }
}