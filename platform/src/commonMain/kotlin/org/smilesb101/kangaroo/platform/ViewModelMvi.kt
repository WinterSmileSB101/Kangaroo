package org.smilesb101.kangaroo.platform

interface ViewModelMvi<in UserIntent : Any> {
    fun execute(intent: UserIntent)
}
