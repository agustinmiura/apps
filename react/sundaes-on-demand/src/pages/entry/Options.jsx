import axios from "axios";
import { useEffect, useState } from "react";
import Row from "react-bootstrap/Row";
import ScoopOption from "./ScoopOption";
import ToppingOption from "./ToppingOption";
import AlertBanner from "../common/AlertBanner";
<<<<<<< HEAD
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
=======
import { pricePerItem } from "../../constants";
import { useOrderDetails } from "../../contexts/OrderDetails";
>>>>>>> 9b39699 (Fixed merge)

export default function Options({ optionType }) {
  const [items, setItems] = useState([]);
  const [error, setError] = useState(false);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
  const [orderDetails, updateItemCount] = useOrderDetails();
=======
>>>>>>> ccd2ac9 (Added more components and tests.)
=======
  const [orderDetails, updateItemCount] = useOrderDetails();
>>>>>>> f312be6 (Added more features to the ice cream app with functional testing .)
=======
  const [orderDetails, updateItemCount] = useOrderDetails();
>>>>>>> 9b39699 (Fixed merge)

  // optionType is 'scoops' or 'toppings'
  useEffect(() => {
    axios
      .get(`http://localhost:3030/${optionType}`)
      .then((response) => setItems(response.data))
<<<<<<< HEAD
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
=======
      .catch((error) => setError(true));
>>>>>>> 9b39699 (Fixed merge)
  }, [optionType]);

  if (error) {
    // @ts-ignore
    return <AlertBanner />;
  }

  const ItemComponent = optionType === "scoops" ? ScoopOption : ToppingOption;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
  const title = optionType[0].toUpperCase() + optionType.slice(1).toLowerCase();
=======
>>>>>>> ccd2ac9 (Added more components and tests.)
=======
  const title = optionType[0].toUpperCase() + optionType.slice(1).toLowerCase();
>>>>>>> f312be6 (Added more features to the ice cream app with functional testing .)
=======
  const title = optionType[0].toUpperCase() + optionType.slice(1).toLowerCase();
>>>>>>> 9b39699 (Fixed merge)

  const optionItems = items.map((item) => (
    <ItemComponent
      key={item.name}
      name={item.name}
      imagePath={item.imagePath}
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 9b39699 (Fixed merge)
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
<<<<<<< HEAD
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
=======
>>>>>>> 9b39699 (Fixed merge)
}
