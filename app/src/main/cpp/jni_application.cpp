#include <jni.h>

#include <application.h>
#include <vm_manager.h>

extern "C" jint JNI_OnLoad(JavaVM* vm, void* unused) {
    aegis::threadEnv.assignVm(vm);

    aegis::app = std::make_unique<aegis::Application>();
    return aegis::jniVersion;
}
