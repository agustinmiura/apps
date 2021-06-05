<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> f312be6 (Added more features to the ice cream app with functional testing .)
=======
>>>>>>> 9b39699 (Fixed merge)
import {
  render,
  screen,
  waitFor,
} from "../../../test-utils/testing-library-utils";
<<<<<<< HEAD
<<<<<<< HEAD
=======
import { render, screen, waitFor } from "@testing-library/react";
>>>>>>> ccd2ac9 (Added more components and tests.)
=======
>>>>>>> f312be6 (Added more features to the ice cream app with functional testing .)
=======
>>>>>>> 9b39699 (Fixed merge)
import OrderEntry from "../OrderEntry";
import { rest } from "msw";
import { server } from "../../../mocks/server";

test("handles errors for scopes and toppings routes", async () => {
  server.resetHandlers(
    rest.get("http://localhost:3030/scoops", (req, res, ctx) =>
      res(ctx.status(500))
    ),
    rest.get("http://localhost:3030/toppings", (req, res, ctx) =>
      res(ctx.status(500))
    )
  );
  render(<OrderEntry />);

  await waitFor(async () => {
    const alerts = await screen.findAllByRole("alert");
    expect(alerts).toHaveLength(2);
  });
});
