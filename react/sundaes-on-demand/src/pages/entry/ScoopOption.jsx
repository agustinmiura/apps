import Col from "react-bootstrap/Col";
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> f312be6 (Added more features to the ice cream app with functional testing .)
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";

export default function ScoopOptions({ name, imagePath, updateItemCount }) {
  const handleChange = (event) => {
    updateItemCount(name, event.target.value);
  };
<<<<<<< HEAD

=======

export default function ScoopOptions({ name, imagePath }) {
>>>>>>> ccd2ac9 (Added more components and tests.)
=======

>>>>>>> f312be6 (Added more features to the ice cream app with functional testing .)
  return (
    <Col xs={12} sm={6} md={4} lg={3} style={{ textAlign: "center" }}>
      <img
        style={{ width: "75%" }}
        src={`http://localhost:3030/${imagePath}`}
        alt={`${name} scoop`}
      />
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> f312be6 (Added more features to the ice cream app with functional testing .)
      <Form.Group
        controlId={`${name}-count`}
        as={Row}
        style={{ marginTop: "10px" }}
      >
        <Form.Label column xs="6" style={{ textAlign: "right" }}>
          {name}
        </Form.Label>
        <Col xs="5" style={{ textAlign: "left" }}>
          <Form.Control
            type="number"
            defaultValue={0}
            onChange={handleChange}
          />
        </Col>
      </Form.Group>
<<<<<<< HEAD
=======
>>>>>>> ccd2ac9 (Added more components and tests.)
=======
>>>>>>> f312be6 (Added more features to the ice cream app with functional testing .)
    </Col>
  );
}
