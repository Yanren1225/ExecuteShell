package ren.imyan.executeshell

import android.util.Log
import java.io.BufferedReader
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.InputStreamReader

/**
 * @author EndureBlaze/炎忍 https://github.com.EndureBlaze
 * @data 2020-12-08 12:14
 * @website https://imyan.ren
 */
object ExecuteShell {

    private const val TAG = "ExecuteShell"
    private var mIsRoot = false

    /**
     * 判断机器Android是否已经root，即是否获取root权限
     *
     * @return 有 root 返回 true，否则返回 false
     */
    @JvmStatic
    fun isRoot(): Boolean {
        if (!mIsRoot) {
            val ret = execRootShellSilent("su -v")
            mIsRoot = if (ret == -1) {
                Log.i(TAG, "not root!")
                false
            } else {
                Log.i(TAG, "have root!")
                true
            }
        }else{
            Log.i(TAG, "mHaveRoot = true, have root!")
        }
        return mIsRoot
    }

    /**
     * 执行命令并且输出结果
     * @param shell 需要执行的 shell 命令
     * @return 返回执行的结果，如果返回空串则执行失败
     */
    @JvmStatic
    fun execRootShell(shell: String): String {
        val result = StringBuilder()

        val process = Runtime.getRuntime().exec("su")

        DataOutputStream(process.outputStream).use {
            it.writeBytes("$shell\n")
            it.flush()
            it.writeBytes("exit\n")
            it.flush()
        }

        DataInputStream(process.inputStream).use {
            BufferedReader(InputStreamReader(it)).forEachLine {
                result.append(it)
            }
        }

        process.waitFor()

        return result.toString()
    }

    /**
     * 执行命令但不关注结果输出
     * @param shell 需要执行的 shell 命令
     * @return 返回 0 代表执行成功 返回其他数字代表执行失败
     */
    @JvmStatic
    fun execRootShellSilent(shell: String):Int{
        var result = -1;
        val process = Runtime.getRuntime().exec("su")

        DataOutputStream(process.outputStream).use {
            it.writeBytes("$shell\n")
            it.flush()
            it.writeBytes("exit\n")
            it.flush()
        }

        process.waitFor()

        result = process.exitValue()

        return result
    }
}