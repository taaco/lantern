package com.supertramp.lantern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.supertramp.heapdump.HeapDumper
import java.io.File
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val file = File(externalCacheDir, "oom03.hprof")
//        findViewById<TextView>(R.id.textView)?.postDelayed({
//            thread {
//                HeapDumper.dump(file.absolutePath, true)
//            }
//        }, 3000)
        findViewById<TextView>(R.id.textView)?.setOnClickListener {
            thread {
                HeapDumper.dump(file.absolutePath, true)
                //HeapDumper.forkAndDump(file.absolutePath, true)
            }
            //Toast.makeText(this, "Hello world", Toast.LENGTH_SHORT).show()
        }
        findViewById<TextView>(R.id.button)?.setOnClickListener {
            Toast.makeText(this, "Hello world", Toast.LENGTH_SHORT).show()
        }
    }

}