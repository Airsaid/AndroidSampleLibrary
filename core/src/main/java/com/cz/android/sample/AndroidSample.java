package com.cz.android.sample;

import android.app.Activity;

import com.cz.android.sample.api.TestCase;
import com.cz.android.sample.api.item.Demonstrable;
import com.cz.android.sample.api.item.RegisterItem;
import com.cz.android.sample.processor.exception.ActionExceptionHandler;

import java.util.List;

/**
 * @author Created by cz
 * @date 2020-01-31 10:03
 * @email bingo110@126.com
 */
public interface AndroidSample<C extends Activity> {
    /**
     * Start a sample.
     * @param context
     * @param demonstrable
     */
    void start(C context, RegisterItem demonstrable);
    
    /**
     * Register an exceptionHandler for action com.cz.android.sample.library.processor
     * @param exceptionHandler
     */
    void registerExceptionHandler(ActionExceptionHandler exceptionHandler);

    /**
     * Return all the demonstrable if is belong to this category
     */
    List<Demonstrable> getDemonstrableList(String category);
    /**
     * Return all the test cases.
     * @see TestCase remark this register sample was the one you want to test
     * @return
     */
    List<RegisterItem> getTestCases();
}
