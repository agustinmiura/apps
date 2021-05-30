import { render, screen } from "../../../test-utils/testing-library-utils";

import Options from "../Options";

test("displays image for each scoop", async () => {
  render(<Options optionType="scoops" />);

  const scoopTimes = await screen.findAllByRole("img", {
    name: /scoop$/i,
  });

  expect(scoopTimes).toHaveLength(2);

  const altText = scoopTimes.map((element) => element.alt);

  expect(altText).toEqual(["Chocolate scoop", "Vanilla scoop"]);
});

test("Displays image for each toppings option from server", async () => {
  render(<Options optionType="toppings" />);

  const images = await screen.findAllByRole("img", { name: /topping$/i });
  expect(images).toHaveLength(3);

  const imageTitles = images.map((img) => img.alt);

  expect(imageTitles).toEqual([
    "Cherries topping",
    "M&Ms topping",
    "Hot fudge topping",
  ]);
});
