/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.javaagent.exporters;

import com.google.auto.service.AutoService;
import com.jkoolcloud.tnt4j.source.impl.opentelemetry.TNTSpanExporter;
import io.opentelemetry.javaagent.spi.exporter.SpanExporterFactory;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import java.util.Properties;

@AutoService(SpanExporterFactory.class)
public class TNTSpanExporterFactory implements SpanExporterFactory {
  @Override
  public SpanExporter fromConfig(Properties config) {
    return new TNTSpanExporter("agent");
  }
}
