package com;

import javax.annotation.Nonnull;

public interface RPNCalcInterface {
    String process(@Nonnull String in);
    void clearState();
}
