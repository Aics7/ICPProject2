#include <jni.h>
#include <string>
#include <list>
#include <vector>


jint akornobin=0;
jint bigbenbin=0;
jint essentialsbin=0;

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_icpproject2_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jboolean JNICALL
Java_com_example_icpproject2_MainActivity_incrementAkornoBin(
        JNIEnv *env,
        jobject /* this */) {
    akornobin++;
    return JNI_TRUE;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_com_example_icpproject2_MainActivity_incrementBigBenBin(
        JNIEnv *env,
        jobject /* this */) {
    bigbenbin++;
    return JNI_TRUE;
}

extern "C" JNIEXPORT jboolean JNICALL
Java_com_example_icpproject2_MainActivity_incrementEssentialsBin(
        JNIEnv *env,
        jobject /* this */) {
    essentialsbin++;
    return JNI_TRUE;
}
extern "C" JNIEXPORT jint JNICALL
Java_com_example_icpproject2_Zoomlion_getEssentialsBin(
        JNIEnv *env,
        jobject /* this */) {
    return essentialsbin;
}
extern "C" JNIEXPORT jint JNICALL
Java_com_example_icpproject2_Zoomlion_getBigbenBin(
        JNIEnv *env,
        jobject /* this */) {
    return bigbenbin;
}
extern "C" JNIEXPORT jint JNICALL
Java_com_example_icpproject2_Zoomlion_getAkornoBin(
        JNIEnv *env,
        jobject /* this */) {
    return akornobin;
}