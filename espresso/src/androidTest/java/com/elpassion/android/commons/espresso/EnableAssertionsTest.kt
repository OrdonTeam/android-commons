package com.elpassion.android.commons.espresso

import android.os.Bundle
import android.support.test.rule.ActivityTestRule
import android.widget.Button
import android.widget.FrameLayout
import org.junit.Rule
import org.junit.Test

class EnableAssertionsTest {

    @JvmField @Rule
    val activityRule = ActivityTestRule(Activity::class.java)

    @Test
    fun shouldConfirmIsEnabled() {
        onId(firstId).isEnabled()
    }

    @Test
    fun shouldConfirmIsDisabled() {
        onId(secondId).isDisabled()
    }

    class Activity : android.app.Activity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(FrameLayout(this).apply {
                addView(Button(this.context).apply {
                    id = firstId
                    isEnabled = true
                })
                addView(Button(this.context).apply {
                    id = secondId
                    isEnabled = false
                })
            })
        }
    }

    companion object {
        private val firstId = 123
        private val secondId = 124
    }
}