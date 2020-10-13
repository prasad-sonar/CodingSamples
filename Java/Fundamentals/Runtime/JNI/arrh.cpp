#include "ArrayHelper.h"

JNIEXPORT jint JNICALL Java_ArrayHelper_square(JNIEnv* env, jclass ctx, jdoubleArray values)
{
	jint n = env->GetArrayLength(values);
	jdouble* elements = new jdouble[n];
	
	env->GetDoubleArrayRegion(values, 0, n, elements);
	for(int i = 0; i < n; ++i)
		elements[i] *= elements[i];
	env->SetDoubleArrayRegion(values, 0, n, elements);
	delete[] elements;

	return n;
}

