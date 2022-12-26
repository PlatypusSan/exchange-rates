import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ICurrency} from "../models/currency";
import {Injectable} from "@angular/core";
import {IHistoryElement} from "../models/history-element";
@Injectable({
  providedIn: 'root'
})
export class HistoryService {
  placeholderLink: string = 'http://localhost:8080/api/v1/history'
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<IHistoryElement[]> {
    return this.http.get<IHistoryElement[]>(this.placeholderLink)
  }
}
