<<<<<<< HEAD
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";

export default function ToppingOption({ name, imagePath, updateItemCount }) {
  return (
    <Col xs={6} sm={4} md={3} lg={2} style={{ textAlign: "center" }}>
=======
import React from "react";
import Col from "react-bootstrap/Col";

export default function ToppingOption({ name, imagePath, updateItemCount }) {
  return (
    <Col xs={12} sm={6} md={4} lg={3} style={{ textAlign: "center" }}>
>>>>>>> ccd2ac9 (Added more components and tests.)
      <img
        style={{ width: "75%" }}
        src={`http://localhost:3030/${imagePath}`}
        alt={`${name} topping`}
      />
<<<<<<< HEAD
      <Form.Group controlId={`${name}-topping-checkbox`}>
        <Form.Check
          type="checkbox"
          onChange={(e) => {
            updateItemCount(name, e.target.checked ? 1 : 0);
          }}
          label={name}
        />
      </Form.Group>
=======
>>>>>>> ccd2ac9 (Added more components and tests.)
    </Col>
  );
}
