package com.example.demo;
import android.app.Activity;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

/**
 * UI test for Splash Screen, RecycleView and Adding new data
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activity_rule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void addTest(){
        onView(withId(R.id.main)).check(matches(isDisplayed()));
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()));
        onView(withId(R.id.floatingActionButton)).check(matches(isDisplayed()));
        onView(withId(R.id.floatingActionButton)).perform(click());
        onView(withId(R.id.add_data)).check(matches(isDisplayed()));
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
        onView(withId(R.id.Date)).perform(typeText("2019-02-01"));
        onView(withId(R.id.time)).perform(typeText("22:00"));
        onView(withId(R.id.sis)).perform(typeText("126"));
        onView(withId(R.id.dia)).perform(typeText("62"));
        onView(withId(R.id.hr)).perform(typeText("52"));
        onView(withId(R.id.submit)).check(matches(isDisplayed()));
        onView(withId(R.id.submit)).perform(click());
        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }

    @Test
    public void deleteTest(){
        onView(withId(R.id.main)).check(matches(isDisplayed()));
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()));
        onView(withId(R.id.recyclerView)).perform(click());
        onView(withId(R.id.show)).check(matches(isDisplayed()));
        onView(withId(R.id.delete_button)).check(matches(isDisplayed()));
        onView(withId(R.id.delete_button)).perform(click());
        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }

}
