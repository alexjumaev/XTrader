package com.sedsoftware.core.presentation.custom.animation

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import java.util.LinkedList
import java.util.Queue

open class ViewStateTransitionAnimator : FrameLayout, ViewStateTransition.Callback {

    companion object {
        const val ANIMATION_DURATION = 750L
    }

    private val animationsQueue: Queue<ViewStateTransition> = LinkedList()
    private var isAnimationRunning: Boolean = false

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    fun perform(transition: ViewStateTransition) {
        animationsQueue.add(transition)
        if (!isAnimationRunning) {
            isAnimationRunning = true
            startNextQueuedAnimation()
        }
    }

    override fun completed() {
        startNextQueuedAnimation()
    }

    private fun startNextQueuedAnimation() {
        if (animationsQueue.isNotEmpty()) {
            animationsQueue.poll().run(this)
        } else {
            isAnimationRunning = false
        }
    }
}
