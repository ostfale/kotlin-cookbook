package de.ostfale.kotlin.meta.annotation

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class ReflectRuntime(val value: Int)

class ReflectionTest {

    @ReflectRuntime(5)
    val reflectTest: Int = 0

    init {
        bindReflectionValue(this)
    }

    private fun bindReflectionValue(target: Any) {
        val declaredFields = target::class.java.declaredFields

        for (field in declaredFields) {
            for (annotation in field.annotations) {
                when (annotation) {
                    is ReflectRuntime -> {
                        field.isAccessible = true
                        field.set(target, annotation.value)
                    }
                }
            }
        }
    }
}


fun main() {
    println("Annotation by Reflection: ${ReflectionTest().reflectTest}")
}