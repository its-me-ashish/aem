package com.kt.core.models.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.kt.core.models.IconModel;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.*;

@Model(
    adaptables = SlingHttpServletRequest.class,
    adapters = { IconModel.class, ComponentExporter.class },
    resourceType = IconModelImpl.RESOURCE_TYPE,
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(
    name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
    extensions = ExporterConstants.SLING_MODEL_EXTENSION
)

public class IconModelImpl implements IconModel {
    @ValueMapValue
    private String icon;

    static final String RESOURCE_TYPE = "my-kt/components/icon";


    @Override
    public String getIcon() {
        return StringUtils.isNotBlank(icon) ? icon : "Path";
    }


    @Override
    public String getExportedType() {
        return IconModelImpl.RESOURCE_TYPE;
    }
}
