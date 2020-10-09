/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.javaagent.exporters;

import com.google.auto.service.AutoService;
import com.jkoolcloud.tnt4j.source.impl.opentelemetry.TNTMetricExporter;
import io.opentelemetry.javaagent.spi.exporter.MetricExporterFactory;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import java.util.Properties;

@AutoService(MetricExporterFactory.class)
public class TNTMetricExporterFactory implements MetricExporterFactory {
  @Override
  public MetricExporter fromConfig(Properties config) {
    return new TNTMetricExporter("agent");
  }
}
