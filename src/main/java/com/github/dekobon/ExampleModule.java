package com.github.dekobon;

import com.google.inject.AbstractModule;
import com.google.inject.servlet.ServletModule;

import javax.inject.Singleton;

public class ExampleModule extends AbstractModule {
    public ExampleModule() {
    }

    @Override
    protected void configure() {
        bind(SharedState.class).in(Singleton.class);
        bind(TestServlet1.class).in(Singleton.class);
        bind(TestServlet2.class).in(Singleton.class);

        ServletModule servletModule = new ServletModule() {
            @Override
            protected void configureServlets() {
                serve("/test1/*").with(TestServlet1.class);
                serve("/test2/*").with(TestServlet2.class);
            }
        };

        install(servletModule);
    }
}
