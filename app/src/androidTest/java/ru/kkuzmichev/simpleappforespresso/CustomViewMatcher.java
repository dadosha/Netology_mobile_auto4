package ru.kkuzmichev.simpleappforespresso;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.matcher.BoundedMatcher;
import org.hamcrest.Description;

public class CustomViewMatcher {
    public static BoundedMatcher<View, RecyclerView> recyclerViewSizeMatcher(final int matcherSize) {
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {

            private String result;

            @Override
            protected boolean matchesSafely(RecyclerView recyclerView) {
                int items = recyclerView.getAdapter().getItemCount();
                result = "List size: " + items;
                return matcherSize == items;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Requested list size: " + matcherSize);
                description.appendText("Actual " + result);
            }
        };
    }
}
