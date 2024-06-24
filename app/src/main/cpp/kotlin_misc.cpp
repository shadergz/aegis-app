#include <jni.h>

jint JNI_OnLoad(JavaVM* vm, void* unused) {
    return JNI_VERSION_1_6;
}
