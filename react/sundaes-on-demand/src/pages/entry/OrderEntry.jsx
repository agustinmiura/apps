import Options from "./Options";
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> f312be6 (Added more features to the ice cream app with functional testing .)
=======
>>>>>>> 9b39699 (Fixed merge)
import { useOrderDetails } from "../../contexts/OrderDetails";

export default function OrderEntry() {
  const [orderDetails] = useOrderDetails();
  return (
    <div>
      <h1>Design Your Sundae!</h1>
      <Options optionType="scoops" />
      <Options optionType="toppings" />
      <h2>Grand total: {orderDetails.totals.grandTotal}</h2>
<<<<<<< HEAD
<<<<<<< HEAD
=======

export default function OrderEntry() {
  return (
    <div>
      <Options optionType="scoops" />
      <Options optionType="toppings" />
>>>>>>> ccd2ac9 (Added more components and tests.)
=======
>>>>>>> f312be6 (Added more features to the ice cream app with functional testing .)
=======
>>>>>>> 9b39699 (Fixed merge)
    </div>
  );
}
