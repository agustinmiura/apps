import { render, screen } from "@testing-library/react";

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
