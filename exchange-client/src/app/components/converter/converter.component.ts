import {Component, OnInit} from '@angular/core';
import {CurrencyService} from "../../services/currency.service";
import {ICurrency} from "../../models/currency";

@Component({
  selector: 'app-converter',
  templateUrl: './converter.component.html'
})
export class ConverterComponent implements OnInit {

  loading = false
  currencies: ICurrency[] = []
  currencyFrom: string
  currencyTo: string
  valueFrom: number
  valueTo: number

  constructor(private currencyService: CurrencyService) {
  }

  onCurrencyFromSelectionChange(value: any): void {
    this.currencyFrom = value;
    this.writeToConsole()
  }

  onCurrencyToSelectionChange(value: any): void {
    this.currencyTo = value;
    this.writeToConsole()
  }

  onValueFromChange(value: any): void {
    this.valueFrom = value;
    this.writeToConsole()
  }

  onValueToChange(value: any): void {
    this.valueTo = value;
    this.writeToConsole()
  }

  onSwitchClick() {
    let tmp = this.currencyFrom
    this.currencyFrom = this.currencyTo
    this.currencyTo = tmp
  }

  onSubmitClick(): void {
    console.log('submit clicked')
    this.currencyService.convertCurrency(this.currencyFrom, this.currencyTo, this.valueFrom, this.valueTo)
  }

  writeToConsole() {
    console.log("currencyFrom " + this.currencyFrom + " currencyTo " + this.currencyTo + " valueFrom " + this.valueFrom + " valueTo " + this.valueTo)

  }

  ngOnInit(): void {
    this.currencyService.getAll().subscribe((currencies) => {
      this.currencyFrom = currencies[0].currency
      this.currencyTo = currencies[0].currency
      this.currencies = currencies
    })
  }
}
