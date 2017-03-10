package io.xephon.proxy.ql.parser;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by at15 on 3/9/17.
 *
 * https://github.com/xephonhq/tsdb-proxy-java/issues/5
 */
public class TrackerErrorListener extends BaseErrorListener {
    private List<SyntaxError> errors;
    private boolean stderrEnabled;

    public TrackerErrorListener() {
        errors = new ArrayList<>();
        stderrEnabled = false;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e)
    {
        if (stderrEnabled) {
            // default behaviour of ANTLR error listener
            System.err.printf("line %d:%d %s", line,charPositionInLine, msg);
        }
        errors.add(new SyntaxError(line, charPositionInLine, msg));
    }

    public void printErrors() {
        System.out.printf("total %d syntax errors\n", errors.size());
        for (SyntaxError error: errors) {
            System.out.println(error);
        }
    }

    public boolean hasError() {
        return errors.size() > 0;
    }

    public void reset() {
        errors = new ArrayList<>();
    }

    public void enableStderr() {
        stderrEnabled = true;
    }

    public void disableStderr() {
        stderrEnabled = false;
    }
}
