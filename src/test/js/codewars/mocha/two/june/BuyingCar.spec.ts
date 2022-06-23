import { assert } from 'chai';

function testing(
  startPriceOld: number,
  startPriceNew: number,
  savingperMonth: number,
  percentLossByMonth: number,
  expected: number[]
) {
  assert.deepEqual(
    nbMonths(startPriceOld, startPriceNew, savingperMonth, percentLossByMonth),
    expected
  );
}

describe("Buying car", function () {
  it("basic tests", function () {
    testing(2000, 8000, 1000, 1.5, [6, 766]);
    testing(12000, 8000, 1000, 1.5, [0, 4000]);
  });
});

export function nbMonths(
  startPriceOld: number,
  startPriceNew: number,
  savingperMonth: number,
  percentLossByMonth: number
): number[] {
  if (startPriceOld >= startPriceNew) return [0, startPriceOld - startPriceNew];

  let savePerMonth = savingperMonth;

  let day = 1;
  while (startPriceOld < startPriceNew) {
    if (day % 2 === 0) percentLossByMonth += 0.5;

    startPriceOld -= (startPriceOld * percentLossByMonth) / 100;
    startPriceNew -= (startPriceNew * percentLossByMonth) / 100;

    // console.log(`end month ${day} percent_loss  ${percentLossByMonth} available ${startPriceOld + savingperMonth - startPriceNew}`)

    if (savingperMonth + startPriceOld > startPriceNew) {
      return [day, Math.round(savingperMonth + startPriceOld - startPriceNew)];
    }

    savingperMonth += savePerMonth;
    day++;
  }
}
