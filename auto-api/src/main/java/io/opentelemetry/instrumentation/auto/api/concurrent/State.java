/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.instrumentation.auto.api.concurrent;

import io.grpc.Context;
import io.opentelemetry.instrumentation.auto.api.ContextStore;
import java.util.concurrent.atomic.AtomicReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class State {

  private static final Logger log = LoggerFactory.getLogger(State.class);

  public static ContextStore.Factory<State> FACTORY =
      new ContextStore.Factory<State>() {
        @Override
        public State create() {
          return new State();
        }
      };

  private final AtomicReference<Context> parentContextRef = new AtomicReference<>(null);

  private State() {}

  public void setParentContext(Context parentContext) {
    boolean result = parentContextRef.compareAndSet(null, parentContext);
    if (!result && parentContextRef.get() != parentContext) {
      if (log.isDebugEnabled()) {
        log.debug(
            "Failed to set parent context because another parent context is already set {}: new: {}, old: {}",
            this,
            parentContext,
            parentContextRef.get());
      }
    }
  }

  public void clearParentContext() {
    parentContextRef.set(null);
  }

  public Context getAndResetParentContext() {
    return parentContextRef.getAndSet(null);
  }
}
