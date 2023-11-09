import React from "react";
import { MapTo } from "@adobe/aem-react-editable-components";

const EditConfig = {
  emptyLabel: "Icon",
  isEmpty: function (props) {
    return !props;
  },
};

const Icon = (props) => {
  if (EditConfig.isEmpty(props) || !props.icon) {
    return <p>Icon</p>;
  }
  return (
    <div>
      <p>{props.icon}</p>
    </div>
  );
};

export default Icon;

MapTo("my-kt/components/icon")(Icon, EditConfig);
