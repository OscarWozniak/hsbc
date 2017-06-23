package com.owozniak.helpers;

import com.owozniak.entities.Post;

import java.time.LocalDateTime;
import java.util.Comparator;

import static com.owozniak.helpers.DateParser.parseStringToDate;

public class PostsComparators {

    /**
     * @param isReversed if set to false then records are returned chronologicaly
     */
    private static Comparator<Post> getDateDefaultComparator(boolean isReversed) {
        return (left, right) -> {
            LocalDateTime leftDate = parseStringToDate(left.getDate());
            LocalDateTime rightDate = parseStringToDate(right.getDate());

            return (isReversed)
                    ? rightDate.compareTo(leftDate)
                    : leftDate.compareTo(rightDate);
        };
    }

    public static Comparator<Post> getDateChronologicallyReversed() {
        return getDateDefaultComparator(true);
    }

    public static Comparator<Post> getDateChronologically() {
        return getDateDefaultComparator(false);
    }


}