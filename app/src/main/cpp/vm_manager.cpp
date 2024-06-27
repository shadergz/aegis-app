#include <vm_manager.h>

namespace aegis {
    thread_local JniAndroidEnv threadEnv;

    void JniAndroidEnv::getEnvFromVm() {
        void* env;
        jint attach{};
        attach = kVm->GetEnv(&env, JNI_VERSION_1_6);
        if (attach != 0 && !env) {
            attach = kVm->AttachCurrentThread(
                reinterpret_cast<JNIEnv**>(&env), nullptr);
        }
        native = reinterpret_cast<JNIEnv*>(env);
    }

    KtString::KtString(jstring kotlinStr, bool copy) {
        if (threadEnv->IsSameObject(kotlinStr, nullptr)) {
            return;
        }
        if (copy) {
            outside = reinterpret_cast<jstring>(
                threadEnv->NewLocalRef(kotlinStr));
            internal = threadEnv->GetStringUTFChars(outside, nullptr);
            return;
        }
        internal = threadEnv->GetStringUTFChars(kotlinStr, nullptr);
    }
}
