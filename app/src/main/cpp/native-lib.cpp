#include <jni.h>
#include <string>
#include <iostream>
#include "CarPlateRecgnize.h"

extern "C" JNIEXPORT jstring JNICALL


Java_tina_com_recgnize_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}


extern "C"
JNIEXPORT jstring JNICALL
Java_tina_com_recgnize_MainActivity_recgnizeCar(JNIEnv *env, jobject instance, jstring hogSvmData_,
                                                jstring hogAnnZHData_, jstring hogAnnData_,
                                                jstring imgStr_) {

    const char *hogSvmData = env->GetStringUTFChars(hogSvmData_, 0);
    const char *hogAnnZHData = env->GetStringUTFChars(hogAnnZHData_, 0);
    const char *hogAnnData = env->GetStringUTFChars(hogAnnData_, 0);
    const char *imgStr = env->GetStringUTFChars(imgStr_, 0);

    CarPlateRecgnize p(hogSvmData, hogAnnZHData, hogAnnData);
    Mat src = imread(imgStr);
    std::string reslt = p.plateRecgnize(src);
    cout << p.plateRecgnize(src) << endl;

    env->ReleaseStringUTFChars(hogSvmData_, hogSvmData);
    env->ReleaseStringUTFChars(hogAnnZHData_, hogAnnZHData);
    env->ReleaseStringUTFChars(hogAnnData_, hogAnnData);
    env->ReleaseStringUTFChars(imgStr_, imgStr);

    if (reslt.empty()){
        return env->NewStringUTF(NULL);
    }
    return env->NewStringUTF(reslt.c_str());
}