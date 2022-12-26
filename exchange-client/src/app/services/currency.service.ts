import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ICurrency} from "../models/currency";
import {Conversion} from "../models/conversion";
import {Injectable} from "@angular/core";
@Injectable({
  providedIn: 'root'
})
export class CurrencyService {
  placeholderLink: string = 'http://localhost:8080/api/v1/currencies'
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<ICurrency[]> {
    return this.http.get<ICurrency[]>(this.placeholderLink)
  }

  convertCurrency(currencyFrom: string, currencyTo: string, valueFrom: number, valueTo: number): void{

    let conversion = new Conversion(currencyFrom, currencyTo, valueFrom, valueTo);
    const body = {currencyFrom: currencyFrom, currencyTo: currencyTo, valueFrom: valueFrom, valueTo: valueTo};
    console.log(body)
    this.http.post('http://localhost:8080/api/v1/currency', body).subscribe((result) => {
      console.log(result)
    })
  }
}
