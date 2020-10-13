#include "LegacyTaxPayer.h"
#include "taxation.h"

JNIEXPORT jdouble JNICALL Java_LegacyTaxPayer_getIncomeTax(JNIEnv* env, jobject ctx, jshort age)
{
	jclass cls = env->GetObjectClass(ctx);
	jfieldID idIncome = env->GetFieldID(cls, "income", "D");
	jdouble income = env->GetDoubleField(ctx, idIncome);
	jmethodID idValidate = env->GetMethodID(cls, "validate", "(S)Z");
	jboolean valid = env->CallBooleanMethod(ctx, idValidate, age);

	if(valid == JNI_FALSE){
		jclass ex = env->FindClass("java/lang/IllegalArgumentException");
		env->ThrowNew(ex, "Invalid age");
		return 0;
	}

	Taxation::TaxPayer tp(age);

	return tp.IncomeTax(income);
}


