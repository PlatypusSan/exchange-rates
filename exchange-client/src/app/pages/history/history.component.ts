import {Component, Input, OnInit} from '@angular/core';
import {IHistoryElement} from "../../models/history-element";
import {HistoryService} from "../../services/history.service";

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
})
export class HistoryComponent implements OnInit{

  @Input() historyElement: IHistoryElement
  historyElements: IHistoryElement[] = []

  constructor(private historyService: HistoryService) {
  }
  ngOnInit(): void {
    this.historyService.getAll().subscribe((historyElements) => {
      this.historyElements = historyElements;
    })
  }
}
