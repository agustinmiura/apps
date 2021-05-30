import axios from "axios";
import { useEffect, useState } from "react";
import Row from "react-bootstrap/Row";
import ScoopOption from "./ScoopOption";
import ToppingOption from "./ToppingOption";
import AlertBanner from "../common/AlertBanner";
<<<<<<< HEAD
import { pricePerItem } from "../../constants";
import { useOrderDetails } from "../../contexts/OrderDetails";
=======
>>>>>>> ccd2ac9 (Added more components and tests.)

export default function Options({ optionType }) {
  const [items, setItems] = useState([]);
  const [error, setError] = useState(false);
<<<<<<< HEAD
  const [orderDetails, updateItemCount] = useOrderDetails();
=======
>>>>>>> ccd2ac9 (Added more components and tests.)

  // optionType is 'scoops' or 'toppings'
  useEffect(() => {
    axios
      .get(`http://localhost:3030/${optionType}`)
      .then((response) => setItems(response.data))
<<<<<<< HEAD
      .catch((error) => setError(true));
=======
      .catch((error) => {
        setError(true);
      });
>>>>>>> ccd2ac9 (Added more components and tests.)
  }, [optionType]);

  if (error) {
    // @ts-ignore
    return <AlertBanner />;
  }

  const ItemComponent = optionType === "scoops" ? ScoopOption : ToppingOption;
<<<<<<< HEAD
  const title = optionType[0].toUpperCase() + optionType.slice(1).toLowerCase();
=======
>>>>>>> ccd2ac9 (Added more components and tests.)

  const optionItems = items.map((item) => (
    <ItemComponent
      key={item.name}
      name={item.name}
      imagePath={item.imagePath}
<<<<<<< HEAD
      updateItemCount={(itemName, newItemCount) =>
        updateItemCount(itemName, newItemCount, optionType)
      }
    />
  ));

  return (
    <>
      <h2>{title}</h2>
      <p>{pricePerItem[optionType]} each</p>
      <p>
        {title} total: {orderDetails.totals[optionType]}
      </p>
      <Row>{optionItems}</Row>
    </>
  );
=======
    />
  ));

  return <Row>{optionItems}</Row>;
>>>>>>> ccd2ac9 (Added more components and tests.)
}
