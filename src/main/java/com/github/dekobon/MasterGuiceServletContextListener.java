package com.github.dekobon;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

import javax.servlet.annotation.WebListener;

/**
 * Central starting point for com.talktup.testweb servlet / Guice based application
 *
 * @author Gerard Stannard
 * @since 3.0.0
 */
@WebListener
public class MasterGuiceServletContextListener extends GuiceServletContextListener {
    public MasterGuiceServletContextListener() {
    }

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ExampleModule());
    }
}
