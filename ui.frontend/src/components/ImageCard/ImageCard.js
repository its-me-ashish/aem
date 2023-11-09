import React from "react";
import { MapTo } from "@adobe/aem-react-editable-components";
const EditConfig = {
  emptyLabel: "Image Card",
  isEmpty: function (props) {
    return !props;
  },
};
const ImageCard = (props) => {
  if (EditConfig.isEmpty(props)  || !props.src) {
    return <p>Image Card</p>;
  }
  return (
    <div>
      <img
        className="image"
        src={props.src}
        alt={props.alt}
        title={props.title ? props.title : props.alt}
      />
      <p>{props.text}</p>
    </div>
  );
};

export default ImageCard;

MapTo("my-kt/components/imagecard")(ImageCard, EditConfig);
