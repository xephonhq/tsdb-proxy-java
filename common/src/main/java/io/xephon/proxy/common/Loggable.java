package io.xephon.proxy.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by at15 on 3/6/17.
 *
 * @TODO: will this introduce much overhead
 * https://opencredo.com/traits-java-8-default-methods/
 */
public interface Loggable {
    default Logger logger() {
        return LogManager.getLogger(this.getClass());
    }
}
