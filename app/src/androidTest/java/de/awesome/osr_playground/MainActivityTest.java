package de.awesome.osr_playground;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public IntentsTestRule<MainActivity> myActivityRule = new IntentsTestRule<MainActivity>(MainActivity.class);


    @Test
    public void calculateMainActivityNumbers() throws Exception {
        onView(withId(R.id.editFirstNumber)).perform(typeText("5"),closeSoftKeyboard());
        onView(withId(R.id.editSecondNumber)).perform(typeText("4"),closeSoftKeyboard());

        onView(withId(R.id.editResult)).check(matches(withText("9")));
    }

    @Test
    public void testSwitchToAboutActivity(){
        onView(withId(R.id.buttonAbout)).perform(click());
        intended(hasComponent(AboutActivity.class.getName()));
    }



}

