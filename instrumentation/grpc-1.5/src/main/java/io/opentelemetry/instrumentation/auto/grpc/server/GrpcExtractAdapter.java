/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.instrumentation.auto.grpc.server;

import io.grpc.Metadata;
import io.opentelemetry.context.propagation.TextMapPropagator;

public final class GrpcExtractAdapter implements TextMapPropagator.Getter<Metadata> {

  public static final GrpcExtractAdapter GETTER = new GrpcExtractAdapter();

  @Override
  public String get(Metadata carrier, String key) {
    return carrier.get(Metadata.Key.of(key, Metadata.ASCII_STRING_MARSHALLER));
  }
}
