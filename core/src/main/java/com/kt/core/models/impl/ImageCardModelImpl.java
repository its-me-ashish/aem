package com.kt.core.models.impl;
import com.kt.core.models.ImageCardModel;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.models.Image;
import org.apache.sling.models.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.via.ResourceSuperType;

@Model(adaptables = SlingHttpServletRequest.class, adapters = { ImageCardModel.class,
        ComponentExporter.class }, resourceType = ImageCardModelImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)

public class ImageCardModelImpl implements ImageCardModel {
    static final String RESOURCE_TYPE = "my-kt/components/imagecard";


    @ValueMapValue
    private String text;

    @Self
    private SlingHttpServletRequest request;
    @Self
    @Via(type = ResourceSuperType.class)
    private Image image;

    @Override
    public String getSrc() {
        return null != image ? image.getSrc() : null;
    }

    @Override
    public String getAlt() {
        return null != image ? image.getAlt() : null;
    }

    @Override
    public String getTitle() {
        return null != image ? image.getTitle() : null;
    }

    @Override
    public String getText() {
        return StringUtils.isNotBlank(text) ? text : "Default  Text";
    }

    @Override
    public String getExportedType() {
        return ImageCardModelImpl.RESOURCE_TYPE;
    }
}
