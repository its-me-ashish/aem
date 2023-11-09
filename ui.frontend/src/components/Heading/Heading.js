import React from "react";
import { MapTo } from "@adobe/aem-react-editable-components";

const EditConfig = {
  emptyLabel: "Heading",
  isEmpty: function (props) {
    return !props;
  },
};

const Heading = (props) => {
  if (EditConfig.isEmpty(props) || !props.text) {
    return <h1>Default Heading Text</h1>;
  }
  
  return <h1 onClick={()=>console.log(("Clicked"))}>{props.text}  </h1>;
};
export default Heading;

MapTo("my-kt/components/heading")(Heading, EditConfig);
