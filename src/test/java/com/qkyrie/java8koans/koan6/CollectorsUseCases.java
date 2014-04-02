package com.qkyrie.java8koans.koan6;

import com.qkyrie.java8koans.common.Koan;

/**
 * User: Quinten
 * Date: 27-3-2014
 * Time: 10:00
 *
 * @author Quinten De Swaef
 */
@Koan
public class CollectorsUseCases {

    /*
     * see Collectors Javadoc
     */
    /**
     * also see the      * <pre>{@code
     *     Person[] men = people.stream()
     *                          .filter(p -> p.getGender() == MALE)
     *                          .toArray(Person[]::new);
     * }</pre>
     */
    //accumulate in list

    //accumulate in treeset

    //convert, and concatenate Collectors.joining(",")

    //compute the sum Collectors.summingInt

    //Group by something into a map

    //compute by grouped: groupingby(group, dosomething)

    //partition into divisions
}
