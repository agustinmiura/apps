import axios from "axios";
import { useEffect, useState } from "react";
import Row from "react-bootstrap/Row";
import ScoopOption from "./ScoopOption";
import ToppingOption from "./ToppingOption";
import AlertBanner from "../common/AlertBanner";
<<<<<<< HEAD
<<<<<<< HEAD
import { pricePerItem } from "../../constants";
import { useOrderDetails } from "../../contexts/OrderDetails";
=======
>>>>>>> ccd2ac9 (Added more components and tests.)
=======
import { pricePerItem } from "../../constants";
import { useOrderDetails } from "../../contexts/OrderDetails";
>>>>>>> f312be6 (Added more features to the ice cream app with functional testing .)

export default function Options({ optionType }) {
  const [items, setItems] = useState([]);
  const [error, setError] = useState(false);
<<<<<<< HEAD
<<<<<<< HEAD
  const [orderDetails, updateItemCount] = useOrderDetails();
=======
>>>>>>> ccd2ac9 (Added more components and tests.)
=======
  const [orderDetails, updateItemCount] = useOrderDetails();
>>>>>>> f312be6 (Added more features to the ice cream app with functional testing .)

  // optionType is 'scoops' or 'toppings'
  useEffect(() => {
    axios
      .get(`http://localhost:3030/${optionType}`)
      .then((response) => setItems(response.data))
<<<<<<< HEAD
<<<<<<< HEAD
      .catch((error) => setError(true));
=======
      .catch((error) => {
        setError(true);
      });
>>>>>>> ccd2ac9 (Added more components and tests.)
=======
      .catch((error) => setError(true));
>>>>>>> f312be6 (Added more features to the ice cream app with functional testing .)
  }, [optionType]);

  if (error) {
    // @ts-ignore
    return <AlertBanner />;
  }

  const ItemComponent = optionType === "scoops" ? ScoopOption : ToppingOption;
<<<<<<< HEAD
<<<<<<< HEAD
  const title = optionType[0].toUpperCase() + optionType.slice(1).toLowerCase();
=======
>>>>>>> ccd2ac9 (Added more components and tests.)
=======
  const title = optionType[0].toUpperCase() + optionType.slice(1).toLowerCase();
>>>>>>> f312be6 (Added more features to the ice cream app with functional testing .)

  const optionItems = items.map((item) => (
    <ItemComponent
      key={item.name}
      name={item.name}
      imagePath={item.imagePath}
<<<<<<< HEAD
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
=======
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
>>>>>>> f312be6 (Added more features to the ice cream app with functional testing .)
}
