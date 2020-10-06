package io.opentelemetry.javaagent.exporters;

import io.opentelemetry.javaagent.spi.exporter.SpanExporterFactory;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import com.jkoolcloud.tnt4j.source.impl.opentelemetry.TNTSpanExporter;

import java.util.Properties;

public class TNTSpanExporterFactory implements SpanExporterFactory {
    @Override
    public SpanExporter fromConfig(Properties config) {
        return new TNTSpanExporter("agent");

    }
}
