#pragma once

#include <jni.h>
#include <filesystem>
namespace aegis {
    constexpr jint jniVersion{JNI_VERSION_1_6};

    struct KtString {
        explicit KtString(jstring kotlinStr, bool copy = false);

        std::string internal;
        jstring outside;
    };

    class JniAndroidEnv {
    public:
        JniAndroidEnv() :
            native() {
            if (kVm)
                getEnvFromVm();
        }
        void getEnvFromVm();
        auto operator->() {
            return native;
        }

        void assignVm(JavaVM* jvm) {
            kVm = jvm;
            getEnvFromVm();
        }
    private:
        inline static JavaVM* kVm;
        JNIEnv* native;
    };

    extern thread_local JniAndroidEnv threadEnv;
}