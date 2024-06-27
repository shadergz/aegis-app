#include <jni.h>

#include <application.h>
#include <vm_manager.h>

extern "C"
JNIEXPORT jboolean JNICALL
Java_com_emu_aegis_ExternalFunctions_00024Companion_verifyInternalStorage(
    JNIEnv* env, jobject thiz, jstring cache_dir) {
    bool isVerified;
    aegis::KtString appPath{cache_dir};
    aegis::fs::path pathFromApp{appPath.internal};

    aegis::app->testAndTouchDirectories(pathFromApp, isVerified);
    return isVerified;
}