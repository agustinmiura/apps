import Options from "./Options";
<<<<<<< HEAD
import { useOrderDetails } from "../../contexts/OrderDetails";

export default function OrderEntry() {
  const [orderDetails] = useOrderDetails();
  return (
    <div>
      <h1>Design Your Sundae!</h1>
      <Options optionType="scoops" />
      <Options optionType="toppings" />
      <h2>Grand total: {orderDetails.totals.grandTotal}</h2>
=======

export default function OrderEntry() {
  return (
    <div>
      <Options optionType="scoops" />
      <Options optionType="toppings" />
>>>>>>> ccd2ac9 (Added more components and tests.)
    </div>
  );
}
