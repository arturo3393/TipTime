package com.google.tiptime

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorTest {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_20_percent_tip_rounded(){
        Espresso.onView(withId(R.id.cost_of_service_edit_text))
            .perform(ViewActions.typeText("50.00"))


        Espresso.onView(withId(R.id.calculate_button))
            .perform(click())

        Espresso.onView(withId(R.id.tip_result))
            .check(ViewAssertions.matches(withText(CoreMatchers.containsString("10.00"))))
    }

    @Test
    fun calculate_18_percent_tip_rounded(){
        Espresso.onView(withId(R.id.cost_of_service_edit_text))
            .perform(ViewActions.typeText("50.00"))

        onView(withId(R.id.option_eighteen_percent))
            .perform(click())

        Espresso.onView(withId(R.id.calculate_button))
            .perform(click())

        Espresso.onView(withId(R.id.tip_result))
            .check(ViewAssertions.matches(withText(CoreMatchers.containsString("9"))))
    }

    @Test
    fun calculate_15_percent_tip_rounded(){
        Espresso.onView(withId(R.id.cost_of_service_edit_text))
            .perform(ViewActions.typeText("50.00"))

        onView(withId(R.id.option_fifteen_percent))
            .perform(click())

        Espresso.onView(withId(R.id.calculate_button))
            .perform(click())

        Espresso.onView(withId(R.id.tip_result))
            .check(ViewAssertions.matches(withText(CoreMatchers.containsString("8"))))
    }
    @Test
    fun calculate_15_percent_tip(){
        Espresso.onView(withId(R.id.cost_of_service_edit_text))
            .perform(ViewActions.typeText("50.00"))

        onView(withId(R.id.option_fifteen_percent))
            .perform(click())


        Espresso.onView(withId(R.id.round_up_switch))
            .perform(click())

        Espresso.onView(withId(R.id.calculate_button))
            .perform(click())

        Espresso.onView(withId(R.id.tip_result))
            .check(ViewAssertions.matches(withText(CoreMatchers.containsString("7.5"))))
    }

}