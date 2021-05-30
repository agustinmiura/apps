import Col from "react-bootstrap/Col";
<<<<<<< HEAD
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";

export default function ScoopOptions({ name, imagePath, updateItemCount }) {
  const handleChange = (event) => {
    updateItemCount(name, event.target.value);
  };

=======

export default function ScoopOptions({ name, imagePath }) {
>>>>>>> ccd2ac9 (Added more components and tests.)
  return (
    <Col xs={12} sm={6} md={4} lg={3} style={{ textAlign: "center" }}>
      <img
        style={{ width: "75%" }}
        src={`http://localhost:3030/${imagePath}`}
        alt={`${name} scoop`}
      />
<<<<<<< HEAD
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
=======
>>>>>>> ccd2ac9 (Added more components and tests.)
    </Col>
  );
}
