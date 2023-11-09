package com.kt.core.models.impl;

import com.kt.core.models.HeadingModel;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
    adaptables = SlingHttpServletRequest.class,
    adapters = { HeadingModel.class, ComponentExporter.class },
    resourceType = HeadingModelImpl.RESOURCE_TYPE,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(
    name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
    extensions = ExporterConstants.SLING_MODEL_EXTENSION
)
public class HeadingModelImpl implements HeadingModel {

    @ValueMapValue
    private String text;

    static final String RESOURCE_TYPE = "my-kt/components/heading";

    @Override
    public String getText() {
        return StringUtils.isNotBlank(text) ? text : "Default Heading Text";
    }

    @Override
    public String getExportedType() {
        return HeadingModelImpl.RESOURCE_TYPE;
    }
}
