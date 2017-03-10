package io.xephon.proxy.ql.parser;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by at15 on 3/9/17.
 */
public class ReikaParserTest {
    @Test
    public void testTracerErrorListener() throws IOException {
        ReikaParser parser = Util.parserFromResource("error_syntax.reika");
//        parser.prog();
        parser.removeErrorListeners();
        TrackerErrorListener tracker = new TrackerErrorListener();
        tracker.enableStderr();
        parser.addErrorListener(tracker);
        parser.prog();
        assertTrue(tracker.hasError());
        tracker.printErrors();
    }
}
