/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.ybq.android.spinkit.animation

import android.util.Property

/**
 * An implementation of [android.util.Property] to be used specifically with fields of type
 * `int`. This type-specific subclass enables performance benefit by allowing
 * calls to a [set()][.set] function that takes the primitive
 * `int` type and avoids autoboxing and other overhead associated with the
 * `Integer` class.
 *
 * @param <T> The class on which the Property is declared.
</T> */
abstract class IntProperty<T>(name: String) : Property<T, Int>(Int::class.java, name) {

    /**
     * A type-specific override of the [.set] that is faster when dealing
     * with fields of type `int`.
     */
    abstract fun setValue(target: T, value: Int)

    override fun set(target: T, value: Int) {
        setValue(target, value)
    }
}
