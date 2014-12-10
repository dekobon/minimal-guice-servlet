package com.github.dekobon;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@Singleton
public class TestServlet1 extends HttpServlet {
    private final SharedState sharedState;

    @Inject
    public TestServlet1(SharedState sharedState) {
        this.sharedState = sharedState;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        Writer writer = resp.getWriter();

        writer.append("Hello World 1\n");
        writer.append(sharedState.toString());
    }
}
