<<<<<<< HEAD
<<<<<<< HEAD
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";

export default function ToppingOption({ name, imagePath, updateItemCount }) {
  return (
    <Col xs={6} sm={4} md={3} lg={2} style={{ textAlign: "center" }}>
=======
import React from "react";
=======
>>>>>>> f312be6 (Added more features to the ice cream app with functional testing .)
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";

export default function ToppingOption({ name, imagePath, updateItemCount }) {
  return (
<<<<<<< HEAD
    <Col xs={12} sm={6} md={4} lg={3} style={{ textAlign: "center" }}>
>>>>>>> ccd2ac9 (Added more components and tests.)
=======
    <Col xs={6} sm={4} md={3} lg={2} style={{ textAlign: "center" }}>
>>>>>>> f312be6 (Added more features to the ice cream app with functional testing .)
      <img
        style={{ width: "75%" }}
        src={`http://localhost:3030/${imagePath}`}
        alt={`${name} topping`}
      />
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> f312be6 (Added more features to the ice cream app with functional testing .)
      <Form.Group controlId={`${name}-topping-checkbox`}>
        <Form.Check
          type="checkbox"
          onChange={(e) => {
            updateItemCount(name, e.target.checked ? 1 : 0);
          }}
          label={name}
        />
      </Form.Group>
<<<<<<< HEAD
=======
>>>>>>> ccd2ac9 (Added more components and tests.)
=======
>>>>>>> f312be6 (Added more features to the ice cream app with functional testing .)
    </Col>
  );
}
