package cn.endureblaze.executeshellsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import cn.endureblaze.executeshell.ExecuteShell;

public class ExecuteShellActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //判断是否有root权限
        String is_root_str;
        if (ExecuteShell.haveRoot()) {
            is_root_str = "true";//有权限
        } else {
            is_root_str = "false";//无权限
        }
        TextView is_root = findViewById(R.id.isroot_textView);
        is_root.setText("是否有root权限：" + is_root_str);
        final EditText edit = findViewById(R.id.editText);
        final TextView output_root = findViewById(R.id.output);
        final Button start_btn = findViewById(R.id.start_btn);
        final Button start_output_btn = findViewById(R.id.start_output_btn);
        //需要输出结果
        start_output_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shell_str = edit.getText().toString();
                String return_str = ExecuteShell.execRootShell(shell_str);
                //显示结果
                output_root.setText(return_str);
            }

        });
        //不需要输出结果
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shell_str = edit.getText().toString();
                int return_int = ExecuteShell.execRootShellSilent(shell_str);
                output_root.setText("" + return_int);
            }
        });
    }
}