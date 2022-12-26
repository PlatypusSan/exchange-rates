export class Conversion {
  currencyFrom: string
  currencyTo: string
  valueFrom: number
  valueTo: number

  constructor(currencyFrom: string, currencyTo: string, valueFrom: number, valueTo: number) {
    this.currencyFrom = currencyFrom
    this.currencyTo = currencyTo
    this.valueFrom = valueFrom
    this.valueTo = valueTo
  }
}
