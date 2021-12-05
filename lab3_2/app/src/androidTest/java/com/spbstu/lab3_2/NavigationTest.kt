package com.spbstu.lab3_2

import android.content.pm.ActivityInfo
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.spbstu.lab3_2.activities.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testAbout() {
        launchActivity<MainActivity>()
        openAbout()
        onView(withId(R.id.activity_about))
            .check(matches(isDisplayed()))
    }

    private fun selectFragmentChecker(b: Int) {
        when(b) {
            1->onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
            2->onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
            3->onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        }
    }

    private fun selectAction(b: Int) {
        when(b) {
            1->{
                onView(withId(R.id.bnToFirst)).check(doesNotExist())
                onView(withId(R.id.bnToSecond)).check(matches(isDisplayed()))
                onView(withId(R.id.bnToThird)).check(doesNotExist())}
            2->{
                onView(withId(R.id.bnToFirst)).check(matches(isDisplayed()))
                onView(withId(R.id.bnToSecond)).check(doesNotExist())
                onView(withId(R.id.bnToThird)).check(matches(isDisplayed()))}
            3->{
                onView(withId(R.id.bnToFirst)).check(matches(isDisplayed()))
                onView(withId(R.id.bnToSecond)).check(matches(isDisplayed()))
                onView(withId(R.id.bnToThird)).check(doesNotExist())}
        }
    }



    private fun buttonsAndFragmentsChecker1(){
        selectFragmentChecker(1)
        selectAction(1)
    }

    private fun buttonsAndFragmentsChecker2(){
        selectFragmentChecker(2)
        selectAction(2)
    }

    private fun buttonsAndFragmentsChecker3(){
        selectFragmentChecker(3)
        selectAction(3)
    }

    private fun buttonsAndFragmentsCheckerAbout(){
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        onView(withId(R.id.tvAbout)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(doesNotExist())
    }


    @Test
    fun fragmentFirstTest() {
        buttonsAndFragmentsChecker1()
        //Fragment1 -> fragment2 & back
        onView(withId(R.id.bnToSecond)).perform(click())
        buttonsAndFragmentsChecker2()
        pressBack()
        buttonsAndFragmentsChecker1()
        //Open about
        openAbout()
        buttonsAndFragmentsCheckerAbout()
        //And back
        pressBack()
        buttonsAndFragmentsChecker1()
    }

    @Test
    fun fragmentSecondTest() {
        //Go to second fragment
        onView(withId(R.id.bnToSecond)).perform(click())
        buttonsAndFragmentsChecker2()
        //Go to first & back
        onView(withId(R.id.bnToFirst)).perform(click())
        buttonsAndFragmentsChecker1()
        onView(withId(R.id.bnToSecond)).perform(click())
        buttonsAndFragmentsChecker2()
        //Go to third & back
        onView(withId(R.id.bnToThird)).perform(click())
        buttonsAndFragmentsChecker3()
        pressBack()
        buttonsAndFragmentsChecker2()
        //Go to about & back
        openAbout()
        buttonsAndFragmentsCheckerAbout()
        pressBack()
        buttonsAndFragmentsChecker2()
    }
    @Test
    fun fragmentThirdTest() {
        //Go to third fragment
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        buttonsAndFragmentsChecker3()
        //Go to first & back
        onView(withId(R.id.bnToFirst)).perform(click())
        buttonsAndFragmentsChecker1()
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        buttonsAndFragmentsChecker3()
        //Go to second & back
        onView(withId(R.id.bnToSecond)).perform(click())
        buttonsAndFragmentsChecker2()
        onView(withId(R.id.bnToThird)).perform(click())
        buttonsAndFragmentsChecker3()
        //Go to about & back
        openAbout()
        buttonsAndFragmentsCheckerAbout()
        pressBack()
        buttonsAndFragmentsChecker3()
    }


    @Test
    fun navigationTest() {
        buttonsAndFragmentsChecker1()
        openAbout()
        buttonsAndFragmentsCheckerAbout()
        pressBack()
        onView(withId(R.id.bnToSecond)).perform(click())
        buttonsAndFragmentsChecker2()
        openAbout()
        buttonsAndFragmentsCheckerAbout()
        pressBack()
        onView(withId(R.id.bnToThird)).perform(click())
        buttonsAndFragmentsChecker3()
        openAbout()
        buttonsAndFragmentsCheckerAbout()

    }


    @Test
    fun backStackTest() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToFirst)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToFirst)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToFirst)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToFirst)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        openAbout()
        buttonsAndFragmentsCheckerAbout()
        pressBack()
        buttonsAndFragmentsChecker3()
        pressBack()
        buttonsAndFragmentsChecker2()
        openAbout()
        buttonsAndFragmentsCheckerAbout()
        pressBack()
        pressBack()
        buttonsAndFragmentsChecker1()
        openAbout()
        buttonsAndFragmentsCheckerAbout()
        pressBack()
        try {
            pressBack()
            assert(false)
        } catch (NoActivityResumedException: Exception) {
            assert(true)
        }

    }

    private fun selectFragment(b: Int) {
        when(b) {
            1->buttonsAndFragmentsChecker1()
            2->buttonsAndFragmentsChecker2()
            3->buttonsAndFragmentsChecker3()
            4->buttonsAndFragmentsCheckerAbout()
        }
    }
    private fun checkFragment(a: Int) {
        selectFragment(a)
        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(1000)
        selectFragment(a)
        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        Thread.sleep(1000)
    }

    @Test
    fun checkRotationScreen() {
        checkFragment(1)
        onView(withId(R.id.bnToSecond)).perform(click())
        checkFragment(2)
        onView(withId(R.id.bnToThird)).perform(click())
        checkFragment(3)
        openAbout()
        checkFragment(4)

    }

    @Test
    fun upNavigationTest() {
        buttonsAndFragmentsChecker1()
        openAbout()
        buttonsAndFragmentsCheckerAbout()
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        buttonsAndFragmentsChecker1()
        onView(withId(R.id.bnToSecond)).perform(click())
        buttonsAndFragmentsChecker2()
        openAbout()
        buttonsAndFragmentsCheckerAbout()
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        buttonsAndFragmentsChecker2()
        onView(withId(R.id.bnToThird)).perform(click())
        buttonsAndFragmentsChecker3()
        openAbout()
        buttonsAndFragmentsCheckerAbout()
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        buttonsAndFragmentsChecker3()
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        buttonsAndFragmentsChecker2()
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
        buttonsAndFragmentsChecker1()
        try {
            onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).perform(click())
            assert(false)
        } catch (NoActivityResumedException: Exception) {
            assert(true)
        }
    }


}