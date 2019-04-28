#include <jni.h>
#include <string>
#include <list>
#include <vector>


extern "C" JNIEXPORT jstring JNICALL
Java_com_example_icpproject2_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_icpproject2_MainActivity_trial(
        JNIEnv *env,
        jobject /* this */) {
    std::string data = "Trial";
    return env->NewStringUTF(data.c_str());
}