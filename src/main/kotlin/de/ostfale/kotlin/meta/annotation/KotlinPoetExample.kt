package de.ostfale.kotlin.meta.annotation

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.FIELD)
annotation class GenerateSource(val value: Int)

