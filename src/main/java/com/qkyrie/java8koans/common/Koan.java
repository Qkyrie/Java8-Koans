package com.qkyrie.java8koans.common;

import java.lang.annotation.*;

/**
 * User: Quinten
 * Date: 27-3-2014
 * Time: 09:49
 *
 * @author Quinten De Swaef
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface Koan {
}
