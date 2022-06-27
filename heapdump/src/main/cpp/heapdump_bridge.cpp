#include <jni.h>
#include "xhook.h"

extern "C"
JNIEXPORT jint JNICALL
Java_com_supertramp_heapdump_HeapDumper_suspendAndFork(JNIEnv *env, jclass clazz) {

}

extern "C"
JNIEXPORT void JNICALL
Java_com_supertramp_heapdump_HeapDumper_enableProxy(JNIEnv *env, jclass clazz) {

}

extern "C"
JNIEXPORT void JNICALL
Java_com_supertramp_heapdump_HeapDumper_closeProxy(JNIEnv *env, jclass clazz) {

}

JNIEXPORT jint JNI_OnLoad(JavaVM* vm, void* reserved) {

}