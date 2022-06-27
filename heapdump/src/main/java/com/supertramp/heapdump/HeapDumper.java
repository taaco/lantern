package com.supertramp.heapdump;

import android.os.Debug;

import java.io.IOException;

public class HeapDumper {

    static {
        System.loadLibrary("heapdump");
    }

    /**
     * 堆转储
     * @param strip 是否裁剪hprof文件
     */
    public static void dump(String path, boolean strip) {
        try {
            if (strip) {
                stripDump(path);
            }
            else {
                Debug.dumpHprofData(path);
            }
        }catch (Exception e) {}
    }

    /**
     * 快照裁剪
     * @throws IOException
     */
    private static void stripDump(String path) throws IOException {
        enableProxy();
        Debug.dumpHprofData(path);
        closeProxy();
    }

    /**
     * 在子进程中dump堆内存
     */
    public static void forkAndDump(String path, boolean strip) {
        int pid = suspendAndFork();
        if (pid == 0) {
            dump(path, strip);
        }
    }

    /**
     * fork前挂起所有线程，骗过虚拟机（因为虚拟机dump前需要挂起所有线程 stop the world）
     * @return 返回子进程id
     */
    public native static int suspendAndFork();

    /**
     * 打开写文件代理
     */
    private native static void enableProxy();

    /**
     * 关闭代理
     */
    private native static void closeProxy();

}
